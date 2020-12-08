package com.jeremiahzucker.pandroid.models

import com.jeremiahzucker.pandroid.network.PandoraApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@Serializable(with = Response.Serializer::class)
sealed class Response<T> {

    class ResponseFailedException(val failure: Failure<*>) : Exception(failure.toString())

    val success: Success<T> get() = when (this) {
        is Success<T> -> this
        is Failure<*> -> throw ResponseFailedException(this)
    }

    @Serializable
    @SerialName("ok")
    data class Success<T>(
        val result: T,
    ) : Response<T>()

    @Serializable
    @SerialName("fail")
    data class Failure<T>(
        val message: String,
        val code: Int,
    ) : Response<T>()

    class Serializer<T>(private val serializer: KSerializer<T>) : JsonContentPolymorphicSerializer<Response<*>>(Response::class) {
        override fun selectDeserializer(element: JsonElement) =  when (val stat = (element as? JsonObject)?.get("stat")) {
            JsonPrimitive("ok") -> Success.serializer(serializer)
            JsonPrimitive("fail") -> Failure.serializer(serializer)
            else -> throw SerializationException("stat=$stat not recognized")
        }
    }

}

fun main() {
    PandoraApi().json.apply {
        decodeFromString<Response<Map<String, String>>>("""
{
    "stat": "fail",
    "message": "u suk",
    "code": 9
}
        """).let(::println)

        decodeFromString(Response.serializer(MapSerializer(String.serializer(), String.serializer())), """
{
    "stat": "ok",
    "result": { "a": "b" }
}
        """).let(::println)

        decodeFromString<Response<Map<String, String>>>("""
{
    "stat": "ok",
    "result": { "a": "b" }
}
        """).let(::println)
    }
}

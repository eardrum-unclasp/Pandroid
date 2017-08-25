package com.jz.pandroid.request.method.exp.user

import com.jz.pandroid.request.method.Method
import com.jz.pandroid.request.model.SyncTokenRequestBody

/**
 * Created by Jeremiah Zucker on 8/22/2017.
 * https://6xq.net/pandora-apidoc/json/play/#user-sleepsong
 */
object SleepSong: Method() {
    data class RequestBody(
            val trackToken: String
    ) : SyncTokenRequestBody(TokenType.USER)
}
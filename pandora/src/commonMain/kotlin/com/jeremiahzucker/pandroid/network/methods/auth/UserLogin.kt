package com.jeremiahzucker.pandroid.network.methods.auth

import com.jeremiahzucker.pandroid.network.methods.BaseMethod
import com.jeremiahzucker.pandroid.network.methods.PartnerRequestBody
import kotlinx.serialization.Serializable

/**
 * Created by jzucker on 7/2/17.
 * https://6xq.net/pandora-apidoc/json/authentication/#user-login
 */
object UserLogin : BaseMethod() {

    @Serializable
    data class RequestBody(
        val username: String,
        val password: String,
        val loginType: String = "user",
        val returnGenreStations: Boolean = false,
        val returnCapped: Boolean = false,
        val includePandoraOneInfo: Boolean = false,
        val includeDemographics: Boolean = false,
        val includeAdAttributes: Boolean = false,
        val returnStationList: Boolean = false,
        val includeStationArtUrl: Boolean = false,
        val includeStationSeeds: Boolean = false,
        val includeShuffleInsteadOfQuickMix: Boolean = false,
        val stationArtSize: String? = null,
        val returnCollectTrackLifetimeStats: Boolean = false,
        val returnIsSubscriber: Boolean = false,
        val xplatformAdCapable: Boolean = false,
        val complimentarySponsorSupported: Boolean = false,
        val includeSubscriptionExpiration: Boolean = false,
        val returnHasUsedTrial: Boolean = false,
        val returnUserstate: Boolean = false,
        val includeAccountMessage: Boolean = false,
        val includeUserWebname: Boolean = false,
        val includeListeningHours: Boolean = false,
        val includeFacebook: Boolean = false,
        val includeTwitter: Boolean = false,
        val includeDailySkipLimit: Boolean = false,
        val includeSkipDelay: Boolean = false,
        val includeGoogleplay: Boolean = false,
        val includeShowUserRecommendations: Boolean = false,
    ) : PartnerRequestBody()

    @Serializable
    data class ResponseBody(
        val userId: String,
        val userAuthToken: String,
        val stationCreationAdUrl: String,
        val hasAudioAds: Boolean,
        val splashScreenAdUrl: String,
        val videoAdUrl: String,
        val username: String,
        val canListen: Boolean,
        val nowPlayingAdUrl: String? = null,
        val listeningTimeoutMinutes: String,
        val maxStationsAllowed: Int,
        val listeningTimeoutAlertMsgUri: String,
        val userProfileUrl: String,
        val minimumAdRefreshInterval: Int,
    )
}
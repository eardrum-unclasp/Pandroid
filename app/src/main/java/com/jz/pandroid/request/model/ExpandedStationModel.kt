package com.jz.pandroid.request.model

/**
 * Created by Jeremiah Zucker on 8/25/2017.
 */
data class ExpandedStationModel(
        val suppressVideoAds: Boolean,
        val isQuickMix: Boolean,
        val stationId: String,
        val stationDetailUrl: String,
        val isShared: Boolean,
        val dateCreated: DateModel,
        val stationToken: String,
        val stationName: String,
        val stationSharingUrl: String,
        val requiresCleanAds: Boolean,
        val allowRename: Boolean,
        val allowAddMusic: Boolean,
        val quickMixStationIds: List<String>,
        val allowDelete: Boolean,
        val allowEditDescription: Boolean
)
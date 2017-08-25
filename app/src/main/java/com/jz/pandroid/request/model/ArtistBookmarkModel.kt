package com.jz.pandroid.request.model

/**
 * Created by Jeremiah Zucker on 8/25/2017.
 */
data class ArtistBookmarkModel(
        val musicToken: String,
        val artistName: String,
        val artUrl: String,
        val bookmarkToken: String,
        val dateCreated: DateModel
)
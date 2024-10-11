package de.ashman.ontrack.media.model

import kotlinx.serialization.Serializable

@Serializable
data class BoardGame(
    override val id: String,
    override val type: MediaType = MediaType.BOARDGAME,
    override val name: String,
    override val consumeStatus: StatusType? = null,
    override val userRating: Float? = null,
    override val coverUrl: String,
    val yearPublished: String?,
    val minPlayers: String?,
    val maxPlayers: String?,
    val playingTime: String?,
    val description: String?,
    val minAge: String?,
    val thumbnail: String?,
    val ratings: Ratings?,
) : Media()

@Serializable
data class Ratings(
    val usersRated: Int?,
    val average: Double?,
    val numWeights: Int?,
    val averageWeight: Double?,
)
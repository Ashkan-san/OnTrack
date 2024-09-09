package de.ashman.ontrack.videogame.model

import kotlinx.serialization.Serializable

@Serializable
class VideoGameDto(
    val id: String,
    val name: String? = null
)
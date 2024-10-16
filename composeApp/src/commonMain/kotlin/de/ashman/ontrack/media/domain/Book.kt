package de.ashman.ontrack.media.domain

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    override val id: String,
    override val type: MediaType = MediaType.BOOK,
    override val name: String,
    override val consumeStatus: StatusType? = StatusType.CATALOG,
    override val userRating: Float = 0F,
    override val coverUrl: String,
    val authorKey: List<String>? = null,
    val authorName: List<String>? = null,
    val description: String? = null,
    val firstPublishYear: Int? = null,
    val firstSentence: List<String>? = null,
    val language: List<String>? = null,
    val numberOfPagesMedian: Int? = null,
    val person: List<String>? = null,
    val place: List<String>? = null,
    val publisher: List<String>? = null,
    val ratingsAverage: Double? = null,
    val ratingsCount: Int? = null,
    val subject: List<String>? = null,
) : Media()

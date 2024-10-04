package de.ashman.ontrack.media.book.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSearchResponseDto(
    @SerialName("docs")
    val books: List<BookDto> = emptyList(),

    val numFound: Int,
    val numFoundExact: Boolean? = null,
    val offset: Int?,
    @SerialName("q")
    val query: String,
    val start: Int,
)
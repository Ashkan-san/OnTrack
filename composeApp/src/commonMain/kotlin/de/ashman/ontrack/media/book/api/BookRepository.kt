package de.ashman.ontrack.media.book.api

import de.ashman.ontrack.media.book.model.domain.Book
import de.ashman.ontrack.media.book.model.dto.BookDto
import de.ashman.ontrack.media.book.model.dto.BookSearchResponseDto
import de.ashman.ontrack.media.book.model.dto.BookWorksResponseDto
import de.ashman.ontrack.xyz.MediaRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class BookRepository(
    private val httpClient: HttpClient,
) : MediaRepository<Book> {

    override suspend fun fetchMediaByKeyword(keyword: String): List<Book> {
        // TODO CHANGE SO THAT WE ONLY GET TITLE AND COVER URL HERE!!! REST COMES FROM MEDIA DETAILS AFTERWARDS
        val response: BookSearchResponseDto = httpClient.get("search.json") {
            //parameter("fields", "title, cover_i")
            parameter("title", keyword)
        }.body()
        return response.books.map { it.toDomain() }
    }

    override suspend fun fetchMediaDetails(id: String): Book {
        // TODO kein plan wie am besten
        val response: BookDto = httpClient.get("${id}.json") {
            parameter("fields", "title, description")
        }.body()

        return response.toDomain()
    }
}
package de.ashman.ontrack.media.album.api

import de.ashman.ontrack.media.album.model.domain.Album
import de.ashman.ontrack.media.album.model.domain.Track
import de.ashman.ontrack.media.album.model.dto.AlbumDto
import de.ashman.ontrack.media.album.model.dto.AlbumResponseDto
import de.ashman.ontrack.media.album.model.dto.TrackDto

fun AlbumDto.toDomain(): Album {
    return Album(
        id = id,
        name = name,
        artists = artists.map { it.name },
        genres = genres,
        imageUrl = images.firstOrNull()?.url,
        label = label,
        popularity = popularity,
        releaseDate = releaseDate,
        spotifyUrl = externalUrls.spotify,
        totalTracks = totalTracks,
        tracks = tracks?.items?.map { it.toDomain() } ?: emptyList()
    )
}

fun TrackDto.toDomain(): Track {
    return Track(
        id = id,
        artists = artists.map { it.name },
        durationMs = durationMs,
        name = name,
        previewUrl = previewUrl,
        trackNumber = trackNumber,
        url = externalUrls.spotify
    )
}

fun AlbumResponseDto.toDomain(): List<Album> {
    return this.items.map { it.toDomain() }
}

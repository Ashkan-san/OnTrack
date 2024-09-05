package de.ashman.ontrack

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import de.ashman.ontrack.boardgame.ui.BoardGameViewModel
import de.ashman.ontrack.book.ui.BookViewModel
import de.ashman.ontrack.movie.ui.MovieViewModel
import de.ashman.ontrack.show.ui.ShowViewModel
import de.ashman.ontrack.videogame.VideoGameViewModel
import org.koin.compose.koinInject

@Composable
fun Test(
    movieViewModel: MovieViewModel = koinInject(),
    showViewModel: ShowViewModel = koinInject(),
    bookViewModel: BookViewModel = koinInject(),
    videoGameViewModel: VideoGameViewModel = koinInject(),
    boardGameViewModel: BoardGameViewModel = koinInject(),
) {
    val movieState by movieViewModel.uiState.collectAsState()
    val showState by showViewModel.uiState.collectAsState()
    val bookState by bookViewModel.uiState.collectAsState()
    val gameState by videoGameViewModel.uiState.collectAsState()
    val bgState by boardGameViewModel.uiState.collectAsState()

    LazyColumn {
        item { Text("BOARD GAMES", style = MaterialTheme.typography.titleLarge) }
        item { if (bgState.boardGames.isNotEmpty()) Text("${bgState.boardGames.first()}") }
        item { Text("GAMES", style = MaterialTheme.typography.titleLarge) }
        item { if (gameState.games.isNotEmpty()) Text("${gameState.games.first()}") }
        item { Text("MOVIES", style = MaterialTheme.typography.titleLarge) }
        item { if (movieState.movies.isNotEmpty()) Text("${movieState.movies.first()}") }
        item { Text("SHOWS", style = MaterialTheme.typography.titleLarge) }
        item { if (showState.shows.isNotEmpty()) Text("${showState.shows.first()}") }
        item { Text("BOOKS", style = MaterialTheme.typography.titleLarge) }
        item { if (bookState.books.isNotEmpty()) Text("${bookState.books.first()}") }
    }
}

package com.raejz.sc.bus.movie.model

/**
 *
 */
data class MovieDTO (
    val title: String? = null,
    val year: Int? = null,
    val actorIds: List<String>? = null
)
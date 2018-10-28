package com.raejz.sc.bus.movie.model

import com.raejz.sc.bus.common.model.BaseDoc
import java.util.*

/**
 *
 */
data class Movie(
        val year: Int? = null,
        val title: String? = null,
        val synopsis: String? = null,
        val actorIds: List<String>? = null,
        override var createAt: Date? = null,
        override var modifyAt: Date? = null
) : BaseDoc()
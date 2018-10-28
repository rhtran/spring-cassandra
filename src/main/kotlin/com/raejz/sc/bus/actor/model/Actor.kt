package com.raejz.sc.bus.actor.model

import com.datastax.driver.mapping.annotations.Column
import com.datastax.driver.mapping.annotations.PartitionKey
import com.datastax.driver.mapping.annotations.Table
import com.raejz.sc.bus.common.model.BaseDoc
import java.util.*
import javax.validation.constraints.NotNull

/**
 *
 */
@Table(name = "actor")
data class Actor(
        @NotNull
        @PartitionKey
        val id: UUID? = null,

        @Column(name = "first_name")
        val firstName: String? = null,

        @Column(name = "last_name")
        val lastName: String? = null,

        @Column(name = "date_of_birth")
        val birthDate: String? = null,

        val bio: String? = null,

        @Column(name = "create_at")
        override var createAt: Date? = null,

        @Column(name = "modify_at")
        override var modifyAt: Date? = null
) : BaseDoc()
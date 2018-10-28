package com.raejz.sc.bus.common.model

import com.datastax.driver.mapping.annotations.Column
import java.util.*

/**
 *
 */
open class BaseDoc (
    @Column(name = "create_at")
    open var createAt: Date? = null,

    @Column(name = "modify_at")
    open var modifyAt: Date? = null
)
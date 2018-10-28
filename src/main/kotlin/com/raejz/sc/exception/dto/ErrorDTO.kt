package com.raejz.sc.exception.dto

/**
 *
 */
data class ErrorDTO (
        var status: Int = 0,
        var errorCode: String? = null,
        var message: String? = null,
        var errors: List<String>? = null,
        var timestamp: String? = null
)
// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.llama_stack_client.api.services.blocking

import com.llama_stack_client.api.core.RequestOptions
import com.llama_stack_client.api.models.RunSheidResponse
import com.llama_stack_client.api.models.SafetyRunShieldParams

interface SafetyService {

    fun runShield(
        params: SafetyRunShieldParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RunSheidResponse
}

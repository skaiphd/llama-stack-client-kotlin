// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.llama_stack_client.api.services.async

import com.llama_stack_client.api.core.RequestOptions
import com.llama_stack_client.api.models.ShieldGetParams
import com.llama_stack_client.api.models.ShieldListParams
import com.llama_stack_client.api.models.ShieldSpec

interface ShieldServiceAsync {

    suspend fun list(
        params: ShieldListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ShieldSpec

    suspend fun get(
        params: ShieldGetParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ShieldSpec?
}

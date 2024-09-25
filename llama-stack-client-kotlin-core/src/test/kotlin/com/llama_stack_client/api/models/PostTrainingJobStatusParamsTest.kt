// File generated from our OpenAPI spec by Stainless.

package com.llama_stack_client.api.models

import com.llama_stack_client.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PostTrainingJobStatusParamsTest {

    @Test
    fun createPostTrainingJobStatusParams() {
        PostTrainingJobStatusParams.builder().jobUuid("job_uuid").build()
    }

    @Test
    fun getQueryParams() {
        val params = PostTrainingJobStatusParams.builder().jobUuid("job_uuid").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("job_uuid", listOf("job_uuid"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = PostTrainingJobStatusParams.builder().jobUuid("job_uuid").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("job_uuid", listOf("job_uuid"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}

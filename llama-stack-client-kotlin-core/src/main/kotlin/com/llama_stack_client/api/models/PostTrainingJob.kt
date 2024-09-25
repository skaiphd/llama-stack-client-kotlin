// File generated from our OpenAPI spec by Stainless.

package com.llama_stack_client.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.llama_stack_client.api.core.ExcludeMissing
import com.llama_stack_client.api.core.JsonField
import com.llama_stack_client.api.core.JsonMissing
import com.llama_stack_client.api.core.JsonValue
import com.llama_stack_client.api.core.NoAutoDetect
import com.llama_stack_client.api.core.toUnmodifiable
import java.util.Objects

@JsonDeserialize(builder = PostTrainingJob.Builder::class)
@NoAutoDetect
class PostTrainingJob
private constructor(
    private val jobUuid: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun jobUuid(): String = jobUuid.getRequired("job_uuid")

    @JsonProperty("job_uuid") @ExcludeMissing fun _jobUuid() = jobUuid

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PostTrainingJob = apply {
        if (!validated) {
            jobUuid()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostTrainingJob &&
            this.jobUuid == other.jobUuid &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = Objects.hash(jobUuid, additionalProperties)
        }
        return hashCode
    }

    override fun toString() =
        "PostTrainingJob{jobUuid=$jobUuid, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var jobUuid: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(postTrainingJob: PostTrainingJob) = apply {
            this.jobUuid = postTrainingJob.jobUuid
            additionalProperties(postTrainingJob.additionalProperties)
        }

        fun jobUuid(jobUuid: String) = jobUuid(JsonField.of(jobUuid))

        @JsonProperty("job_uuid")
        @ExcludeMissing
        fun jobUuid(jobUuid: JsonField<String>) = apply { this.jobUuid = jobUuid }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): PostTrainingJob =
            PostTrainingJob(jobUuid, additionalProperties.toUnmodifiable())
    }
}

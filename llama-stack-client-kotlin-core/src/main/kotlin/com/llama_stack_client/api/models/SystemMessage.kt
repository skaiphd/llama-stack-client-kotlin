// File generated from our OpenAPI spec by Stainless.

package com.llama_stack_client.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.llama_stack_client.api.core.BaseDeserializer
import com.llama_stack_client.api.core.BaseSerializer
import com.llama_stack_client.api.core.Enum
import com.llama_stack_client.api.core.ExcludeMissing
import com.llama_stack_client.api.core.JsonField
import com.llama_stack_client.api.core.JsonMissing
import com.llama_stack_client.api.core.JsonValue
import com.llama_stack_client.api.core.NoAutoDetect
import com.llama_stack_client.api.core.getOrThrow
import com.llama_stack_client.api.core.toUnmodifiable
import com.llama_stack_client.api.errors.LlamaStackClientInvalidDataException
import java.util.Objects

@JsonDeserialize(builder = SystemMessage.Builder::class)
@NoAutoDetect
class SystemMessage
private constructor(
    private val content: JsonField<Content>,
    private val role: JsonField<Role>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun content(): Content = content.getRequired("content")

    fun role(): Role = role.getRequired("role")

    @JsonProperty("content") @ExcludeMissing fun _content() = content

    @JsonProperty("role") @ExcludeMissing fun _role() = role

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): SystemMessage = apply {
        if (!validated) {
            content()
            role()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SystemMessage &&
            this.content == other.content &&
            this.role == other.role &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    content,
                    role,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "SystemMessage{content=$content, role=$role, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<Content> = JsonMissing.of()
        private var role: JsonField<Role> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(systemMessage: SystemMessage) = apply {
            this.content = systemMessage.content
            this.role = systemMessage.role
            additionalProperties(systemMessage.additionalProperties)
        }

        fun content(content: Content) = content(JsonField.of(content))

        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<Content>) = apply { this.content = content }

        fun role(role: Role) = role(JsonField.of(role))

        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

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

        fun build(): SystemMessage =
            SystemMessage(
                content,
                role,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): String? = string

        fun strings(): List<String>? = strings

        fun isString(): Boolean = string != null

        fun isStrings(): Boolean = strings != null

        fun asString(): String = string.getOrThrow("string")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Content = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw LlamaStackClientInvalidDataException("Unknown Content: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Content && this.string == other.string && this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "Content{string=$string}"
                strings != null -> "Content{strings=$strings}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }
        }

        companion object {

            fun ofString(string: String) = Content(string = string)

            fun ofStrings(strings: List<String>) = Content(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw LlamaStackClientInvalidDataException("Unknown Content: $json")
            }
        }

        class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Content(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Content(strings = it, _json = json)
                }

                return Content(_json = json)
            }
        }

        class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Role && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val SYSTEM = Role(JsonField.of("system"))

            fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            SYSTEM,
        }

        enum class Value {
            SYSTEM,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SYSTEM -> Value.SYSTEM
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SYSTEM -> Known.SYSTEM
                else -> throw LlamaStackClientInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}

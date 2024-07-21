package com.aallam.openai.api.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The contents of the chat message.
 */
@Serializable
public sealed interface Content

@JvmInline
@Serializable
public value class TextOnlyContent(public val content: String) : Content

/**
 *  The chat message content as a list of content parts.
 */
@JvmInline
@Serializable
public value class ListContent(public val content: List<ContentPart>) : Content

/**
 * Represents a chat message part.
 */
@Serializable
public sealed interface ContentPart

/**
 * Text content part.
 *
 * @param text the text content.
 */
@Serializable
@SerialName("text")
public data class TextPart(@SerialName("text") val text: String) : ContentPart

/**
 * Image content part.
 *
 * @param imageUrl the image url.
 */
@Serializable
@SerialName("image_url")
public data class ImagePart(
    @SerialName("image_url") val imageUrl: ImageURL,
) : ContentPart {

    /**
     * Image content part.
     *
     * @param url either a URL of the image or the base64 encoded image data.
     * @param detail specifies the detail level of the image.
     */
    public constructor(url: String, detail: String? = null) : this(ImageURL(url = url, detail = detail))

    /**
     * Image content part data.
     */
    @Serializable
    public data class ImageURL(

        /**
         * Either a URL of the image or the base64 encoded image data.
         */
        @SerialName("url") val url: String,

        /**
         * Specifies the detail level of the image.
         */
        @SerialName("detail") val detail: String? = null,
    )
}

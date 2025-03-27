package com.aallam.openai.api.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * References an image File in the content of a message.
 */
@Serializable
public data class ImageUrl(
    /**
     * The File ID of the image in the message content.
     */
    @SerialName("url") val url: String,
    @SerialName("detail") val detail: String?
)

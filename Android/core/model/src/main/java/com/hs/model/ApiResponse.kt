package com.hs.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T?,
    @SerializedName("timeStamp")
    val timeStamp: String
) {
    val isSuccess: Boolean
        get() = code in 200..299
}

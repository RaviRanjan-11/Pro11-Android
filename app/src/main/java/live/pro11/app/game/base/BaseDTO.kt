package live.pro11.app.game.base

import com.google.gson.annotations.SerializedName

data class BaseDTO<T>(
    @SerializedName("data") val responseDTO: T,
    val error: List<String>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
)
package live.pro11.app.game.base

data class BaseDTO<T>(
    val responseDTO: T,
    val error: List<String>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
)
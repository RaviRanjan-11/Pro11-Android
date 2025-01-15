package live.pro11.app.game.networking

sealed class NetworkError : Exception() {
    object InvalidURL : NetworkError()
    data class ServerError(val statusCode: Int, override val message: String?) : NetworkError()
    object DecodingError : NetworkError()
    object EncodingError : NetworkError()
    object UnknownError : NetworkError()
}
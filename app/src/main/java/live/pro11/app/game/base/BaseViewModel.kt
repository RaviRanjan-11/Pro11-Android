package live.pro11.app.game.base
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Enum to represent API call states
sealed class ApiState<out T> {
    data object Loading : ApiState<Nothing>()
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error(val message: String) : ApiState<Nothing>()
}


open class BaseViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _apiState = MutableStateFlow<ApiState<Any>>(ApiState.Loading)
    val apiState: StateFlow<ApiState<Any>> = _apiState.asStateFlow()

    fun showLoader() {
        _isLoading.value = true
        _apiState.value = ApiState.Loading
    }

    fun hideLoader() {
        _isLoading.value = false
    }

    fun <T : Any> setSuccessState(data: T) {
        _apiState.value = ApiState.Success(data)
        hideLoader()  // ✅ Hiding the loader on success
    }

    fun setErrorState(message: String) {
        _apiState.value = ApiState.Error(message)
        hideLoader()  // ✅ Hiding the loader on error
    }
}

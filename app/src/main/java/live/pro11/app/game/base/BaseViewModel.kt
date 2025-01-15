package live.pro11.app.game.base
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// Enum to represent API call states
sealed class ApiState<out T> {
    data object Loading : ApiState<Nothing>()
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error(val message: String) : ApiState<Nothing>()
}

open class BaseViewModel : ViewModel() {

    // LiveData for handling the loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    // LiveData for API state (Loading, Success, Error)
    private val _apiState = MutableLiveData<ApiState<Any>>()
    val apiState: LiveData<ApiState<Any>> get() = _apiState

    // Method to show the loader
    fun showLoader() {
        _isLoading.value = true
    }

    // Method to hide the loader
    fun hideLoader() {
        _isLoading.value = false
    }

}

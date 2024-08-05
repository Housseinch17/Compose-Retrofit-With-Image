package com.example.composeretrofitwithimageloading.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeretrofitwithimageloading.data.uistate.MarsResponse
import com.example.composeretrofitwithimageloading.data.uistate.MarsUiState
import com.example.composeretrofitwithimageloading.domain.usecase.MarsPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MarsViewModel @Inject constructor(
    private val marsPhotosUseCase: MarsPhotosUseCase
) : ViewModel() {
    private val _marsUiState = MutableStateFlow(MarsUiState())
    val marsUiState = _marsUiState.asStateFlow()


    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            _marsUiState.update {
                it.copy(
                    marsResponse = try {
                        val listResult = marsPhotosUseCase.execute()
                        MarsResponse.Success(listResult)
                    } catch (e: IOException) {
                        MarsResponse.Error
                    } catch (e: HttpException) {
                        MarsResponse.Error
                    }
                )
            }
        }
    }

}
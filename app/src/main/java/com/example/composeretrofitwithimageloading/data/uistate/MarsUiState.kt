package com.example.composeretrofitwithimageloading.data.uistate

import com.example.composeretrofitwithimageloading.data.model.MarsItem

data class MarsUiState(
    val marsResponse: MarsResponse = MarsResponse.Loading
)

sealed interface MarsResponse{
    data class Success(val photos: List<MarsItem>) : MarsResponse
    data object Error : MarsResponse
    data object Loading : MarsResponse
}

package com.example.composeretrofitwithimageloading.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composeretrofitwithimageloading.domain.usecase.MarsPhotosUseCase
import javax.inject.Inject

class MarsViewModelFactory @Inject constructor(
    private val marsPhotosUseCase: MarsPhotosUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarsViewModel::class.java)) {
            return MarsViewModel(marsPhotosUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

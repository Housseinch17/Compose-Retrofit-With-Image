package com.example.composeretrofitwithimageloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeretrofitwithimageloading.domain.usecase.MarsPhotosUseCase
import com.example.composeretrofitwithimageloading.ui.screens.HomeScreen
import com.example.composeretrofitwithimageloading.ui.theme.ComposeRetrofitWithImageLoadingTheme
import com.example.composeretrofitwithimageloading.ui.viewmodel.MarsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeRetrofitWithImageLoadingTheme {
                val viewModel: MarsViewModel = hiltViewModel()
                val marsUiState by viewModel.marsUiState.collectAsStateWithLifecycle()

                HomeScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp), marsResponse = marsUiState.marsResponse)
                }
            }
        }
    }

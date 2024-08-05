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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composeretrofitwithimageloading.ui.screens.HomeScreen
import com.example.composeretrofitwithimageloading.ui.theme.ComposeRetrofitWithImageLoadingTheme
import com.example.composeretrofitwithimageloading.ui.viewmodel.MarsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeRetrofitWithImageLoadingTheme {
                val marsViewModel: MarsViewModel = hiltViewModel()
                val marsUiState by marsViewModel.marsUiState.collectAsStateWithLifecycle()

                HomeScreen(modifier = Modifier.fillMaxSize().padding(10.dp), marsResponse = marsUiState.marsResponse)
                }
            }
        }
    }

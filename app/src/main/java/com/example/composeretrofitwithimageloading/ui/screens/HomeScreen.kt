package com.example.composeretrofitwithimageloading.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composeretrofitwithimageloading.R
import com.example.composeretrofitwithimageloading.data.model.MarsItem
import com.example.composeretrofitwithimageloading.data.uistate.MarsResponse

@Composable
fun HomeScreen(modifier: Modifier,marsResponse: MarsResponse){
    when(marsResponse){
       is MarsResponse.Success -> ResultScreen(modifier = modifier, marsUiState = marsResponse.photos)
        MarsResponse.Error -> ErrorScreen(modifier = modifier)
        MarsResponse.Loading -> LoadingScreen(modifier = modifier)
    }
}

@Composable
fun ResultScreen(modifier: Modifier,marsUiState: List<MarsItem>){
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(marsUiState){ item->
            MarsItemComponent(modifier = Modifier.fillMaxWidth().height(100.dp), item = item)
        }
    }
}

@Composable
fun MarsItemComponent(modifier: Modifier,item: MarsItem){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.image)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.loading),
        contentDescription = stringResource(id = R.string.loading),
        contentScale = ContentScale.Crop,
        modifier = modifier.size(200.dp)
    )
}


@Composable
fun ErrorScreen(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.connectionerror),
            contentDescription = stringResource(
                id = R.string.failed_to_load
            )
        )
        Text(
            text = stringResource(id = R.string.failed_to_load),
            modifier = Modifier,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
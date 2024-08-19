package com.example.galleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galleryapp.ui.theme.GalleryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalleryAppTheme {
                GalleryLayout()
            }
        }
    }
}

@Composable
fun GalleryLayout() {
    val images = listOf(
        ImageData(R.drawable.rabbit, R.string.rabbit_name, R.string.rabbit_desc),
        ImageData(R.drawable.cat, R.string.cat_name, R.string.cat_desc),
        ImageData(R.drawable.dog, R.string.dog_name, R.string.dog_desc)
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        val currentImage = images[currentIndex]
        ImageWithText(
            imageRes = currentImage.imageRes,
            nameRes = currentImage.nameRes,
            descRes = currentImage.descRes,
            modifier = Modifier
                .wrapContentSize()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    // move currentIndex backwards
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else images.size - 1
                },
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Backward"
                )
            }

            IconButton(
                onClick = {
                    //move currentIndex forwards
                    currentIndex = (currentIndex + 1) % images.size
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward),
                    contentDescription = "Forward"
                )
            }
        }
    }
}

@Composable
fun ImageWithText(
    @DrawableRes imageRes: Int,
    @StringRes nameRes: Int,
    @StringRes descRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row {
            Image(
                painter = painterResource(imageRes), contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column {
            Text(
                text = stringResource(id = nameRes), fontSize = 16.sp, modifier = Modifier
                    .padding(bottom = 4.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(id = descRes), fontSize = 12.sp, modifier = Modifier
                    .padding(bottom = 2.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGalleryLayout() {

    GalleryLayout()
}


data class ImageData(
    @DrawableRes val imageRes: Int,
    @StringRes val nameRes: Int,
    @StringRes val descRes: Int
)

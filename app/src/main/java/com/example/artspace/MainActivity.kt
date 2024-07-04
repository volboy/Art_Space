package com.example.artspace

import android.content.res.Configuration
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtWorkScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtWorkScreen(modifier: Modifier = Modifier) {
    val arts = getSamples()
    var index by remember { mutableIntStateOf(0) }
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        ImageWithTitle(
            art = arts[index],
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
        NavigationButtons(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter),
            previousOnClick = {
                index--
                if (index < 0) index = arts.size - 1
            },
            nextOnClick = {
                index++
                if (index > arts.size - 1) index = 0
            }
        )
    }
}

@Composable
fun ImageWithTitle(
    art: Art,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val painter = painterResource(id = art.image)
        val imageRatio = painter.intrinsicSize.width / painter.intrinsicSize.height
        val config = LocalConfiguration.current.orientation
        Image(
            painter = painter,
            contentDescription = art.title,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .width(if (config == Configuration.ORIENTATION_PORTRAIT) 300.dp else 150.dp)
                .height(if (config == Configuration.ORIENTATION_PORTRAIT) 400.dp else 150.dp)
                .aspectRatio(imageRatio)
                .shadow(16.dp)
        )
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = art.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Spacer(modifier = modifier.height(12.dp))
        Text(
            text = stringResource(
                id = R.string.artwork_title,
                art.artist,
                art.year
            ),
            fontSize = 14.sp,
            modifier = modifier
        )
        Spacer(modifier = modifier.height(12.dp))
    }
}

@Composable
fun NavigationButtons(
    previousOnClick: () -> Unit,
    nextOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.width(300.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Button(
            onClick = previousOnClick,
            modifier = modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = stringResource(id = R.string.previous_btn))
        }
        Spacer(modifier = modifier.width(12.dp))
        Button(
            onClick = nextOnClick,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.next_btn))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtWorkScreen(Modifier)
    }
}
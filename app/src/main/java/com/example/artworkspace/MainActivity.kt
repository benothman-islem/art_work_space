package com.example.artworkspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artworkspace.ui.theme.ArtWorkSpaceTheme

data class Artwork(
    val image: Int,
    val title: String,
    val artist: String,
    val year: Int
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtWorkSpaceTheme {
                ArtworkApp()
            }
        }
    }
}

@Composable
fun ArtworkApp() {
    val artworks = listOf(
        Artwork(R.drawable.artwork1, "Artwork 1", "Artist 1", 2022),
        Artwork(R.drawable.artwork2, "Artwork 2", "Artist 2", 2021),
        Artwork(R.drawable.artwork3, "Artwork 3", "Artist 3", 2020)
    )
    var currentArtworkIndex by remember { mutableStateOf(0) }
    val artwork = artworks[currentArtworkIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = artwork.image),
            contentDescription = artwork.title,
            modifier = Modifier
                .size(280.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        Text(
            text = artwork.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = "${artwork.artist} (${artwork.year})",
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    currentArtworkIndex--
                },
                enabled = currentArtworkIndex > 0,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Previous")
            }

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Button(
                onClick = {
                    currentArtworkIndex++
                },
                enabled = currentArtworkIndex < artworks.size - 1,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Next")
            }
        }
    }
}

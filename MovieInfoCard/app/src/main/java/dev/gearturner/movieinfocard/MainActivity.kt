package dev.gearturner.movieinfocard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gearturner.movieinfocard.ui.theme.MovieInfoCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieInfoCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MovieInfoCard(
                        title = "Back to the Future",
                        stars = 5,
                        length = "1:56",
                        lang = "Eng",
                        rating = "9.3",
                        numReviews = 111
                    )
                }
            }
        }
    }
}

@Composable
fun MovieInfoCard(
    title: String,
    stars: Int,
    length: String,
    lang: String,
    rating: String,
    numReviews: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        PosterSection(title, stars)
        InfoSection(length, lang, rating, numReviews)
    }
}

@Composable
fun InfoSection(
    length: String,
    lang: String,
    rating: String,
    numReviews: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(vertical = 72.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier.padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Length")
            Text(
                text = length,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier.padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Lang")
            Text(
                text = lang,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier.padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Rating")
            Text(
                text = rating,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier.padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Reviews")
            Text(
                text = numReviews.toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PosterSection(
    title: String,
    stars: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(550.dp)) {
        Image(
            painter = painterResource(id = R.drawable.poster),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(450.dp)
                .clip(RoundedCornerShape(percent = 10))
        )
        Row(modifier = modifier.offset(y = 400.dp)) {
            Image(
                painter = painterResource(id = R.drawable.poster),
                contentDescription = null,
                modifier = modifier
                    .height(150.dp)
                    .padding(start = 40.dp)
                    .clip(RoundedCornerShape(percent = 20))
            )
            Column(modifier.padding(start = 16.dp)) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    modifier = modifier
                        .offset(y = 72.dp)
                )
                Row {
                    repeat(times = stars) {
                        Icon(
                            Icons.Filled.Star,
                            contentDescription = null,
                            tint = Color.Yellow,
                            modifier = modifier.offset(y = 100.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieInfoCardPreview() {
    MovieInfoCardTheme {
        MovieInfoCard(
            title = "Back to the Future",
            stars = 5,
            length = "1:56",
            lang = "Eng",
            rating = "9.3",
            numReviews = 111
        )
    }
}





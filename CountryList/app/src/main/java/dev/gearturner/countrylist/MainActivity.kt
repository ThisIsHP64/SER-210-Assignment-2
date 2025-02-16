package dev.gearturner.countrylist

import Country
import CountryList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.gearturner.countrylist.ui.theme.CountryListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryListTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CountriesScrollableList()
                }
            }
        }
    }
}

@Composable
fun CountriesScrollableList(modifier: Modifier = Modifier) {
    LazyColumn {
        items(CountryList) { country ->
            Column {
                CountryRow(country)
                HorizontalDivider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun CountryRow(country: Country, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp).fillMaxWidth()
    ) {
        Image(
            painter = painterResource(country.flag),
            contentDescription = null,
            modifier = modifier.size(50.dp)
        )
        Column(modifier.padding(start = 8.dp)) {
            Text(
                text = "Country: ${country.name}",
                fontSize = 12.sp
            )
            Text(
                text = "Currency: ${country.currency}",
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryListPreview() {
    CountryListTheme {
        CountriesScrollableList()
    }
}



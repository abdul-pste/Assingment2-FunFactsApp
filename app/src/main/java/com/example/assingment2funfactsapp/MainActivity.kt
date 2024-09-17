package com.example.assingment2funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assingment2funfactsapp.ui.theme.Assingment2FunFactsAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assingment2FunFactsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FunFactsScreen(modifier: Modifier = Modifier) {
    val funFacts = listOf(
        "The creator of *One Piece*, Eiichiro Oda, has stated that the series was inspired by his childhood dream of becoming a pirate.",
        "Luffy's straw hat is a symbol of the series and was originally given to him by the character Shanks, who is one of the Four Emperors of the sea.",
        "The character of Monkey D. Luffy was named after a monkey, inspired by the popular Chinese novel 'Journey to the West'.",
        "In the world of *One Piece*, the Grand Line is a dangerous and mysterious sea route that is said to be the most perilous place in the world.",
        "The Straw Hat Pirates' ship, the Going Merry, is a beloved character in its own right, and its journey with the crew is one of the most emotional arcs in the series."
    )

    var currentFactIndex by remember { mutableStateOf(Random.nextInt(funFacts.size)) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = funFacts[currentFactIndex],
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            currentFactIndex = Random.nextInt(funFacts.size)
        }) {
            Text("Next Fact")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactsScreenPreview() {
    Assingment2FunFactsAppTheme {
        FunFactsScreen()
    }
}

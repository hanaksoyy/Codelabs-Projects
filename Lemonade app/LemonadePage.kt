package com.example.lemonade

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LemonadeApp(){
    AppBar()
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val description = when (currentStep) {
        1 -> "Tap the lemon  tree to select a lemon"
        2 -> "keep tapping the lemon  to squeeze it"
        3 -> "Tap the lemon  tree to select a lemon lemonade to drink it"
        else -> "tap the empty glassto start again"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(description, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = description,
            modifier = Modifier
                .size(200.dp)
                .clickable{
                        when (currentStep) {
                        1 -> {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                        2 -> {
                        squeezeCount--
                        if (squeezeCount <= 0) {
                            currentStep = 3
                        }
                    }
                        3 -> currentStep = 4
                        else -> currentStep = 1
                    }




            }
        )
    }
}

@Composable
fun AppBar(){
    TopAppBar(
        title = {
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("Lemonade", fontWeight = FontWeight.Bold   )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFF5E04A)
        )

    )
}
























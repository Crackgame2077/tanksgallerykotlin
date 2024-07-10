package com.example.tanks

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tanks.ui.theme.TanksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TanksTheme {
                tanksApp()
            }
        }
    }
}


@Composable
fun tanksApp() {
    var currentStep by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> TextandImage(
                textID = R.string.t_72b,
                imageID = R.drawable.t_72b,
                descriptionID = R.string.desT72b,
                nextClick = { currentStep = 2 },
                previousClick = { currentStep = 4 }
            )
            2 -> TextandImage(
                textID = R.string.t_90a,
                imageID = R.drawable.t_90a,
                descriptionID = R.string.desT90a,
                nextClick = { currentStep = 3 },
                previousClick = { currentStep = 3 }
            )
            3 -> TextandImage(
                textID = R.string.t_90m,
                imageID = R.drawable.t_90m,
                descriptionID = R.string.desT90m,
                nextClick = { currentStep = 4 },
                previousClick = { currentStep = 2 }
            )
            4 -> TextandImage(
                textID = R.string.t_72b3,
                imageID = R.drawable.t_72b3,
                descriptionID = R.string.desT72b3,
                nextClick = { currentStep = 1 },
                previousClick = { currentStep = 3 }
            )

        }
    }
}

@Composable
fun TextandImage(
    textID : Int,
    imageID : Int,
    descriptionID : Int,
    nextClick : () -> Unit,
    previousClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = imageID),
            contentDescription = stringResource(id = descriptionID),
            modifier = modifier.wrapContentSize()
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(id = textID),
            fontSize = 24.sp,
            modifier = modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(){
            Button(
                onClick = { previousClick() },
            ) {
                Text(text = stringResource(R.string.previous), fontSize = 24.sp)
            }
            Button(
                onClick = { nextClick() },
            ) {
                Text(text = stringResource(R.string.next), fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TanksTheme {
        tanksApp()
    }
}
package com.example.projetolimao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetolimao.ui.theme.ProjetoLimaoTheme
import java.util.IdentityHashMap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoLimaoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    appLimonada()
                }
            }
        }
    }
}
@Preview
@Composable
fun appLimonada(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {


        var tela by remember { mutableStateOf(1) }

        var espremer by remember { mutableStateOf(1) }


        when (tela) {
            1 -> ConteudoApp(
                R.string.limoeiro,
                R.drawable.limoeiro
            ) {
                tela = 2
                espremer = (2..4).random()
            }

            2 -> ConteudoApp(
                R.string.limao,
                R.drawable.espremer_limao
            ) {
                if (espremer > 1)
                    espremer--
                else
                    tela = 3

            }

            3 -> ConteudoApp(
                R.string.copo_de_limonada,
                R.drawable.limoeiro,
                onImagemClick = {
                    tela = 4
                }
            )
        }


    }


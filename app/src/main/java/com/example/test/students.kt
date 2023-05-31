package com.example.test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.ui.theme.TestTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp


class students : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
    val context = LocalContext.current
    // Estado para controlar a seleção do primeiro Card
    var isCard1Selected by remember { mutableStateOf(false) }

    // Estado para controlar a seleção do segundo Card
    var isCard2Selected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000)) // Preto
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color(android.graphics.Color.parseColor("#3347B0")))
                .border(2.dp, Color.Black) // Adicionando borda de 2.dp com cor preta
        ) {
            // Conteúdo da Row
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        // Coloque a ação desejada aqui
                        // Por exemplo, abrir uma nova Activity
                        toGoBackActivity(context)
                    }
            )

            Spacer(modifier = Modifier.width(280.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_menu),
                contentDescription = "",
                tint = Color.White, // Definindo a cor do ícone como branco
                modifier = Modifier.padding(8.dp) // Adicione um espaçamento interno se necessário
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color(android.graphics.Color.parseColor("#3347B0")))
                .border(2.dp, Color.Black) // Adicionando borda de 2.dp com cor preta
        ) {
            // Conteúdo da Row

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        isCard1Selected = true
                        isCard2Selected = false
                    },
                backgroundColor = if (isCard1Selected) {
                    Color.Red // Cor de fundo quando selecionado
                } else {
                    Color(android.graphics.Color.parseColor("#FFA500")) // Cor de fundo normal
                }
            )
            {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.studying),
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        isCard1Selected = false
                        isCard2Selected = true
                    },
                backgroundColor = if (isCard2Selected) {
                    Color.Red // Cor de fundo quando selecionado
                } else {
                    Color(android.graphics.Color.parseColor("#2E8B57")) // Cor de fundo normal
                }
            )
            {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.Finished),
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.Yellow),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Card(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        openActivityStudent(context)
                    }

            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF3347B0))
                        .height(270.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)

                    ) {
                        Image(
                            painter = painterResource(R.drawable.person),
                            contentDescription = "Descrição da imagem",
                            modifier = Modifier
                                .size(150.dp)
                        )
                        Text(
                            text = "Jose Almeida Silva ",
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        openActivityStudent(context)
                    }

            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFFFEB57))
                        .height(270.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)

                    ) {
                        Image(
                            painter = painterResource(R.drawable.person),
                            contentDescription = "Descrição da imagem",
                            modifier = Modifier
                                .size(150.dp)
                        )
                        Text(
                            text = "Jose Almeida Silva ",
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                    }
                }
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TestTheme {
        Greeting2("Android")
    }
}


fun openActivityStudent(context: Context) {
    val intent = Intent(context, student::class.java)
    context.startActivity(intent)
}

fun toGoBackActivity(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}
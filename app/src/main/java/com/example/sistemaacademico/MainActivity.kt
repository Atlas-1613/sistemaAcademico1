package com.example.sistemaacademico

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material.icons.Icons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SistemaAcademico()
        }
    }
}

// Cores do tema CPS
private val VermelhoCPS = Color(0xFFE30613)
private val PretoCPS = Color(0xFF121212)

// Cores do tema alternativo
private val Azul = Color(0xFF1565C0)
private val AzulEscuro = Color(0xFF0D1B2A)


@Composable
fun SistemaAcademico() {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }

    var mensagem by remember { mutableStateOf("") }

    // Controla qual tema está sendo utilizado
    var temaCPS by remember { mutableStateOf(true) }

    MaterialTheme(
        colorScheme = if (temaCPS) {
            darkColorScheme(
                primary = VermelhoCPS,
                background = PretoCPS
            )
        } else {
            darkColorScheme(
                primary = Azul,
                background = AzulEscuro
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.etecclogo),
                contentDescription = "Logo da ETEC São Mateus",
                modifier = Modifier
                    .height(100.dp)
            )

            // Título
            Text(
                text = "SISTEMA ACADÊMICO",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = if (temaCPS) VermelhoCPS else Azul
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Subtítulo
            Text(
                text = "Cadastro de Aluno",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = if (temaCPS) VermelhoCPS else Azul
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Nome
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = {
                    Text("Nome")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // E-mail
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text("E-mail")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Idade
            OutlinedTextField(
                value = idade,
                onValueChange = {
                    if (
                        it.all { caractere -> caractere.isDigit() } &&
                        it.length <= 3
                    ) {
                        idade = it
                    }
                },
                label = {
                    Text("Idade")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Curso
            OutlinedTextField(
                value = curso,
                onValueChange = { curso = it },
                label = {
                    Text("Curso")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // CPF
            OutlinedTextField(
                value = cpf,
                onValueChange = {
                    if (
                        it.all { caractere -> caractere.isDigit() } &&
                        it.length <= 11
                    ) {
                        cpf = it
                    }
                },
                label = { Text("CPF") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Telefone
            OutlinedTextField(
                value = telefone,
                onValueChange = {
                    if (
                        it.all { caractere -> caractere.isDigit() } &&
                        it.length <= 11
                    ) {
                        telefone = it
                    }
                },
                label = {
                    Text("Telefone")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botão Cadastrar
            Button(
                onClick = {

                    if (
                        nome.isBlank() ||
                        email.isBlank() ||
                        idade.isBlank() ||
                        curso.isBlank() ||
                        cpf.isBlank() ||
                        telefone.isBlank()
                    ) {

                        mensagem = "Preencha todos os campos!"

                    } else if (!email.contains("@") || !email.contains(".")) {

                        mensagem = "Digite um e-mail válido!"

                    } else if (idade.toIntOrNull() == null || idade.toInt() <= 0) {

                        mensagem = "Digite uma idade válida!"

                    } else if (cpf.length != 11) {

                        mensagem = "CPF deve ter 11 números!"

                    } else if (telefone.length < 10) {

                        mensagem = "Telefone inválido!"

                    } else {

                        mensagem = "Cadastro realizado com sucesso! 🎓"

                        nome = ""
                        email = ""
                        idade = ""
                        curso = ""
                        cpf = ""
                        telefone = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (temaCPS) {
                        VermelhoCPS
                    } else {
                        Azul
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("👤  CADASTRAR ALUNO")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão para alterar o tema
            TextButton(
                onClick = {
                    temaCPS = !temaCPS
                }
            ) {
                Text(
                    if (temaCPS) {
                        "ALTERAR TEMA"
                    } else {
                        "VOLTAR PARA CPS"
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão Limpar
            TextButton(
                onClick = {

                    nome = ""
                    email = ""
                    idade = ""
                    curso = ""
                    cpf = ""
                    telefone = ""
                    mensagem = ""

                }
            ) {
                Text("LIMPAR")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mensagem
            if (mensagem.isNotBlank()) {

                Text(
                    text = mensagem,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
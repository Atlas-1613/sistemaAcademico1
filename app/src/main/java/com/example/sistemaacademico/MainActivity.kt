package com.example.sistemaacademico

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SistemaAcademico()
        }
    }
}

@Composable
fun SistemaAcademico() {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }

    var mensagem by remember { mutableStateOf("") }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            // Título
            Text(
                text = "SISTEMA ACADÊMICO",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Subtítulo
            Text(
                text = "Cadastro de Aluno",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Nome
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = {
                    Text("Nome")
                },
                modifier = Modifier.fillMaxWidth()
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Idade
            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it },
                label = {
                    Text("Idade")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
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
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // CPF
            OutlinedTextField(
                value = cpf,
                onValueChange = { cpf = it },
                label = {
                    Text("CPF")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Telefone
            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = {
                    Text("Telefone")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botão cadastrar
            Button(
                onClick = {

                    if (
                        nome.isNotBlank() &&
                        email.isNotBlank() &&
                        idade.isNotBlank() &&
                        curso.isNotBlank() &&
                        cpf.isNotBlank() &&
                        telefone.isNotBlank()
                    ) {

                        mensagem = "Cadastro realizado com sucesso! 🎓"

                        nome = ""
                        email = ""
                        idade = ""
                        curso = ""
                        cpf = ""
                        telefone = ""

                    } else {

                        mensagem = "Preencha todos os campos!"

                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("CADASTRAR ALUNO")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão limpar
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
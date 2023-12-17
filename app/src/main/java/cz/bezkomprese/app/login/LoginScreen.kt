package cz.bezkomprese.app.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(){
    val viewModel = viewModel(LoginViewModel::class.java)

    Text(text = "Login")
}
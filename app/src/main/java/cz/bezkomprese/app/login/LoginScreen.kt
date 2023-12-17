package cz.bezkomprese.app.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val viewModel = viewModel(LoginViewModel::class.java)


    Column {


        OutlinedTextField(
            label = { Text(text = "Login") },
            placeholder = { Text(text = "Přezdívka") },
            value = viewModel.email.collectAsState().value,
            supportingText = {
                Text(text = "Zadejte Vaši přezdívku nebo email")
            },
            onValueChange = {
                viewModel.email.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Heslo") },
            placeholder = { Text(text = "Heslo") },
            value = viewModel.password.collectAsState().value,
            supportingText = {
                Text(text = "Zadejte Vaše heslo")
            },
            onValueChange = {
                viewModel.password.value = it
            },
            visualTransformation = PasswordVisualTransformation()
        )
        val error = viewModel.error.collectAsState().value
        if(error != null) {
            Text(text = error)
        }
        Button(onClick = { viewModel.loginClicked() }) {
            Text(text = "Přihlásit")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Registrovat")
        }
    }
}
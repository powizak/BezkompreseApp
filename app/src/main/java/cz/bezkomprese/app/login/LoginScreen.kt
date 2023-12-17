package cz.bezkomprese.app.login

import android.icu.text.Transliterator.Position
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.bezkomprese.app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val viewModel = viewModel(LoginViewModel::class.java)


    Column (modifier = Modifier.padding(10.dp).fillMaxSize()){

        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "", modifier = Modifier.fillMaxWidth())

        OutlinedTextField(
            label = { Text(text = "Login") },
            placeholder = { Text(text = "Přezdívka") },
            value = viewModel.email.collectAsState().value,
            supportingText = {
                Text(text = "Zadejte Vaši přezdívku nebo email")
            },
            onValueChange = {
                viewModel.email.value = it
            },
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp))

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
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
        )
        val error = viewModel.error.collectAsState().value
        if(error != null) {
            Text(text = error)
        }
        Button(onClick = { viewModel.loginClicked() },
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
            Text(text = "Přihlásit")
        }
        OutlinedButton(onClick = { viewModel.registerClicked()},
            modifier = Modifier.fillMaxWidth().align(Alignment.End)) {
            Text(text = "Registrovat")
        }
    }
}
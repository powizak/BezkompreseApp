package cz.bezkomprese.app.registration

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegistrationScreen(){
    val viewModel = viewModel(RegistrationViewModel::class.java)

    Text(text = "Registrace")
}
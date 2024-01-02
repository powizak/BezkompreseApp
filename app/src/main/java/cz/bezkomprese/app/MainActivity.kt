package cz.bezkomprese.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.bezkomprese.app.login.LoginScreen
import cz.bezkomprese.app.registration.RegistrationScreen
import cz.bezkomprese.app.ui.theme.BezkompreseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BezkompreseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavGraph()
                }
            }
        }
    }
}


@Composable
fun MainNavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "registration") {
        composable("login") { LoginScreen() }
        composable("registration") { RegistrationScreen() }
    }
}
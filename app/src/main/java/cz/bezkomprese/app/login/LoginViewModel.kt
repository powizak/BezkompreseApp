package cz.bezkomprese.app.login

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel: ViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    val error = MutableStateFlow<String?>(null)


    fun loginClicked(){
        error.value = null
        FirebaseAuth.getInstance().signInWithEmailAndPassword(
            email.value, password.value
        ).apply {
            addOnCompleteListener {
                if(it.isSuccessful){
                    // TODO
                }else{
                    error.value = it.exception?.toString() ?: ""
                }
            }
        }
    }

    fun registerClicked(){
        //TODO - přesměrovat na obrazovku registrace
    }
}
package cz.bezkomprese.app

import android.app.Application
import com.google.firebase.FirebaseApp

class BezkompreseApp: Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}
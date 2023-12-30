package com.tusxapps.amicumtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import cafe.adriel.voyager.navigator.Navigator
import com.tusxapps.idle.ui.IdleScreen

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigator(IdleScreen())
        }
    }
}

package com.example.telasparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.overscroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.telasparcial.components.UserCard
import com.example.telasparcial.ui.theme.TelasParcialTheme

class ListarContatos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelasParcialTheme {
                Scaffold { innerPadding ->
                    ListarContatosTela(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
@Preview
fun ListarContatosTela(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.scrollable(
            orientation = Orientation.Vertical, reverseDirection = true,
            state = ScrollableState { it },
        )
    ) {
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
        UserCard()
    }
}

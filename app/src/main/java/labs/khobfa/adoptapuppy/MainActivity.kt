package labs.khobfa.adoptapuppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import labs.khobfa.adoptapuppy.ui.screens.PuppyDetailScreen
import labs.khobfa.adoptapuppy.ui.theme.AdoptApuppyTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptApuppyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    PuppyListScreen()
                    PuppyDetailScreen()
                }
            }
        }
    }
}
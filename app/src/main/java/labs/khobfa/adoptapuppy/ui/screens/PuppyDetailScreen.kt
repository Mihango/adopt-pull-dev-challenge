package labs.khobfa.adoptapuppy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import labs.khobfa.adoptapuppy.R
import labs.khobfa.adoptapuppy.ui.theme.AdoptApuppyTheme

@Composable
fun PuppyDetailScreen() {
    PuppyDetail(puppy = puppies[0])
}

@Composable
fun PuppyDetail(puppy: Puppy) {
    Column(modifier = Modifier.fillMaxSize()) {
        CoilImage(
            data = painterResource(id = R.drawable.ic_chihuahua),
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.5f)
        ) {}

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .offset(y = 200.dp)
                .padding(16.dp)
        ) {
            Text(text = puppy.name)

            Text(
                text = "Card is the implementation of a CardView in Compose Card is the implementation of a CardView in Compose" +
                        "Card is the implementation of a CardView in Compose Card is the implementation of a CardView in Compose"
            )
        }
    }
}

@Preview
@Composable
fun PuppyDetailScreenPreview() {
    AdoptApuppyTheme {
        PuppyDetailScreen()
    }
}
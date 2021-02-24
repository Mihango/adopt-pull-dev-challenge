package labs.khobfa.adoptapuppy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import labs.khobfa.adoptapuppy.R
import labs.khobfa.adoptapuppy.ui.theme.AdoptApuppyTheme

sealed class Sex(val gender: String) {
    data class Male(val male: String) : Sex(male)
    data class Female(val female: String) : Sex(female)
}

data class Puppy(
    val name: String,
    val age: Float,
    val breed: String,
    val sex: Sex
)

val puppies = listOf(
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.Male("male")),
    Puppy("Puppy", 0.1f, "Beagle", Sex.Female("female")),
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.Male("male")),
    Puppy("Puppy", 0.1f, "Beagle", Sex.Female("female")),
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.Male("male")),
    Puppy("Puppy", 0.1f, "Beagle", Sex.Female("female")),
)

@Composable
fun PuppyListScreen() {
    PuppyList(puppies = puppies)
}

@Composable
fun PuppyList(
    puppies: List<Puppy>
) {
    Column {
        puppies.forEach { puppy ->
            PuppyCard(puppy)
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.ic_chihuahua),
            contentDescription = "${puppy.breed} bread image",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(80.dp)
        )
        Column {
            Text(
                text = puppy.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = puppy.breed, style = TextStyle(color = Color.White, fontSize = 12.sp))

            Row(
                modifier = Modifier.fillMaxWidth(0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(imageVector = Icons.Default.LockClock, contentDescription = "clock")
                    Text(
                        text = "${puppy.age} months",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }

                Row {
                    Icon(
                        imageVector = if (puppy.sex == Sex.Male("male")) Icons.Default.Male else Icons.Default.Female,
                        contentDescription = "clock"
                    )
                    Text(
                        text = "${puppy.age} months",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PuppyListPreview() {
    AdoptApuppyTheme {
        PuppyListScreen()
    }
}


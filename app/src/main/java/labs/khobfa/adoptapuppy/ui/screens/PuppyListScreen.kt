package labs.khobfa.adoptapuppy.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import labs.khobfa.adoptapuppy.R
import labs.khobfa.adoptapuppy.ui.theme.AdoptApuppyTheme

enum class Sex {
    MALE, FEMALE
}

data class Puppy(
    val name: String,
    val age: Float,
    val breed: String,
    val sex: Sex
)

val puppies = listOf(
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.MALE),
    Puppy("Puppy", 0.1f, "Beagle", Sex.FEMALE),
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.MALE),
    Puppy("Puppy", 0.1f, "Beagle", Sex.FEMALE),
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.MALE),
    Puppy("Puppy", 0.1f, "Beagle", Sex.FEMALE),
    Puppy("Cherry", 0.8f, "King Charles Spaniel", Sex.MALE),
    Puppy("Puppy", 0.1f, "Beagle", Sex.FEMALE),
)

@ExperimentalFoundationApi
@Composable
fun PuppyListScreen() {
    PuppyList(puppies = puppies)
}

@ExperimentalFoundationApi
@Composable
fun PuppyList(
    puppies: List<Puppy>
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        itemsIndexed(puppies) { index, puppy ->
            PuppyCard(
                puppy = puppy,
                if (index % 2 != 0) Modifier
                    .offset(y = 25.dp)
                else Modifier
            ) {
                Log.e("Puppy $index", "name : ${it.name} >>>> selected")
            }
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, modifier: Modifier = Modifier, click: (Puppy) -> Unit) {
    Box(modifier = modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .clickable { click(puppy) }
        .width(120.dp)
        .height(240.dp)
        .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.ic_german),
            contentDescription = "${puppy.breed} bread image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomStart),
        ) {
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
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
                        imageVector = if (puppy.sex == Sex.MALE) Icons.Default.Male else Icons.Default.Female,
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

@ExperimentalFoundationApi
@Preview
@Composable
fun PuppyListPreview() {
    AdoptApuppyTheme {
        PuppyListScreen()
    }
}


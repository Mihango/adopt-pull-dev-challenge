package labs.khobfa.adoptapuppy.ui.screens

import androidx.annotation.DrawableRes
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
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Female
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
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import labs.khobfa.adoptapuppy.R
import labs.khobfa.adoptapuppy.ui.theme.AdoptApuppyTheme

enum class Sex {
    MALE, FEMALE
}

data class Puppy(
    val name: String,
    val age: Float,
    val breed: String,
    val sex: Sex,
    @DrawableRes val image: Int,
    val description: String
)

const val lorem: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"

val puppies = listOf(
    Puppy(
        name = "Cherry",
        age = 0.8f,
        breed = "German Shepherd",
        sex = Sex.MALE,
        image = R.drawable.ic_german,
        description = lorem
    ),
    Puppy(
        name = "Puppy",
        age = 0.1f,
        breed = "Beagle",
        sex = Sex.FEMALE,
        image = R.drawable.ic_cavachon,
        description = lorem
    ),

    Puppy(
        name = "Cherry",
        age = 0.8f,
        breed = "Akita Pit",
        sex = Sex.MALE,
        image = R.drawable.ic_akita_pit,
        description = lorem
    ),

    Puppy(
        name = "Cherry",
        age = 0.8f,
        breed = "King Charles Spaniel",
        sex = Sex.MALE,
        image = R.drawable.ic_spaniel,
        description = lorem
    ),

    Puppy(
        name = "Puppy",
        age = 0.1f,
        breed = "Afador",
        sex = Sex.FEMALE,
        image = R.drawable.ic_afador,
        description = lorem
    ),

    Puppy(
        name = "Puppy",
        age = 0.1f,
        breed = "Beagle",
        sex = Sex.FEMALE,
        image = R.drawable.ic_chihuahua,
        description = lorem
    ),

    Puppy(
        name = "Cherry",
        age = 0.8f,
        breed = "King Charles Spaniel",
        sex = Sex.MALE,
        image = R.drawable.ic_german,
        description = lorem
    ),
    Puppy(
        name = "Puppy",
        age = 0.1f,
        breed = "Beagle",
        sex = Sex.FEMALE,
        image = R.drawable.ic_german,
        description = lorem
    ),
)

@ExperimentalFoundationApi
@Composable
fun PuppyListScreen(navController: NavController?) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        SearchHeader()
        PuppyList(
            navController = navController!!,
            puppies = puppies
        )
    }
}

@Composable
fun SearchHeader() {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Adopt Doggy",
            style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyList(
    navController: NavController,
    puppies: List<Puppy>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .padding(bottom = 5.dp)
    ) {
        itemsIndexed(puppies) { index, puppy ->
            PuppyCard(
                puppy = puppy,
                if (index % 2 != 0) Modifier
                    .offset(y = 25.dp)
                else Modifier
            ) {
                navController.navigate("${MainScreens.Details.route}/$index")
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
        .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(puppy.image),
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
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = puppy.breed,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 13.sp
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Alarm, contentDescription = "clock",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 5.dp)
                    )
                    Text(
                        text = "${puppy.age} months",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                        )
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (puppy.sex == Sex.MALE) Icons.Default.Male else Icons.Default.Female,
                        contentDescription = "clock",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 5.dp)
                    )
                    Text(
                        text = if (puppy.sex == Sex.MALE) "Boy" else "Girl",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
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
        PuppyListScreen(null)
    }
}


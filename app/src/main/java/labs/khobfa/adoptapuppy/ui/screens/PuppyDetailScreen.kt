package labs.khobfa.adoptapuppy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Pin
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

@Composable
fun PuppyDetailScreen(
    navController: NavController?,
    position: Int
) {
    PuppyDetail(puppy = puppies[position]) {
        navController!!.navigate(MainScreens.DashBoard.route) {
            popUpTo = navController.graph.startDestination
        }
    }
}

@Composable
fun PuppyDetail(puppy: Puppy, navigateHome: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_chihuahua),
            contentDescription = puppy.name,
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.6f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .offset(y = -(50.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = puppy.name)
                if (puppy.sex == Sex.MALE)
                    Icon(Icons.Default.Male, "male icon")
                else Icon(Icons.Default.Female, "female icon")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Border collie")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LockClock,
                        contentDescription = "clock"
                    )
                    Spacer(Modifier.width(2.dp))
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(Icons.Default.Pin, "")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "120 N 4th St, Brooklyn, NY, USA")
            }
        }

        Column(
            modifier = Modifier
                .offset(y = -(40).dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = puppy.name)

            Text(
                text = "Card is the implementation of a CardView in Compose Card is the implementation of a CardView in Compose" +
                        "Card is the implementation of a CardView in Compose Card is the implementation of a CardView in Compose"
            )

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = { navigateHome() }) {
                Text(text = "Adoption")
            }
        }


    }
}

@Preview
@Composable
fun PuppyDetailScreenPreview() {
    AdoptApuppyTheme {
        PuppyDetailScreen(null, 0)
    }
}
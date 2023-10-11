package com.farshadchalenges.bazimizi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.farshadchalenges.bazimizi.components.MainPageButtons
import com.farshadchalenges.bazimizi.components.exitDialog


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController) {

    val languageName = remember { mutableStateOf("Fa") }
    val exitDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(id = R.string.app_name)
                        )
                        Text(text = stringResource(id = R.string.app_name), fontSize = 24.sp)
                    }
                },
                actions = {

                    /* should call language class , then it will access to different languages .
                             Button(onClick = {
//                        languageDialog.value = true
              },) {
//                        if (languageDialog.value){
//                            Text(text = language() )
//                            languageDialog.value = false
//                        }
             }
*/
                    Button(
                        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.orange),
                            contentColor = Color.Black
                        ),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(
                            2.dp, colorResource(id = R.color.brown)
                        )
                    ) {
                        Text(
                            text = languageName.value,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.brown),
                    titleContentColor = colorResource(id = R.color.orange)
                )
            )

        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(colorResource(id = R.color.dark_green))
        ) {
            Spacer(modifier = Modifier.height(150.dp))
            //New game Button
            MainPageButtons(text = stringResource(id = R.string.new_game), onClick = {
            })

            //History button
            MainPageButtons(text = stringResource(id = R.string.history), onClick = {
                navController.navigate("GameHistory")
            })

            //Setting button
            MainPageButtons(text = stringResource(id = R.string.setting), onClick = {
                navController.navigate("Setting")
            })

            //Exit Button
            MainPageButtons(text = stringResource(id = R.string.exit), onClick = {
                exitDialog.value = true
            })
        }

        //calling The AlertsDialog for closing the app
        if (exitDialog.value) {
            exitDialog.value = exitDialog()
        }

    }
}
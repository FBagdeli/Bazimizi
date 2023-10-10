package com.farshadchalenges.bazimizi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {

    val exitDialog = remember {
        mutableStateOf(false)
    }
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
                        Text(text = stringResource(id = R.string.app_name))
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    titleContentColor = Color.White
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
        ) {
            Spacer(modifier = Modifier.height(150.dp))

            Button(
                onClick = {
                    //new Game
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    2.dp, colorResource(id = R.color.purple_700)
                ),
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = stringResource(id = R.string.new_game), fontSize = 20.sp)
            }

            Button(
                onClick = {
                    //History
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    2.dp, colorResource(id = R.color.purple_700)
                ),
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = stringResource(id = R.string.history), fontSize = 20.sp)
            }
            Button(
                onClick = {
                    //Settings
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    2.dp, colorResource(id = R.color.purple_700)
                ),
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = stringResource(id = R.string.setting), fontSize = 20.sp)
            }
            Button(
                onClick = {
                    exitDialog.value = true

                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    2.dp, colorResource(id = R.color.purple_700)
                ),
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = stringResource(id = R.string.exit), fontSize = 20.sp)
            }
        }
        if (exitDialog.value) {
            AlertDialog(
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.yellow_warning_icon),
                        contentDescription = "",
                        modifier = Modifier.size(70.dp)
                    )
                },
                onDismissRequest = {
                    exitDialog.value = false
                },
                text = {
                    Text(text = stringResource(id = R.string.do_you_want_to_exit), fontSize = 20.sp, modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
                },

                confirmButton = {
                    Row(modifier = Modifier.width(200.dp)) {
                        Button(
                            onClick = {
                                exitProcess(0)
                            },
                            border = BorderStroke(1.dp, color = Color.Black)
                        ) {
                            Text(text = stringResource(id = R.string.yes))
                        }
                    }


                }, dismissButton = {
                    Row() {
                        Button(
                            onClick = {
                                exitDialog.value = false


                            }, colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.lightGray)
                            ), border = BorderStroke(1.dp, color = Color.Black)
                        ) {
                            Text(text = stringResource(id = R.string.no))
                        }
                    }

                }

            )
        }
    }
}
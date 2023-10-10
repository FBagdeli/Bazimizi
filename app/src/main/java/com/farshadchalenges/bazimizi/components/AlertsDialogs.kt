package com.farshadchalenges.bazimizi.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farshadchalenges.bazimizi.R
import kotlin.system.exitProcess


@Composable
fun alertsDialogs():Boolean{
    val exitDialog = remember {
        mutableStateOf(true)
    }
    AlertDialog(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.warning_icon),
                contentDescription = "",
                modifier = Modifier.size(70.dp)
            )
        },
        onDismissRequest = {
            exitDialog.value = false
        },
        text = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.do_you_want_to_exit),
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            exitDialog.value = false
                        },
                        modifier = Modifier.size(100.dp, 40.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.lightGray)
                        ),
                        border = BorderStroke(1.dp, color = Color.Black)
                    ) {
                        Text(text = stringResource(id = R.string.no))
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            exitProcess(0)
                        }, modifier = Modifier.size(100.dp, 40.dp),
                        border = BorderStroke(1.dp, color = Color.Black)
                    ) {
                        Text(text = stringResource(id = R.string.yes))
                    }
                }
            }


        },
        containerColor = colorResource(id = R.color.purple_200),
        confirmButton = {}
    )
    return exitDialog.value
}
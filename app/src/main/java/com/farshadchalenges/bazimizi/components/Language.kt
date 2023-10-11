package com.farshadchalenges.bazimizi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.farshadchalenges.bazimizi.retrieveLanguage



/*
With this method user will be able to choose the language!
@Composable
fun language(): String {

    val languageName = remember { mutableStateOf("") }
    val dropDownMenu = remember { mutableStateOf(true) }
    val languageList = retrieveLanguage()
    val result = remember { mutableStateOf("") }
    Box() {
        DropdownMenu(
            expanded = dropDownMenu.value,
            onDismissRequest = {
                dropDownMenu.value = false
            }
        ) {
            LazyColumn() {
                items(
                    count = languageList.size,
                    itemContent = { index ->

                        val language = languageList[index]
                        DropdownMenuItem(
                            text = {
                                Row() {
                                    Text(text = language.languageName)
                                }
                            },
                            onClick = {
                                dropDownMenu.value = false
                                languageName.value = language.languageName
                            }
                        )
                    }
                )
            }
        }
    }
    return "languageName.value"
}
*/

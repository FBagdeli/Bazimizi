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
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.farshadchalenges.bazimizi.retrieveLanguage

@Composable
fun language(): Int {
    val result = remember {
        mutableIntStateOf(0)
    }
    val dropDownMenu = remember {
        mutableStateOf(false)
    }
    val languageList = retrieveLanguage()
    Box(Modifier.verticalScroll(state = ScrollState(10))) {

        DropdownMenu(
            expanded = dropDownMenu.value,
            onDismissRequest = { dropDownMenu.value = false }) {
            LazyColumn() {
                items(
                    count = languageList.size,
                    itemContent = { index ->

                        val language = languageList[index]
                        Card {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = language.languageName)
                                Image(
                                    painter = painterResource(id = language.languageImage),
                                    contentDescription = language.languageName,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                    }
                )
            }
        }
    }



    return result.intValue
}
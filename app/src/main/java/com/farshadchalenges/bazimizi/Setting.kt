package com.farshadchalenges.bazimizi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Setting(navController: NavController) {

    Scaffold(
        topBar = {

            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.setting),
                        fontSize = 24.sp,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    navigationIconContentColor = colorResource(id = R.color.orange),
                    containerColor = colorResource(id = R.color.dark_green),
                    titleContentColor = colorResource(id = R.color.orange)
                )
            )
        }
    ) { paddingValues ->
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {

        }
    }

}
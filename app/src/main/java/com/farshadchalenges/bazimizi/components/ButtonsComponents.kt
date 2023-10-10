package com.farshadchalenges.bazimizi.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farshadchalenges.bazimizi.R

@Composable
fun MainPageButtons(text: String, onClick: () -> Unit) {

    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            2.dp, colorResource(id = R.color.brown)
        ),
        modifier = Modifier.size(200.dp, 60.dp)
    ) {
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
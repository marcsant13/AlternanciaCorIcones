package com.marcos.alternariconescompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.marcos.alternariconescompose.R
import com.marcos.alternariconescompose.viewmodel.BottomBarViewModel

@Composable
@Preview
fun BottomBar() {

    val viewModel: BottomBarViewModel = viewModel()
    val statesIcon = viewModel.mapStatesButtons
    val iconAccount = R.drawable.line_md__account
    val iconEmail = R.drawable.line_md__email
    val iconDocument = R.drawable.line_md__document

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 24.dp, end = 24.dp, bottom = 48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Cyan)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Icon(
                    painter = painterResource(iconAccount),
                    contentDescription = null,
                    tint = if (statesIcon.get(iconAccount) == true) Color.White else Color.Black,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            onClick = { viewModel.changeIconColor(iconAccount) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                )
            }
            Column {
                Icon(
                    painter = painterResource(iconEmail),
                    contentDescription = null,
                    tint = if (statesIcon.get(iconEmail) == true) Color.White else Color.Black,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(onClick = { viewModel.changeIconColor(iconEmail) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                )
            }
            Column {
                Icon(
                    painter = painterResource(iconDocument),
                    contentDescription = null,
                    tint = if (statesIcon.get(iconDocument) == true) Color.White else Color.Black,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(onClick = { viewModel.changeIconColor(iconDocument) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                )
            }
        }
    }
}
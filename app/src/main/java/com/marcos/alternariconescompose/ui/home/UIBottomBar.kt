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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.marcos.alternariconescompose.R
import com.marcos.alternariconescompose.navigateSingleTopTo
import com.marcos.alternariconescompose.viewmodel.BottomBarViewModel

@Composable
fun BottomBar(navController: NavController) {

    val viewModel: BottomBarViewModel = viewModel()
    val routeSelected = viewModel.routeColumn
    val iconAccount = R.drawable.line_md__account
    val iconEmail = R.drawable.line_md__email
    val iconDocument = R.drawable.line_md__document
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

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
                    tint = if (currentRoute == "profile") Color.White else Color.Black,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            onClick = {
                                viewModel.checkRoute(iconAccount)
                                //viewModel.changeIconColor()
                                navController.navigateSingleTopTo(routeSelected.value)
                                      },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                )
            }
            Column {
                Icon(
                    painter = painterResource(iconEmail),
                    contentDescription = null,
                    tint = if (currentRoute == "message") Color.White else Color.Black,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(onClick = {
                            viewModel.checkRoute(iconEmail)
                            //viewModel.changeIconColor()
                            navController.navigateSingleTopTo(routeSelected.value)
                        },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                )
            }
            Column {
                Icon(
                    painter = painterResource(iconDocument),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(onClick = {
                            viewModel.checkRoute(iconDocument)
                            //viewModel.changeIconColor()
                            navController.navigateSingleTopTo(routeSelected.value)
                        },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }),
                    tint = if (currentRoute == "document") Color.White else Color.Black,
                )
            }
        }
    }
}
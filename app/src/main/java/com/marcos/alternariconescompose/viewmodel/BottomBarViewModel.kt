package com.marcos.alternariconescompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.marcos.alternariconescompose.R

class BottomBarViewModel : ViewModel() {

    private val _routeColumn = mutableStateOf("profile")
    val routeColumn: State<String> = _routeColumn

    fun checkRoute(idIcon: Int){
        if (idIcon == R.drawable.line_md__email){
            _routeColumn.value = "message"
        }
        if (idIcon == R.drawable.line_md__account){
            _routeColumn.value = "profile"
        }
        if (idIcon == R.drawable.line_md__document){
            _routeColumn.value = "document"
        }
    }
}
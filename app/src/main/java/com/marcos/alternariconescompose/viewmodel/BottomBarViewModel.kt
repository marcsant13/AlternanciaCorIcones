package com.marcos.alternariconescompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.marcos.alternariconescompose.R

class BottomBarViewModel : ViewModel() {
    private val _mapStatesButtons: SnapshotStateMap<Int, Boolean> = mutableStateMapOf()
    val mapStatesButtons: SnapshotStateMap<Int, Boolean> = _mapStatesButtons

    init {
        _mapStatesButtons.put(R.drawable.line_md__account, false)
        _mapStatesButtons.put(R.drawable.line_md__email, false)
        _mapStatesButtons.put(R.drawable.line_md__document, false)
    }

    fun changeIconColor(idIcon: Int) {
        for (item in _mapStatesButtons) {
            if (item.key == idIcon) {
                _mapStatesButtons[item.key] = true
            } else {
                _mapStatesButtons[item.key] = false
            }
        }
    }
}
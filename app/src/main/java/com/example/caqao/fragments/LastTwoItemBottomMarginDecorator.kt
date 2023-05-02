package com.example.caqao.fragments

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LastTwoItemBottomMarginDecorator(private val marginBottom: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        val layoutManager = parent.layoutManager as? GridLayoutManager ?: return
        val spanCount = layoutManager.spanCount
        val childCount = parent.adapter?.itemCount ?: 0
        val childIndex = parent.getChildAdapterPosition(view)
        val lastRowIndex = (childCount - 1) / spanCount
        val lastRowFirstIndex = lastRowIndex * spanCount
        val lastRowLastIndex = minOf(childCount - 1, lastRowFirstIndex + spanCount - 1)

        // Add margin to the bottom of the last row
        if (childIndex in lastRowFirstIndex..lastRowLastIndex) {
            outRect.bottom = marginBottom
        }
    }


}


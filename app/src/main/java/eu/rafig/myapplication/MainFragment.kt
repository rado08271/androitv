/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package eu.rafig.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.Presenter
import androidx.core.content.ContextCompat
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.app.RowsFragment

/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : RowsFragment() {
    companion object {
        private val GRID_ITEM_WIDTH = 200
        private val GRID_ITEM_HEIGHT = 200
        private var NUM_ROWS = 0
        private var NUM_COLS = 5
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadRows()
    }

    private fun loadRows() {
        val list = FakeTitles.LIST

        NUM_ROWS = list.size / NUM_COLS


        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        var j = 0

        for (i in 0 until NUM_ROWS) {
            val listRowAdapter = ArrayObjectAdapter(GridItemPresenter())

            for (x in 0 until NUM_COLS) {
                listRowAdapter.add(list[j++].title)
            }
            rowsAdapter.add(ListRow(listRowAdapter))
        }

        adapter = rowsAdapter
    }

    private inner class GridItemPresenter : Presenter() {
        override fun onCreateViewHolder(parent: ViewGroup): Presenter.ViewHolder {
            val view = TextView(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.setBackgroundColor(ContextCompat.getColor(activity, R.color.default_background))
            view.setTextColor(Color.WHITE)
            view.gravity = Gravity.CENTER
            return Presenter.ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
            (viewHolder.view as TextView).text = item as String
        }

        override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {}
    }


}

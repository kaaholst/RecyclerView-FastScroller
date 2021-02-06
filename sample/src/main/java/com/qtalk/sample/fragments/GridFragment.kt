package com.qtalk.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.qtalk.sample.R
import com.qtalk.sample.adapters.BasicAdapter
import kotlinx.android.synthetic.main.fragment_grid.view.*

class GridFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grid, container, false).apply {
            switch_scroll.setOnClickListener {
                fastScroller.isFastScrollEnabled = !fastScroller.isFastScrollEnabled
                switch_scroll.setText(if (fastScroller.isFastScrollEnabled) R.string.disable_fast_scroll else R.string.enable_fast_scroll)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            with(this.grid_recycler_view) {
                adapter = BasicAdapter(activity)
                layoutManager = GridLayoutManager(activity, 2)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
package com.example.madlevel4task2.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.fragment_game_history.*

class GameHistoryFragment : Fragment() {
    private var gameAdapter = GameAdapter(games)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_history, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvGames.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter
        rvGames.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}
package com.example.madlevel4task2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.R
import com.example.madlevel4task2.model.Game
import com.example.madlevel4task2.model.Moves
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun databind(game: Game) {
            itemView.tvResult.text = game.result.name
            itemView.tvDate.text = game.date.toString()

            var compImageID : Int = when (game.computerMoves) {
                Moves.ROCK -> R.drawable.rock
                Moves.PAPER -> R.drawable.paper
                Moves.SCISSORS -> R.drawable.scissors
            }
            itemView.ivComputer.setImageResource(compImageID)

            var playerImageID : Int = when (game.playerMoves) {
                Moves.ROCK -> R.drawable.rock
                Moves.PAPER -> R.drawable.paper
                Moves.SCISSORS -> R.drawable.scissors
            }
            itemView.ivPlayer.setImageResource(playerImageID)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }
}
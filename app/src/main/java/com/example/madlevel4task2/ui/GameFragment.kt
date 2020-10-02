package com.example.madlevel4task2.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.madlevel4task2.R
import com.example.madlevel4task2.model.Game
import com.example.madlevel4task2.model.Moves
import com.example.madlevel4task2.model.Results
import com.example.madlevel4task2.repository.GameRepository
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.Instant
import java.util.*

val games = arrayListOf<Game>()

class GameFragment : Fragment() {
    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViews () {
        gameRepository = GameRepository(requireContext())

        chooseButton()
    }

    // displays rock, paper or scissors based on button clicked
    @RequiresApi(Build.VERSION_CODES.O)
    private fun chooseButton () {
        btn_rock.setOnClickListener {
            createGame(Moves.ROCK)
        }

        btn_paper.setOnClickListener {
            createGame(Moves.PAPER)
        }

        btn_scissors.setOnClickListener {
            createGame(Moves.SCISSORS)
        }
    }

    // finds correct image ID belonging to the selected move
    private fun setImage (selectionPlayer : Moves) : Int {

        return when (selectionPlayer) {
            Moves.ROCK -> R.drawable.rock
            Moves.PAPER -> R.drawable.paper
            Moves.SCISSORS -> R.drawable.scissors
        }
    }

    // changes the text based on the given result
    private fun setResultsText (result: Results) {
        when (result) {
            Results.DRAW -> tvResult.text = getString(R.string.draw_label)
            Results.LOSE -> tvResult.text = getString(R.string.lose_label)
            Results.WIN -> tvResult.text = getString(R.string.win_label)
        }
    }

    // chooses randomly for the computer and calculates the result
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createGame (selectionPlayer: Moves) {
        var selectionComp = Moves.values().random()
        var result: Results

        // sets the image based on selected button (rock, paper or scissors)
        ivPlayer.setImageResource(setImage(selectionPlayer))
        ivComputer.setImageResource(setImage(selectionComp))

        // calculates the results
        when (selectionPlayer) {
            Moves.ROCK -> {
                result = when (selectionComp) {
                    Moves.ROCK -> Results.DRAW
                    Moves.SCISSORS -> Results.LOSE
                    else -> Results.WIN
                }
            }
            Moves.PAPER -> {
                result = when (selectionComp) {
                    Moves.ROCK -> Results.WIN
                    Moves.SCISSORS -> Results.LOSE
                    else -> Results.DRAW
                }
            }
            Moves.SCISSORS -> {
                result = when (selectionComp) {
                    Moves.ROCK -> Results.LOSE
                    Moves.SCISSORS -> Results.DRAW
                    else -> Results.WIN
                }
            }
        }

        // sets the correct display text
        setResultsText(result)

        mainScope.launch {
            var game = Game(result, selectionPlayer, selectionComp, Date.from(Instant.now()))

            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game)

//                // updates statistics
//                tvStats.text = getString(R.string.statistics, gameRepository.getWins(), gameRepository.getLosses(), gameRepository.getDraws())
            }
        }
    }
}

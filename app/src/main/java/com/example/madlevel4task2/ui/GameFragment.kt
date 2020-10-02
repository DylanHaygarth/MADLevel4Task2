package com.example.madlevel4task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*

const val ROCK = R.drawable.rock
const val PAPER = R.drawable.paper
const val SCISSORS = R.drawable.scissors

class GameFragment : Fragment() {
    private var selectionPlayer : Int = 0


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews () {
        chooseButton()
    }

    // displays rock, paper or scissors based on button clicked
    private fun chooseButton () {
        btn_rock.setOnClickListener {
            selectionPlayer = ROCK
            ivPlayer.setImageResource(selectionPlayer)
            computerGeneration()
        }

        btn_paper.setOnClickListener {
            selectionPlayer = PAPER
            ivPlayer.setImageResource(selectionPlayer)
            computerGeneration()
        }

        btn_scissors.setOnClickListener {
            selectionPlayer = SCISSORS
            ivPlayer.setImageResource(selectionPlayer)
            computerGeneration()
        }
    }

    // chooses randomly for the computer and calculates the result
    private fun computerGeneration () {
        val list = listOf(R.drawable.rock, R.drawable.scissors, R.drawable.paper)
        var selectionComp = list.random()

        ivComputer.setImageResource(selectionComp)

        // calculates the results
        when (selectionPlayer) {
            ROCK -> {
                when (selectionComp) {
                    ROCK -> tvResult.text = getString(R.string.draw_label)
                    SCISSORS -> tvResult.text = getString(R.string.lose_label)
                    else -> tvResult.text = getString(R.string.win_label)
                }
            }
            PAPER -> {
                when (selectionComp) {
                    ROCK -> tvResult.text = getString(R.string.win_label)
                    SCISSORS -> tvResult.text = getString(R.string.lose_label)
                    else -> tvResult.text = getString(R.string.draw_label)
                }
            }
            SCISSORS -> {
                when (selectionComp) {
                    ROCK -> tvResult.text = getString(R.string.lose_label)
                    SCISSORS -> tvResult.text = getString(R.string.draw_label)
                    else -> tvResult.text = getString(R.string.win_label)
                }
            }
        }
    }
}
package com.example.mylifetotal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment

class SelectionScreenFragment : Fragment() {
    private val NUM_OF_PLAYERS = "NUM_OF_PLAYERS"
    private val INITLIFE = "INITLIFE"

    private val defaultNumOfPlayers = 3
    private val defaultLife = 20

    private var numPlayers = defaultNumOfPlayers
    private var lifeAmount = defaultLife

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.selection_screen, container, false)

        val twoPlayers: RadioButton = view.findViewById(R.id.twoPlayersRadioButton)

        val threePlayers: RadioButton = view.findViewById(R.id.threePlayersRadioButton)

        val fourPlayers: RadioButton = view.findViewById(R.id.fourPlayersRadioButton)

        val twentyLives: RadioButton = view.findViewById(R.id.twentyInitLifeButton)

        val thirtyLives: RadioButton = view.findViewById(R.id.thirtyInitLifeButton)

        val fortyLives: RadioButton = view.findViewById(R.id.fortyInitLifeButton)

        twoPlayers.setOnClickListener {
            numPlayers = 2
            uncheckOthers(threePlayers, fourPlayers)
        }

        threePlayers.setOnClickListener {
            numPlayers = 3
            uncheckOthers(twoPlayers, fourPlayers)
        }

        fourPlayers.setOnClickListener {
            numPlayers = 4
            uncheckOthers(twoPlayers, threePlayers)
        }

        twentyLives.setOnClickListener {
            lifeAmount = 20
            uncheckOthers(thirtyLives, fortyLives)
        }

        thirtyLives.setOnClickListener {
            lifeAmount = 30
            uncheckOthers(twentyLives, fortyLives)
        }

        fortyLives.setOnClickListener {
            lifeAmount = 40
            uncheckOthers(twentyLives, thirtyLives)
        }

        val startGame = view.findViewById<Button>(R.id.startButton)
        startGame.setOnClickListener {
            startPlaying(numPlayers, lifeAmount)
        }

        return view
    }

    private fun uncheckOthers(radioButton1: RadioButton, radioButton2: RadioButton) {
        radioButton1.isChecked = false
        radioButton2.isChecked = false
    }

    private fun startPlaying(numPlayers: Int, lifeAmount: Int) {
        val intent = Intent(activity, GameActivity::class.java)
        intent.putExtra(NUM_OF_PLAYERS, numPlayers)
        intent.putExtra(INITLIFE, lifeAmount)
        startActivity(intent)
    }
}
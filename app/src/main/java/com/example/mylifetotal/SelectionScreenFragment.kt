package com.example.mylifetotal

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
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
    private val WEBPAGE = "http://www.google.com"

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

        val mp: MediaPlayer = MediaPlayer.create(context, R.raw.click)

        twoPlayers.setOnClickListener {
            numPlayers = 2
            uncheckOthers(threePlayers, fourPlayers)
            mp.start()
        }

        threePlayers.setOnClickListener {
            numPlayers = 3
            uncheckOthers(twoPlayers, fourPlayers)
            mp.start()
        }

        fourPlayers.setOnClickListener {
            numPlayers = 4
            uncheckOthers(twoPlayers, threePlayers)
            mp.start()
        }

        twentyLives.setOnClickListener {
            lifeAmount = 20
            uncheckOthers(thirtyLives, fortyLives)
            mp.start()
        }

        thirtyLives.setOnClickListener {
            lifeAmount = 30
            uncheckOthers(twentyLives, fortyLives)
            mp.start()
        }

        fortyLives.setOnClickListener {
            lifeAmount = 40
            uncheckOthers(twentyLives, thirtyLives)
            mp.start()
        }

        val startGame = view.findViewById<Button>(R.id.startButton)
        startGame.setOnClickListener {
            startPlaying(numPlayers, lifeAmount)
            mp.start()
        }

        val aboutUs = view.findViewById<Button>(R.id.about_us_button)
        aboutUs.setOnClickListener {
            openWebpage(WEBPAGE)
            mp.start()
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

    private fun openWebpage(uriString: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uriString))
        startActivity(browserIntent)
    }
}
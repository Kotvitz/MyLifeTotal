package com.example.mylifetotal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class GameActivity : AppCompatActivity() {
    private val NUM_OF_PLAYERS = "NUM_OF_PLAYERS"
    private val INITLIFE = "INITLIFE"

    private var life = 0
    private var numOfPlayers = 0
    private var colorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val extras = intent.extras

        if (extras != null) {
            numOfPlayers = extras.getInt(NUM_OF_PLAYERS)
            life = extras.getInt(INITLIFE)
        }

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        var fragment : Fragment = SelectionScreenFragment()

        when(numOfPlayers) {
            2 -> fragment = TwoPlayers()
            3 -> fragment = ThreePlayers()
            4 -> fragment = FourPlayers()
        }

        fragmentTransaction.add(R.id.game_activity, fragment)
        fragmentTransaction.commit()
    }

    private fun addLifePoint(lifetotal: TextView) {
        lifetotal.text = (lifetotal.text.toString().toInt() + 1).toString()
    }

    private fun subtractLifePoint(lifetotal: TextView) {
        lifetotal.text = (lifetotal.text.toString().toInt() - 1).toString()
    }

    private fun changePlayerBackgroundColor(playerColor: View) {
        colorIndex += 1

        if(colorIndex > 5)
            colorIndex = 1

        when (colorIndex) {
            1 -> playerColor.setBackgroundResource(R.drawable.rounded_corners_beige)
            2 -> playerColor.setBackgroundResource(R.drawable.rounded_corners_gray)
            3 -> playerColor.setBackgroundResource(R.drawable.rounded_corners_blue)
            4 -> playerColor.setBackgroundResource(R.drawable.rounded_corners_green)
            5 -> playerColor.setBackgroundResource(R.drawable.rounded_corners_red)
        }
    }

    fun setUpLayout(layout: RelativeLayout) {
        val playerLife: TextView = layout.findViewById(R.id.life_total)
        playerLife.text = life.toString()

        val playerColor: View = layout.findViewById(R.id.player_color)

        val playerAdd: Button = layout.findViewById(R.id.add_life)
        playerAdd.setOnClickListener {
            addLifePoint(playerLife)
        }

        val playerSubtract: Button = layout.findViewById(R.id.subtract_life)
        playerSubtract.setOnClickListener {
            subtractLifePoint(playerLife)
        }

        val brushButton: Button = layout.findViewById(R.id.brush_button)
        brushButton.setOnClickListener {
            changePlayerBackgroundColor(playerColor)
        }
    }

    fun setUpMenu(view: View) {
        val menuButton: Button = view.findViewById(R.id.menu)
        val menuBar: RelativeLayout = view.findViewById(R.id.menu_bar)
        val lifeButton: Button = view.findViewById(R.id.life_button)
        val lifeBar: RelativeLayout = view.findViewById(R.id.life_bar)
        val playersButton: Button = view.findViewById(R.id.players_button)
        val playersBar: RelativeLayout = view.findViewById(R.id.players_bar)
        menuButton.setOnClickListener {
            if (menuBar.visibility == View.VISIBLE) {
                menuBar.visibility = View.GONE
                lifeBar.visibility = View.GONE
                playersBar.visibility = View.GONE
            } else
                menuBar.visibility = View.VISIBLE
        }

        val resetButton: Button = view.findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, numOfPlayers)
            intent.putExtra(INITLIFE, life)
            startActivity(intent)
        }

        lifeButton.setOnClickListener {
            if(lifeBar.visibility == View.VISIBLE)
                lifeBar.visibility = View.GONE
            else
                lifeBar.visibility = View.VISIBLE
        }

        val twentyLivesButton: Button = view.findViewById(R.id.twenty_lives)
        twentyLivesButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, numOfPlayers)
            intent.putExtra(INITLIFE, 20)
            onDestroy()
            startActivity(intent)
        }

        val thirtyLivesButton: Button = view.findViewById(R.id.thirty_lives)
        thirtyLivesButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, numOfPlayers)
            intent.putExtra(INITLIFE, 30)
            onDestroy()
            startActivity(intent)
        }

        val fortyLivesButton: Button = view.findViewById(R.id.fortyLives)
        fortyLivesButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, numOfPlayers)
            intent.putExtra(INITLIFE, 40)
            onDestroy()
            startActivity(intent)
        }

        playersButton.setOnClickListener {
            if(playersBar.visibility == View.VISIBLE)
                playersBar.visibility = View.GONE
            else
                playersBar.visibility = View.VISIBLE
        }

        val twoPlayersButton: Button = view.findViewById(R.id.two_players)
        twoPlayersButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, 2)
            intent.putExtra(INITLIFE, life)
            onDestroy()
            startActivity(intent)
        }

        val threePlayersButton: Button = view.findViewById(R.id.three_players)
        threePlayersButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, 3)
            intent.putExtra(INITLIFE, life)
            onDestroy()
            startActivity(intent)
        }

        val fourPlayersButton: Button = view.findViewById(R.id.four_players)
        fourPlayersButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(NUM_OF_PLAYERS, 4)
            intent.putExtra(INITLIFE, life)
            onDestroy()
            startActivity(intent)
        }
    }
}
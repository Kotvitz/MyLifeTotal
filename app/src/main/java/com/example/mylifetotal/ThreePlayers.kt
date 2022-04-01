package com.example.mylifetotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment

class ThreePlayers : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.three_players, container, false)

        (activity as GameActivity).setUpMenu(view)

        val playerOne: RelativeLayout = view.findViewById(R.id.player_one)
        (activity as GameActivity).setUpLayout(playerOne)

        val playerTwo: RelativeLayout = view.findViewById(R.id.player_two)
        (activity as GameActivity).setUpLayout(playerTwo)

        val playerThree: RelativeLayout = view.findViewById(R.id.player_three)
        (activity as GameActivity).setUpLayout(playerThree)

        return view
    }
}
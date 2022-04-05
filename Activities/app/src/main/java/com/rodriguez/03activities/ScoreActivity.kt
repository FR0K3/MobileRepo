package com.rodriguez.`03activities`

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rodriguez.activities.R

class ScoreActivity : AppCompatActivity() {

    // View
    private lateinit var scoreTeamA : TextView
    private lateinit var scoreTeamB : TextView
    private lateinit var statusTeamA : TextView
    private lateinit var statusTeamB : TextView

    // Data
    private var scoreA = 0
    private var scoreB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        bind()
        intent?.let { intent ->
            scoreA = intent.getIntExtra(MainActivity.KEY_SCORE_A, 0)
            scoreB = intent.getIntExtra(MainActivity.KEY_SCORE_B, 0)
        }
        fillScore()
    }

    private fun bind(){
        scoreTeamA = findViewById(R.id.score_a)
        scoreTeamB = findViewById(R.id.score_b)
        statusTeamA = findViewById(R.id.win_text_a)
        statusTeamB = findViewById(R.id.win_text_b)
    }

    fun fillScore(){
        scoreTeamA.text = scoreA.toString()
        scoreTeamB.text = scoreB.toString()

        if (scoreA == scoreB){
            statusTeamA.text = getString(R.string.win_text)
            statusTeamB.text = getString(R.string.win_text)
        } else if(scoreA > scoreB) {
            statusTeamA.text = getString(R.string.win_text)
            statusTeamB.text = getString(R.string.loser_text)
        } else{
            statusTeamA.text = getString(R.string.loser_text)
            statusTeamB.text = getString(R.string.win_text)
        }

    }
}
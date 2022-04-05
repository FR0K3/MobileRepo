package com.rodriguez.`03activities`

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.rodriguez.activities.R

class MainActivity : AppCompatActivity() {

    private var scoreA = 0
    private var scoreB = 0
    private lateinit var teamAScoreTextView:TextView
    private lateinit var teamBScoreTextView:TextView
    private lateinit var teamABtn:Button
    private lateinit var teamBBtn:Button
    private lateinit var saveBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        bind()
        setupScores(savedInstanceState)
        addListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_A, scoreA)
        outState.putInt(KEY_SCORE_B, scoreB)
    }

    private fun onSave(){
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(KEY_SCORE_A, scoreA)
        intent.putExtra(KEY_SCORE_B, scoreB)
        startActivity(intent)
    }

    private fun addListeners(){
        teamABtn.setOnClickListener(){
            scoreA++
            teamAScoreTextView.text = scoreA.toString()
        }

        teamBBtn.setOnClickListener(){
            scoreB++
            teamBScoreTextView.text = scoreB.toString()
        }

        saveBtn.setOnClickListener(){
            onSave()
        }
    }

    private fun bind(){
        // Team A
        teamAScoreTextView = findViewById(R.id.score_a)
        teamABtn = findViewById(R.id.action_a)

        // Team B
        teamBScoreTextView = findViewById(R.id.score_b)
        teamBBtn = findViewById(R.id.action_b)

        //Save
        saveBtn = findViewById(R.id.action_save)
    }

    private fun setupScores(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            scoreA = bundle.getInt(KEY_SCORE_A, 0)
            scoreB = bundle.getInt(KEY_SCORE_B, 0)
        }
        teamAScoreTextView.text = scoreA.toString()
        teamBScoreTextView.text = scoreB.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    companion object{
        private val TAG = MainActivity::class.simpleName
        const val KEY_SCORE_A = "ScoreTeamA"
        const val KEY_SCORE_B = "ScoreTeamB"
    }

}
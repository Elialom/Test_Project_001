package com.example.test_project_001

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TicTacToeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tic_tac_toe_activity)
        val button1 = findViewById<Button>(R.id.tic_tac_toe_btn_1)
        val button2 = findViewById<Button>(R.id.tic_tac_toe_btn_2)
        val button3 = findViewById<Button>(R.id.tic_tac_toe_btn_3)
        val button4 = findViewById<Button>(R.id.tic_tac_toe_btn_4)
        val button5 = findViewById<Button>(R.id.tic_tac_toe_btn_5)
        val button6 = findViewById<Button>(R.id.tic_tac_toe_btn_6)
        val button7 = findViewById<Button>(R.id.tic_tac_toe_btn_7)
        val button8 = findViewById<Button>(R.id.tic_tac_toe_btn_8)
        val button9 = findViewById<Button>(R.id.tic_tac_toe_btn_9)
        val restartButton = findViewById<Button>(R.id.tic_tac_toe_start)
        val stateField = mutableListOf<PlayableCell>(
            PlayableCell(0, 0, State.EMPTY),
            PlayableCell(1, 0, State.EMPTY),
            PlayableCell(2, 0, State.EMPTY),
            PlayableCell(0, 1, State.EMPTY),
            PlayableCell(1, 1, State.EMPTY),
            PlayableCell(2, 1, State.EMPTY),
            PlayableCell(0, 2, State.EMPTY),
            PlayableCell(1, 2, State.EMPTY),
            PlayableCell(2, 2, State.EMPTY)
        )
        button1.setOnClickListener() {
            showGameField(stateField)
            button1.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 0 && it.y == 0 }
            stateField.find { it.x == 0 && it.y == 0 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button2.setOnClickListener() {
            showGameField(stateField)
            button2.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 1 && it.y == 0 }
            stateField.find { it.x == 1 && it.y == 0 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button3.setOnClickListener() {
            showGameField(stateField)
            button3.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 2 && it.y == 0 }
            stateField.find { it.x == 2 && it.y == 0 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button4.setOnClickListener() {
            showGameField(stateField)
            button4.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 0 && it.y == 1 }
            stateField.find { it.x == 0 && it.y == 1 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button5.setOnClickListener() {
            showGameField(stateField)
            button5.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 1 && it.y == 1 }
            stateField.find { it.x == 1 && it.y == 1 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button6.setOnClickListener() {
            showGameField(stateField)
            button6.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 2 && it.y == 1 }
            stateField.find { it.x == 2 && it.y == 1 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button7.setOnClickListener() {
            showGameField(stateField)
            button7.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 0 && it.y == 2 }
            stateField.find { it.x == 0 && it.y == 2 }?.state = State.PLAYER
            showGameField(stateField)
        }
        button8.setOnClickListener() {
            showGameField(stateField)
            button8.setText(R.string.tic_tac_toe_x)
            stateField.filter { it.x == 1 && it.y == 2 }
            stateField.find { it.x == 1 && it.y == 2 }?.state = State.PLAYER
            showGameField(stateField)
        }

        button9.setOnClickListener() {
            showGameField(stateField)

            stateField.filter { it.x == 2 && it.y == 2 }
            stateField.find { it.x == 2 && it.y == 2 }?.state = State.PLAYER
            showGameField(stateField)
        }


        var stateEmpty = createEmptyState()
        restartButton.setOnClickListener() {
            stateEmpty = createEmptyState()
        }
    }
    fun createEmptyState():List<PlayableCell> {
        return mutableListOf<PlayableCell>(
        PlayableCell(0, 0, State.EMPTY),
        PlayableCell(1, 0, State.EMPTY),
        PlayableCell(2, 0, State.EMPTY),
        PlayableCell(0, 1, State.EMPTY),
        PlayableCell(1, 1, State.EMPTY),
        PlayableCell(2, 1, State.EMPTY),
        PlayableCell(0, 2, State.EMPTY),
        PlayableCell(1, 2, State.EMPTY),
        PlayableCell(2, 2, State.EMPTY)
        )
    }

    fun showGameField(stateField: MutableList<PlayableCell>) {
        stateField.forEach { cell ->
            if (cell.state == State.PLAYER) {

            }
        }
    }

    fun checkVictory() {

    }
}
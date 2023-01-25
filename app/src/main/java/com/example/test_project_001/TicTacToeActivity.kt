package com.example.test_project_001

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TicTacToeActivity : AppCompatActivity() {

    private var stateField: MutableList<PlayableCell> = mutableListOf()

    val button1 = findViewById<Button>(R.id.tic_tac_toe_btn_1)
    val button2 = findViewById<Button>(R.id.tic_tac_toe_btn_2)
    val button3 = findViewById<Button>(R.id.tic_tac_toe_btn_3)
    val button4 = findViewById<Button>(R.id.tic_tac_toe_btn_4)
    val button5 = findViewById<Button>(R.id.tic_tac_toe_btn_5)
    val button6 = findViewById<Button>(R.id.tic_tac_toe_btn_6)
    val button7 = findViewById<Button>(R.id.tic_tac_toe_btn_7)
    val button8 = findViewById<Button>(R.id.tic_tac_toe_btn_8)
    val button9 = findViewById<Button>(R.id.tic_tac_toe_btn_9)

    var buttonList: MutableList<Button> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tic_tac_toe_activity)
        println("!!! onCreate")
        val restartButton = findViewById<Button>(R.id.tic_tac_toe_start)
        buttonList.add(button1)
        buttonList.add(button2)
        buttonList.add(button3)
        buttonList.add(button4)
        buttonList.add(button5)
        buttonList.add(button6)
        buttonList.add(button7)
        buttonList.add(button8)
        buttonList.add(button9)

        createEmptyState()

        button1.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 0 && it.y == 0 }
            stateField.find { it.x == 0 && it.y == 0 }?.state = State.PLAYER
            showGameField()
        }
        button2.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 1 && it.y == 0 }
            stateField.find { it.x == 1 && it.y == 0 }?.state = State.PLAYER
            showGameField()
        }
        button3.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 2 && it.y == 0 }
            stateField.find { it.x == 2 && it.y == 0 }?.state = State.PLAYER
            showGameField()
        }
        button4.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 0 && it.y == 1 }
            stateField.find { it.x == 0 && it.y == 1 }?.state = State.PLAYER
            showGameField()
        }
        button5.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 1 && it.y == 1 }
            stateField.find { it.x == 1 && it.y == 1 }?.state = State.PLAYER
            showGameField()
        }
        button6.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 2 && it.y == 1 }
            stateField.find { it.x == 2 && it.y == 1 }?.state = State.PLAYER
            showGameField()
        }
        button7.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 0 && it.y == 2 }
            stateField.find { it.x == 0 && it.y == 2 }?.state = State.PLAYER
            showGameField()
        }
        button8.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 1 && it.y == 2 }
            stateField.find { it.x == 1 && it.y == 2 }?.state = State.PLAYER
            showGameField()
        }

        button9.setOnClickListener() {
            showGameField()
            stateField.filter { it.x == 2 && it.y == 2 }
            stateField.find { it.x == 2 && it.y == 2 }?.state = State.PLAYER
            showGameField()
        }

        restartButton.setOnClickListener() {
            createEmptyState()
        }
    }

    private fun createEmptyState() {
        stateField = mutableListOf<PlayableCell>(
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

    private fun showGameField() {
        var indexButton = -1
        for (y in 0..2) {
            for (x in 0..2) {
                indexButton++
                println("!!! current index = x = $x $y")
                if (stateField.find { it.y == y && it.x == x }?.state == State.PLAYER) {
                    buttonList[indexButton].text = getString(R.string.tic_tac_toe_x)
                }
            }
        }
    }

    fun checkVictory() {

    }
}
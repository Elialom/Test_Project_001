package com.example.test_project_001

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TicTacToeActivity : AppCompatActivity() {

    private var stateField: MutableList<PlayableCell> = mutableListOf()

    var buttonList: MutableList<Button> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tic_tac_toe_activity)
        println("!!! onCreate")
        val restartButton = findViewById<Button>(R.id.tic_tac_toe_start)
        val button1 = findViewById<Button>(R.id.tic_tac_toe_btn_1)
        val button2 = findViewById<Button>(R.id.tic_tac_toe_btn_2)
        val button3 = findViewById<Button>(R.id.tic_tac_toe_btn_3)
        val button4 = findViewById<Button>(R.id.tic_tac_toe_btn_4)
        val button5 = findViewById<Button>(R.id.tic_tac_toe_btn_5)
        val button6 = findViewById<Button>(R.id.tic_tac_toe_btn_6)
        val button7 = findViewById<Button>(R.id.tic_tac_toe_btn_7)
        val button8 = findViewById<Button>(R.id.tic_tac_toe_btn_8)
        val button9 = findViewById<Button>(R.id.tic_tac_toe_btn_9)
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
            onClickButtonAction("1", 0, 0)
        }
        button2.setOnClickListener() {
            onClickButtonAction("2", 1, 0)
        }
        button3.setOnClickListener() {
            onClickButtonAction("3", 2, 0)
        }
        button4.setOnClickListener() {
            onClickButtonAction("4", 0, 1)
        }
        button5.setOnClickListener() {
            onClickButtonAction("5", 1, 1)
        }
        button6.setOnClickListener() {
            onClickButtonAction("6", 2, 1)
        }
        button7.setOnClickListener() {
            onClickButtonAction("7", 0, 2)
        }
        button8.setOnClickListener() {
            onClickButtonAction("8", 1, 2)
        }

        button9.setOnClickListener() {
            onClickButtonAction("9", 2, 2)
        }

        restartButton.setOnClickListener() {
            createEmptyState()
        }
    }
    val diagonalCoordinates = listOf<Coordinates>(
        Coordinates(0, 0),
        Coordinates(2, 0),
        Coordinates(0, 2),
        Coordinates(2, 2)
    )
    //0,0 2,0 0,2 2,2


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
        showGameField()
    }

    private fun showGameField() {
        println("!!! showGameField")
        var indexButton = -1
        for (y in 0..2) {
            for (x in 0..2) {
                indexButton++
                //println("!!! current index = x = $x $y")
                if (stateField.find { it.y == y && it.x == x }?.state == State.PLAYER) {
                    buttonList[indexButton].text = getString(R.string.tic_tac_toe_x)
                }
                if (stateField.find { it.y == y && it.x == x }?.state == State.EMPTY) {
                    buttonList[indexButton].text = getString(R.string.tic_tac_toe_empty)
                }
                if (stateField.find { it.y == y && it.x == x }?.state == State.COMPUTER) {
                    buttonList[indexButton].text = getString(R.string.tic_tac_toe_o)
                }
            }
        }
    }

//    private fun checkVictory(typePlayer: State): Boolean {
//        var count: Int = 0
//        for (y in 0..20) {
//            for (x in 0..2) {
//                if (stateField.find { it.x == x && it.y == y }?.state == typePlayer) {//State/COMPUTER// null
//                    count++
//                    println("Count has been added")
//                }
//            }
//            if (count == 3) {
//                if (typePlayer == State.COMPUTER) {
//                    showMessage(getString(R.string.ttt_computer_win))
//                } else {
//                    showMessage(getString(R.string.ttt_player_win))
//                }
//                //createEmptyState()
//                showGameField()
//                count = 0
//                return true
//            } else {
//                count = 0
//            }
//        }
//
//        for (x in 0..2) {
//            for (y in 0..2) {
//                if (stateField.find { it.x == x && it.y == y }?.state == typePlayer) {
//                    count++
//                    println("Count has been added")
//
//                }
//            }
//            if (count == 3) {
//                if (typePlayer == State.COMPUTER) {
//                    showMessage(getString(R.string.ttt_computer_win))
//                } else {
//                    showMessage(getString(R.string.ttt_player_win))
//                }
//                //createEmptyState()
//                showGameField()
//                count = 0
//                return true
//            } else {
//                count = 0
//            }
//        }
//        if (stateField.find { it.x == 0 && it.y == 0 }?.state == typePlayer &&
//            stateField.find { it.x == 1 && it.y == 1 }?.state == typePlayer &&
//            stateField.find { it.x == 2 && it.y == 2 }?.state == typePlayer
//        ) {
//            if (typePlayer == State.COMPUTER) {
//                showMessage(getString(R.string.ttt_computer_win))
//            } else {
//                showMessage(getString(R.string.ttt_player_win))
//            }
//            //createEmptyState()
//            showGameField()
//            return true
//        }
//        if (stateField.find { it.x == 2 && it.y == 0 }?.state == typePlayer &&
//            stateField.find { it.x == 1 && it.y == 1 }?.state == typePlayer &&
//            stateField.find { it.x == 0 && it.y == 2 }?.state == typePlayer
//        ) {
//            if (typePlayer == State.COMPUTER) {
//                showMessage(getString(R.string.ttt_computer_win))
//            } else {
//                showMessage(getString(R.string.ttt_player_win))
//            }
//            //createEmptyState()
//            showGameField()
//            return true
//        }
//
//        //stateField.find { it.x == 0 && it.y == 0 }?.state = State.PLAYER//
//        return false
//    }

    /**
     * Field check for both players before victory situation
     */
    private fun checkField(
        typePlayer: State,
        checkFieldType: CheckFieldType
    ): CheckFieldResults {
        println("!!! checkfield $typePlayer $checkFieldType")
        var count: Int = 0
        var globalX: Int = 0
        var globalY: Int = 0
        var coordinates: Coordinates? = null
        var checkFieldType1: CheckFieldType? = null
        for (y in 0..2) {
            var isCellTaken = true
            for (x in 0..2) {
                if (stateField.find { it.x == x && it.y == y }?.state == typePlayer) {//State/COMPUTER// null
                    println("!!! a2")
                    count++
                    println("Count has been added")
                } else if (stateField.find { it.x == x && it.y == y }?.state == State.EMPTY) {
                    isCellTaken = false
                    globalX = x
                    globalY = y
                }


            }
            if (count == checkFieldType.countCheckCell) {
                when (checkFieldType) {
                    CheckFieldType.WIN_SITUATION -> {
                        checkFieldType1 = CheckFieldType.WIN_SITUATION
                    }
                    CheckFieldType.PRE_WIN_SITUATION -> {
                        checkFieldType1 = CheckFieldType.PRE_WIN_SITUATION
                        coordinates = Coordinates(globalX, globalY)
                    }
                }
                if (checkFieldType == CheckFieldType.WIN_SITUATION || (checkFieldType == CheckFieldType.PRE_WIN_SITUATION && !isCellTaken)) {
                    return CheckFieldResults(coordinates, checkFieldType1)
                }
            }
            count = 0
        }
        for (x in 0..2) {
            var isCellTaken = true
            for (y in 0..2) {
                if (stateField.find { it.x == x && it.y == y }?.state == typePlayer) {//State/COMPUTER// null
                    println("!!! a2")
                    count++
                    println("Count has been added")
                } else if (stateField.find { it.x == x && it.y == y }?.state == State.EMPTY) {
                    isCellTaken = false
                    globalX = x
                    globalY = y
                }


            }
            if (count == checkFieldType.countCheckCell) {
                when (checkFieldType) {
                    CheckFieldType.WIN_SITUATION -> {
                        checkFieldType1 = CheckFieldType.WIN_SITUATION
                    }
                    CheckFieldType.PRE_WIN_SITUATION -> {
                        checkFieldType1 = CheckFieldType.PRE_WIN_SITUATION
                        coordinates = Coordinates(globalX, globalY)
                    }
                }
                if (checkFieldType == CheckFieldType.WIN_SITUATION || (checkFieldType == CheckFieldType.PRE_WIN_SITUATION && !isCellTaken)) {
                    return CheckFieldResults(coordinates, checkFieldType1)
                }
            }
            count = 0
        }
        for (x in 0..2) {
            if (stateField.find { it.x == x && it.y == x }?.state == typePlayer) {
                count++
            } else if (stateField.find { it.x == x && it.y == x }?.state == State.EMPTY) {
                globalX = x
                globalY = x
            }
        }
        if (count == checkFieldType.countCheckCell) {
            when (checkFieldType) {
                CheckFieldType.WIN_SITUATION -> {
                    checkFieldType1 = CheckFieldType.WIN_SITUATION
                }
                CheckFieldType.PRE_WIN_SITUATION -> {
                    checkFieldType1 = CheckFieldType.PRE_WIN_SITUATION
                    coordinates = Coordinates(globalX, globalY)
                }
            }
            if (checkFieldType == CheckFieldType.WIN_SITUATION || (checkFieldType == CheckFieldType.PRE_WIN_SITUATION)) {
                return CheckFieldResults(Coordinates(globalX, globalY), checkFieldType1)
            }
        }
        //2,0 1,1 0,2
        count = 0
        if (stateField.find { it.x == 2 && it.y == 0 }?.state == typePlayer) {
            count++
        } else if (stateField.find { it.x == 2 && it.y == 0 }?.state == State.EMPTY) {
            globalX = 2
            globalY = 0
        }
        if (stateField.find { it.x == 1 && it.y == 1 }?.state == typePlayer) {
            count++
        } else if (stateField.find { it.x == 1 && it.y == 1 }?.state == State.EMPTY) {
            globalX = 1
            globalY = 1
        }
        if (stateField.find { it.x == 0 && it.y == 2 }?.state == typePlayer) {
            count++
        } else if (stateField.find { it.x == 0 && it.y == 2 }?.state == State.EMPTY) {
            globalX = 0
            globalY = 2
        }
        if (count == checkFieldType.countCheckCell) {
            when (checkFieldType) {
                CheckFieldType.WIN_SITUATION -> {
                    checkFieldType1 = CheckFieldType.WIN_SITUATION
                }
                CheckFieldType.PRE_WIN_SITUATION -> {
                    checkFieldType1 = CheckFieldType.PRE_WIN_SITUATION
                    coordinates = Coordinates(globalX, globalY)
                }
            }
            if (checkFieldType == CheckFieldType.WIN_SITUATION || (checkFieldType == CheckFieldType.PRE_WIN_SITUATION)) {
                return CheckFieldResults(coordinates, checkFieldType1)
            }
        }
        return CheckFieldResults(null, null)
    }

    /**
     * Function to return count step
     */
    private fun getCountStep(): Int {
        println("!!! getCountStep")
        var countStep: Int = 0
        for (y in 0..2) {
            for (x in 0..2) {
                if (stateField.find { it.x == x && it.y == y }?.state != State.EMPTY) {
                    countStep++
                }
            }
        }
        println("!!! countStep $countStep")
        return countStep

    }

    private fun computerTurn() {
        println("!!! a3")
        val countStep = getCountStep()
        if (countStep == 1) {
            println("!!! computerTurn")
            if (stateField.find { it.x == 1 && it.y == 1 }?.state == State.PLAYER) {
                println("!!! computer step 1")
                makeMove(diagonalCoordinates.random(), typePlayer = State.COMPUTER)
            } else {
                println("!!! computer step 2")
                makeMove(Coordinates(1, 1), typePlayer = State.COMPUTER)
            }

            println("!!! state cell ${stateField.find { it.x == 1 && it.y == 1 }?.state}")
        } else {
            println("!!! b4")
            val computerCheckResult =
                checkField(typePlayer = State.COMPUTER, CheckFieldType.PRE_WIN_SITUATION)
            val playerCheckResult =
                checkField(typePlayer = State.PLAYER, CheckFieldType.PRE_WIN_SITUATION)
            if (computerCheckResult.checkFieldType != null && computerCheckResult.coordinates != null) {
                makeMove(computerCheckResult.coordinates, typePlayer = State.COMPUTER)
            } else if (playerCheckResult.checkFieldType != null && playerCheckResult.coordinates != null) {
                makeMove(playerCheckResult.coordinates, typePlayer = State.COMPUTER)
            }
        }
        println("!!! functionName $countStep")
//        checkVictory(State.COMPUTER)
    }

    /**
     * Checks if computer has to do a move so that the player does not win
     */


    private fun onClickButtonAction(nameButton: String, x: Int, y: Int) {
        println("!!! Button $nameButton clicked")
        if (stateField.find { it.x == x && it.y == y }?.state == State.EMPTY) {
            makeMove(Coordinates(x, y), typePlayer = State.PLAYER)
        }
        showGameField()
        //
        if (checkField(
                typePlayer = State.PLAYER,
                CheckFieldType.WIN_SITUATION
            ).coordinates == null
        ) {
            println("!!! b5")
            computerTurn()
        }
        showGameField()
        if (checkField(typePlayer = State.PLAYER, CheckFieldType.WIN_SITUATION).checkFieldType == CheckFieldType.WIN_SITUATION) {
            showMessage(getString(R.string.ttt_player_win))
        }
        if (checkField(typePlayer = State.COMPUTER, CheckFieldType.WIN_SITUATION).checkFieldType == CheckFieldType.WIN_SITUATION) {
            showMessage(getString(R.string.ttt_computer_win))
        }
    }


    private fun showMessage(text: String) {

        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    /**
     * Computer/Player makes move
     */
    private fun makeMove(
        computerCoordinates: Coordinates,
        typePlayer: State
    ) {
        if (stateField.find { it.x == computerCoordinates.coordinateX && it.y == computerCoordinates.coordinateY }?.state == State.EMPTY) {
            stateField.find { it.x == computerCoordinates.coordinateX && it.y == computerCoordinates.coordinateY }?.state =
                typePlayer
            showGameField()
        }
    }
}
package com.example.test_project_001

data class PlayableCell(
    val x: Int = 0,
    val y: Int = 0,
    var state: State
)

enum class State {
    EMPTY,
    COMPUTER,
    PLAYER
}
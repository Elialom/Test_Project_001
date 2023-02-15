package com.example.test_project_001

/**
 * Enum class for two types of field check (Win Situations)
 * @property WIN_SITUATION Field check for winning situation
 * @property PRE_WIN_SITUATION Field check before winning situation
 */
enum class CheckFieldType(
    val countCheckCell: Int
) {
    PRE_WIN_SITUATION(2),
    WIN_SITUATION(3)
}
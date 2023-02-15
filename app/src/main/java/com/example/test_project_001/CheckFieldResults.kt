package com.example.test_project_001

/**
 * Results for checking field
 * @property coordinates Coordinates the player has to move to to win
 * @property checkFieldType Type of field check
 */
data class CheckFieldResults(
    val coordinates: Coordinates?,
    val checkFieldType: CheckFieldType
)

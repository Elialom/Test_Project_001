package com.example.test_project_001

class Car(
    var carColor: String,
    var carEngine: String,
    var carReleased: String,
    var carCrashes: Boolean
) {
    override fun toString(): String {
        val carCrashesString: String = if (carCrashes) "Car has been crashed at least once" else
            "Car has not been crashed"
        return "Release Date: $carReleased, Car Engine: $carEngine, Car Crashes: $carCrashesString"
    }
}
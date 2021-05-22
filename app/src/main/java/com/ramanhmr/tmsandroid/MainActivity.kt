package com.ramanhmr.tmsandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.homework3.Animal
import com.ramanhmr.tmsandroid.homework3.Dog
import com.ramanhmr.tmsandroid.homework3.Elephant
import com.ramanhmr.tmsandroid.homework3.RunAttendee

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        describeAnimal(Dog(8.3, "Шарик"))
        describeAnimal(Elephant(4.5, "Дамбо"))
    }

    fun <T> describeAnimal(animal: T) where T : Animal, T : RunAttendee {
        Log.i("ANIMAL",
            "${animal.javaClass.simpleName} ${animal.name} пробежал дистанцию за ${
                String.format("%.3f",
                    (animal as Animal).timeOfRoute())
            } часа")
    }
}
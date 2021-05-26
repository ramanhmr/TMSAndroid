package com.ramanhmr.tmsandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.homework4.Boss
import com.ramanhmr.tmsandroid.homework4.Employee
import com.ramanhmr.tmsandroid.homework4.Manager
import com.ramanhmr.tmsandroid.homework4.Worker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feelGoodInc: List<Employee> = mutableListOf((Boss("Карл",
            4400,
            listOf(Manager("Адам",
                2700,
                listOf(Worker("Аарон", 1100),
                    Worker("Александр", 1200),
                    Worker("Абрам", 1300))),
                Manager("Ева",
                    2500,
                    listOf(Worker("Беатрис", 900),
                        Worker("Бела", 950),
                        Worker("Берта", 1000))))) as Employee),
            (Boss("Клара",
                5000,
                listOf(Manager("Фауст",
                    2400,
                    listOf(Worker("Вадим", 900),
                        Worker("Вениамин", 830),
                        Worker("Владимир", 800))),
                    Manager("Мефистофель",
                        2200,
                        listOf(Worker("Генриетта", 905),
                            Worker("Галина", 935),
                            Worker("Гюзель", 800))))) as Employee)).apply {
            for (i in this.size - 1 downTo 0) {
                this.addAll((this[i] as Boss).subordinates)
                (this[i] as Boss).subordinates.forEach { manager -> this.addAll(manager.subordinates) }
            }
        }

        feelGoodInc.forEach {
            it.describe()
            when (it) {
                is Worker -> it.work(TAG_IN_LOGCAT)
                is Manager -> it.describeSubordinates() // функции описывают подчиненных у руководителей
                is Boss -> it.describeSubordinates() // из-за этого подчиненные в логах описываются дважды
            }
        }
    }

    fun Employee.describe() {
        val text: StringBuilder = StringBuilder("Имя - ${name}, зарплата - ${wage}.")
        if (this is Boss)
            text.replaceFirst(".".toRegex(),
                ", численность подчиненных - ${this.subordinates.size}.")
        else if (this is Manager)
            text.replaceFirst(".".toRegex(),
                ", численность подчиненных - ${this.subordinates.size}.")
        Log.i(TAG_IN_LOGCAT, text.toString())
    }

    fun Manager.describeSubordinates() {
        subordinates.forEach { it.describe() }
    }

    fun Boss.describeSubordinates() {
        subordinates.forEach { it.describe() }
    }

    companion object {
        const val TAG_IN_LOGCAT = "EMPLOYEES"
    }
}
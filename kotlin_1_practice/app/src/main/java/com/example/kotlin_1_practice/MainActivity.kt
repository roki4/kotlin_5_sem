package com.example.kotlin_1_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Expense(val amount: Double, val category: String, val date: String) {

    constructor(amount: Double, category: String) : this(amount, category, "2024-01-01") {
        println("Вторичный конструктор")
    }

    fun displayExpense() {
        println("Расход: $amount, Категория: $category, Дата: $date")
    }
}

class ExpenseTracker {
    private val expenses = mutableListOf<Expense>()

    fun addExpense(expense: Expense) {
        expenses.add(expense)
        println("Новый расход добавлен: ${expense.amount} в категории ${expense.category} на дату ${expense.date}")
    }

    fun showAllExpenses() {
        if (expenses.isEmpty()) {
            println("Список расходов пуст.")
        } else {
            println("Все расходы:")
            expenses.forEach { it.displayExpense() }
        }
    }

    fun calculateTotalByCategory() {
        if (expenses.isEmpty()) {
            println("Нет данных для расчета.")
            return
        }

        val totalsByCategory = expenses.groupBy { it.category }
            .mapValues { (_, expenseList) -> expenseList.sumByDouble { it.amount } }

        println("Сумма расходов по категориям:")
        for ((category, total) in totalsByCategory) {
            println("Категория: $category, Сумма: $total")
        }
    }
}

fun main() {
    var num = 0
    println(num++ + ++num)
}

package com.example.kotlin_1_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Expense(val amount: Double, val category: String, val date: String) {
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
    // Создание экземпляра трекера расходов
    val expenseTracker = ExpenseTracker()

    // Добавление расходов
    expenseTracker.addExpense(Expense(500.0, "Продукты", "2024-09-01"))
    expenseTracker.addExpense(Expense(200.0, "Транспорт", "2024-09-02"))
    expenseTracker.addExpense(Expense(150.0, "Продукты", "2024-09-03"))

    // Вывод всех расходов
    expenseTracker.showAllExpenses()

    // Подсчет суммы расходов по категориям
    expenseTracker.calculateTotalByCategory()
}

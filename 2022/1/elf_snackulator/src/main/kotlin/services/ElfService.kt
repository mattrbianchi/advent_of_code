package services

import entities.Elf
import store.AbstractElfRepository

fun elfWithMostCaloricSnacks(repo: AbstractElfRepository): Elf {
    return repo.list().maxBy { it.totalCalories() }
}

fun topThreeElvesWithMostCaloricSnacks(repo: AbstractElfRepository): List<Elf> {
    return repo.list().sortedByDescending { it.totalCalories() }.take(3)
}
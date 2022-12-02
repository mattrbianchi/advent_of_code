package services

import entities.Elf
import store.AbstractElfRepository

fun elfWithMostCaloricSnacks(repo: AbstractElfRepository): Elf {
    return repo.list().maxWith(compareBy<Elf>{ it.totalCalories() })
}

fun topThreeElvesWithMostCaloricSnacks(repo: AbstractElfRepository): List<Elf> {
    return repo.list().sortedWith(compareBy<Elf>{ it.totalCalories() }).asReversed().subList(0, 3)
}
import services.elfWithMostCaloricSnacks
import services.topThreeElvesWithMostCaloricSnacks
import store.ElfFileRepository

fun main(args: Array<String>) {
    var repo = ElfFileRepository("day01")
    var mostPreparedElf = elfWithMostCaloricSnacks(repo)
    println(mostPreparedElf.totalCalories())
    var topThreeElves = topThreeElvesWithMostCaloricSnacks(repo)
    println(topThreeElves.sumOf { it.totalCalories() })
}
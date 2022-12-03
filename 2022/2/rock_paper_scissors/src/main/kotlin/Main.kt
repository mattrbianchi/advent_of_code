import services.endScore
import store.GameStrategyRepository
import store.IncorrectGameRepository

fun main() {
    val incorrectRepo = IncorrectGameRepository("day2")
    println(endScore(incorrectRepo))
    val strategyRepo = GameStrategyRepository("day2")
    println(endScore(strategyRepo))
}
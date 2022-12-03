package store

import entities.Game
import entities.Shoot
import entities.Outcome
import entities.Strategy
import java.io.File
import java.lang.Exception

class GameStrategyRepository(file: String): AbstractGameRepository() {
    private var games: MutableList<Game> = mutableListOf()
    init {
        load(file)
    }
    override fun list(): List<Game> {
        return games.toList()
    }

    private fun load(file: String) {
        var lines = readFile(file)
        for (line in lines) {
            val shots = line.split(" ")
            val theirShot = translate(shots[0])
            val strategy = Strategy(translateStrategy(shots[1]))
            games.add(Game(theirShot, strategy.calculateShot(theirShot)))
        }
    }

    private fun readFile(name: String) = File("fixture", "$name.txt").readLines()
    private fun translate(code: String): Shoot =
        when (code) {
            "A" -> Shoot.ROCK
            "B" -> Shoot.PAPER
            "C" -> Shoot.SCISSORS
            else -> throw Exception()
        }
    private fun translateStrategy(code: String): Outcome =
        when (code) {
            "X" -> Outcome.LOSE
            "Y" -> Outcome.DRAW
            "Z" -> Outcome.WIN
            else -> throw Exception()
        }
}
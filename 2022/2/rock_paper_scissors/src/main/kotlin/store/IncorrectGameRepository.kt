package store

import entities.Game
import entities.Shoot
import java.io.File
import java.lang.Exception

class IncorrectGameRepository(file: String): AbstractGameRepository() {
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
            games.add(Game(translate(shots[0]), translate(shots[1])))
        }
    }

    private fun readFile(name: String) = File("fixture", "$name.txt").readLines()
    private fun translate(code: String): Shoot =
        when (code) {
            "A", "X" -> Shoot.ROCK
            "B", "Y" -> Shoot.PAPER
            "C", "Z" -> Shoot.SCISSORS
            else -> throw Exception()
        }
}
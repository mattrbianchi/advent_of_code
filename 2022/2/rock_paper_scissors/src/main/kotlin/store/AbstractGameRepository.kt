package store

import entities.Game

abstract class AbstractGameRepository {
    abstract fun list(): List<Game>
}
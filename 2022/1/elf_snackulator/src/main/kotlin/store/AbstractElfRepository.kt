package store

import entities.Elf

abstract class AbstractElfRepository {
    abstract fun list(): List<Elf>
}
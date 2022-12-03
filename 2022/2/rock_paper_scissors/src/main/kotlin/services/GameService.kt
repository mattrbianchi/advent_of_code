package services

import store.AbstractGameRepository

fun endScore(repo: AbstractGameRepository): Int {
    return repo.list().sumOf { it.score() }
}
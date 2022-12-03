package entities


class Game(they: Shoot, i: Shoot) {
    private val they = they
    private val i = i

    /*
    Not great, but very fun.
     */
    fun score(): Int =
        when (i) {
            Shoot.ROCK ->
                when (they) {
                    Shoot.SCISSORS -> 7
                    Shoot.ROCK -> 4
                    Shoot.PAPER -> 1
                }
            Shoot.PAPER ->
                when (they) {
                    Shoot.ROCK -> 8
                    Shoot.PAPER -> 5
                    Shoot.SCISSORS -> 2
                }
            Shoot.SCISSORS ->
                when (they) {
                    Shoot.PAPER -> 9
                    Shoot.SCISSORS -> 6
                    Shoot.ROCK -> 3
                }
        }
}

enum class Shoot {
    ROCK, PAPER, SCISSORS
}

class Strategy(objective: Outcome) {
    private val objective = objective

    /*
    Also ugly, just as fun.
     */
    fun calculateShot(they: Shoot): Shoot =
        when (objective) {
            Outcome.DRAW ->
                when (they) {
                    Shoot.ROCK -> Shoot.ROCK
                    Shoot.PAPER -> Shoot.PAPER
                    Shoot.SCISSORS -> Shoot.SCISSORS
                }
            Outcome.LOSE ->
                when (they) {
                    Shoot.ROCK -> Shoot.SCISSORS
                    Shoot.PAPER -> Shoot.ROCK
                    Shoot.SCISSORS -> Shoot.PAPER
                }
            Outcome.WIN ->
                when (they) {
                    Shoot.ROCK -> Shoot.PAPER
                    Shoot.PAPER -> Shoot.SCISSORS
                    Shoot.SCISSORS -> Shoot.ROCK
                }
        }
}

enum class Outcome {
    WIN, LOSE, DRAW
}

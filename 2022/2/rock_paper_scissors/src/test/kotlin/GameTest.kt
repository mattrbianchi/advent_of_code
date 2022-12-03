import entities.Game
import entities.Shoot
import entities.Outcome
import entities.Strategy
import store.GameStrategyRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {
    private val repo = GameStrategyRepository("day2_test")
    @Test
    fun `test game calcs strategy and scores rock vs paper correctly`() {
        var game = Game(Shoot.ROCK, Strategy(Outcome.WIN).calculateShot(Shoot.ROCK))
        var score = game.score()
        assertEquals(8, score, "Game didn't score correctly")
    }

    @Test
    fun `test repo loads correct number of games`() {
        assertEquals(3, repo.list().size, "Repo loaded incorrect amount of games.")
    }

//    @Test
//    fun `test endScore calculates correct end score`() {
//        val score = endScore(repo)
//        assertEquals(16, score, "Wrong end score")
//    }
}
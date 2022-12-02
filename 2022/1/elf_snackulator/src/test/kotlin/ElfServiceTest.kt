import services.elfWithMostCaloricSnacks
import services.topThreeElvesWithMostCaloricSnacks
import store.ElfFileRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class ElfServiceTest {
    private val repo = ElfFileRepository("day01_test")

    @Test
    fun `test repo loads correct number of elves`() {
        assertEquals(5, repo.list().size, "Repo loaded incorrect amount of elves.")
    }

    @Test
    fun `test elves have correct calorie counts`() {
        val elves = repo.list()
        assertEquals(10, elves[0].totalCalories(), "First elf had incorrect calorie amount")
        assertEquals(20, elves[1].totalCalories(), "Second elf had incorrect calorie amount")
        assertEquals(30, elves[2].totalCalories(), "Third elf had incorrect calorie amount")
        assertEquals(40, elves[3].totalCalories(), "Third elf had incorrect calorie amount")
        assertEquals(50, elves[4].totalCalories(), "Third elf had incorrect calorie amount")
    }

    @Test
    fun `test elf service gets elf with most calories`() {
        var mostPreparedElf = elfWithMostCaloricSnacks(repo)
        assertEquals(50, mostPreparedElf.totalCalories(), "Didn't find the elf with the most calories")
    }

    @Test
    fun `test elf service returns top three elves with most calories`() {
        var elves = topThreeElvesWithMostCaloricSnacks(repo)
        assertEquals(3, elves.size, "Didn't return 3 elves")
        assertEquals(50, elves[0].totalCalories(), "Didn't return highest count where expected")
        assertEquals(40, elves[1].totalCalories(), "Didn't return 2nd highest count where expected")
        assertEquals(30, elves[2].totalCalories(), "Didn't return 3rd highest count where expected")
    }
}
package entities

class Elf {
    private val snacks: MutableList<Snack> = mutableListOf<Snack>()
    fun addSnack(snack: Snack) {
        snacks.add(snack)
    }

    fun totalCalories(): Int {
        return snacks.sumOf { it.calories }
    }
}

data class Snack(val calories: Int)
package store

import entities.Elf
import entities.Snack
import java.io.File

class ElfFileRepository(file: String): AbstractElfRepository() {
    private val elves: MutableList<Elf> = mutableListOf<Elf>()
    init {
        load(file)
    }

    override fun list(): List<Elf> {
        return elves.toList()
    }

    /*
    Loads elves from a file.
     */
    private fun load(file: String) {
        var lines = readFile(file)
        var i = 0
        while (i < lines.size) {
            var elf = Elf()
            while (i < lines.size) {
                if (lines[i].isEmpty()) {
                    i++
                    break
                }
                elf.addSnack(Snack(lines[i].toInt()))
                i++
            }
            elves.add(elf)
        }
    }
    private fun readFile(name: String) = File("fixture", "$name.txt").readLines()
}
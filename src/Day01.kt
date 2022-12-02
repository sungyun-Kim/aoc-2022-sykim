fun main() {
    fun part1(input: String): Int {

        //split by \n\n
        val list = input.split("\n\n")
            .map {
                it.split("\n")
                    .map { it.toInt() }
                    .sum()
            }

        return list.max()
    }

    fun part2(input: String): Int {

        val list = input.split("\n\n")
            .map {
                it.split("\n")
                    .map { it.toInt() }
                    .sum()
            }
            .sorted()

        return list.subList(list.size - 3, list.size).sum()
    }

    // test if implementation meets criteria from the description, like:

    val testInput = readInputRaw("Day01_test")
    val input = readInputRaw("Day01")

    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    println(part1(input))
    println(part2(input))
}
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

    val testInput = readInputRaw("data_test")
    val input = readInputRaw("data")

    check(part1(testInput) == 24000)

    println(part1(input))

    check(part2(testInput) == 45000)

    println(part2(input))
}
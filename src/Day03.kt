import javax.xml.stream.events.Characters

fun main() {

    fun getPrior(f: String, s: String) : Int {
        var char: Int? = null

        for(i in f){
            if(s.contains(i))
                char = i.code
        }

        char = char?.minus(
            if(char!! > 90){
                96
            } else{
                38
            }
        )

        return char!!;
    }

    fun getPriorVal(f: String, s: String, t: String) : Int {
        var char: Int? = null

        for(i in f){
            if(s.contains(i) && t.contains(i))
                char = i.code
        }

        char = char?.minus(
            if(char!! > 90){
                96
            } else{
                38
            }
        )

        return char!!;
    }

    fun part1(input: String): Int {
        var point = 0;
        //split by line ex [vJrwpWtwJgWr, hcsFMMfFFhFp]
        val list = input.split("\n").map { it.chunked(it.length/2) }

        for(i in list){
            point += getPrior(i.first(), i.last())
        }

        return point
    }

    fun part2(input: String): Int {
        var point = 0;
        //split by 3 line ex [vJrwpWtwJgWrhcsFMMfFFhFp, jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL, PmmdzqPrVvPwwTWBwg]
        val list = input.split("\n").chunked(3)

        print(list)
        for(i in list){
            point += getPriorVal(i[0], i[1], i[2])
        }

        return point
    }

    // test if implementation meets criteria from the description, like:

    val testInput = readInputRaw("data_test")
    val input = readInputRaw("data")

    println(part1(testInput))
    check(part1(testInput) == 157)
    println(part1(input))

    println(part2(testInput))
    check(part2(testInput) == 70)
    println(part2(input))
}
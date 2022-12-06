import javax.xml.stream.events.Characters

fun main() {

    // A, X rock
    // B, Y paper
    // C, Z scissor

    fun getPoint(f: String, s: String) : Int{
        var point = 0;

        when(f){
            "A" -> when(s){
                "X" -> point += 4
                "Y" -> point += 8
                "Z" -> point += 3
            }
            "B" -> when(s){
                "X" -> point += 1
                "Y" -> point += 5
                "Z" -> point += 9
            }
            "C" -> when(s){
                "X" -> point += 7
                "Y" -> point += 2
                "Z" -> point += 6
            }
        }

        return point;
    }

    fun getPointVar(f: String, s: String) : Int{
        var point = 0;

        when(f){
            "A" -> when(s){
                "X" -> point += 3
                "Y" -> point += 4
                "Z" -> point += 8
            }
            "B" -> when(s){
                "X" -> point += 1
                "Y" -> point += 5
                "Z" -> point += 9
            }
            "C" -> when(s){
                "X" -> point += 2
                "Y" -> point += 6
                "Z" -> point += 7
            }
        }

        return point;
    }

    fun part1(input: String): Int {
        var point = 0;
        //split by line
        val list = input.split("\n").map { it.split(" ")}

        for(i in list){
            point += getPoint(i.first(), i.last())
        }

        return point
    }

    fun part2(input: String): Int {
        var point = 0;
        //split by line
        val list = input.split("\n").map { it.split(" ")}

        for(i in list){
            point += getPointVar(i.first(), i.last())
        }

        return point
    }

    // test if implementation meets criteria from the description, like:

    val testInput = readInputRaw("data_test")
    val input = readInputRaw("data")
    check(part1(testInput) == 15)
    println(part1(input))

    check(part2(testInput) == 12)
    println(part2(input))
}
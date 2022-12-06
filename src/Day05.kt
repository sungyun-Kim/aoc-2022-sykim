import java.util.Stack
import javax.xml.stream.events.Characters

fun main() {

    fun part1(input: String): String {
        var str = "";

        val list = input.split("\n\n").map { it.split("\n") }

        val numericString = list.first().last()
        val size = numericString[numericString.length - 2].digitToInt()
        val stackList = mutableListOf<Stack<Char>>()

        for (i in 0 until size) {
            stackList.add(Stack<Char>())
        }

        val newList = list.first().subList(0, list.first().size - 1)

        for (i in 1..size) {
            for (j in newList.size - 1 downTo 0) {
                val temp = newList[j][numericString.indexOf(i.toString())]
                if (temp != ' ')
                    stackList[i - 1].add(temp)
            }
        }

        /* stack map parsed */

        val commandList = list.last()
        val parsedCommand = mutableListOf<List<Int>>()

        for (i in commandList) {
            // sooooo dirty
            parsedCommand.add(
                i.replace("move ", "").replace("from ", "").replace("to ", "").split(" ").map { it.toInt() })
        }

        for (i in parsedCommand) {
            // move i[0] times
            for (j in 0 until i[0]) {
                // from i[1] to i[2]
                if (!stackList[i[1]-1].empty())
                    stackList[i[2]-1].push(stackList[i[1]-1].pop())
            }
        }

        for(i in stackList){
            str += i.pop().toString()
        }

        return str
    }

    // add buffer for implementation
    fun part2(input: String): String {
        var str = "";

        val list = input.split("\n\n").map { it.split("\n") }

        val numericString = list.first().last()
        val size = numericString[numericString.length - 2].digitToInt()
        val stackList = mutableListOf<Stack<Char>>()

        // push 3 2 1, and pop 1 2 3 :D
        val buffer = Stack<Char>()

        for (i in 0 until size) {
            stackList.add(Stack<Char>())
        }

        val newList = list.first().subList(0, list.first().size - 1)

        for (i in 1..size) {
            for (j in newList.size - 1 downTo 0) {
                val temp = newList[j][numericString.indexOf(i.toString())]
                if (temp != ' ')
                    stackList[i - 1].add(temp)
            }
        }

        /* stack map parsed */

        val commandList = list.last()
        val parsedCommand = mutableListOf<List<Int>>()

        for (i in commandList) {
            // sooooo dirty
            parsedCommand.add(
                i.replace("move ", "").replace("from ", "").replace("to ", "").split(" ").map { it.toInt() })
        }

        for (i in parsedCommand) {
            // move i[0] times
            for (j in 0 until i[0]) {
                // from i[1] to i[2]
                buffer.push(stackList[i[1]-1].pop())
            }

            for(j in 0 until i[0]){
                stackList[i[2]-1].push(buffer.pop())
            }
        }

        for(i in stackList){
            str += i.pop().toString()
        }

        return str
    }

    // test if implementation meets criteria from the description, like:

    val testInput = readInputRaw("data_test")
    val input = readInputRaw("data")

    println(part1(testInput))
    check(part1(testInput) == "CMZ")
    println(part1(input))

    println(part2(testInput))
    check(part2(testInput) == "MCD")
    println(part2(input))
}
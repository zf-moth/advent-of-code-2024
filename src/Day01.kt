import kotlin.math.abs

fun main() {
    fun parseInput(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val leftNumbers = mutableListOf<Int>()
        val rightNumbers = mutableListOf<Int>()

        input.forEach { line ->
            val numbers = line.trim().split("\\s+".toRegex()).map { it.toInt() }
            if (numbers.size == 2) {
                leftNumbers.add(numbers[0])
                rightNumbers.add(numbers[1])
            }
        }
        return Pair(leftNumbers, rightNumbers)
    }

    fun part1(input: List<String>): Int {
        val (leftNumbers, rightNumbers) = parseInput(input)
        leftNumbers.sort()
        rightNumbers.sort()
        var totalDistance = 0
        for (i in leftNumbers.indices) {
            totalDistance += abs(leftNumbers[i] - rightNumbers[i])
        }
        return totalDistance
    }

    fun part2(input: List<String>): Int {
        val (leftNumbers, rightNumbers) = parseInput(input)
        val rightNumberCounts = rightNumbers.groupingBy { it }.eachCount()
        var similarityScore = 0
        leftNumbers.forEach { leftNumber ->
            val count = rightNumberCounts[leftNumber] ?: 0
            similarityScore += count * leftNumber
        }
        return similarityScore
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun main() {
    fun parseInput(input: List<String>): List<List<Int>> {
        return input.map { line ->
            line.trim().split("\\s+".toRegex()).map { it.toInt() }
        }
    }

    fun isSafeReport(report: List<Int>): Boolean {
        val isIncreasing = report[1] > report[0]
        for (i in 1 until report.size) {
            val diff = report[i] - report[i - 1]
            if (diff !in 1..3 && diff !in -3..-1) return false
            if ((isIncreasing && diff <= 0) || (!isIncreasing && diff >= 0)) return false
        }
        return true
    }

    fun canBeMadeSafe(report: List<Int>): Boolean {
        for (i in report.indices) {
            val modifiedReport = report.toMutableList().apply { removeAt(i) }
            if (isSafeReport(modifiedReport)) return true
        }
        return false
    }

    fun part1(input: List<String>): Int {
        val reports = parseInput(input)
        return reports.count { isSafeReport(it) }
    }

    fun part2(input: List<String>): Int {
        val reports = parseInput(input)
        return reports.count { isSafeReport(it) || canBeMadeSafe(it) }
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

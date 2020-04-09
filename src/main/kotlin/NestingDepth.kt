/* https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f */

import kotlin.math.absoluteValue

fun main() {
    val nt = readLine()!!.toInt()
    for (t in 1..nt) {
        var o = 0
        val ans = ArrayList<Char>()
        val s = readLine()!!
        for (d in s) {
            val di = Character.getNumericValue(d)
            val p = when {
                di < o -> ')'
                di > o -> '('
                else -> '_'
            }
            val delta = (di - o).absoluteValue
            (1..delta).map { ans.add(p) }
            o = di
            ans.add(d)
        }
        (1..o).map { ans.add(')') }
        println("Case #$t: ${ans.joinToString(separator = "")}")
    }
}
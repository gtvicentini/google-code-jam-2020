/* https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c */

fun main() {
    val nt = readLine()!!.toInt()
    for (t in 1..nt) {
        val n = readLine()!!.toLong()
        val m = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }
        val k = m.indices.map { m[it][it] }.sum()
        val r = m.count { it.toSet().size != it.size }
        val c = m.indices.count { col ->
            val column = m.indices.map { row -> m[row][col] }
            column.toSet().size != column.size
        }
        println("Case #$t: $k $r $c")
    }
}
/* https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9 */

fun main() {
    val nt = readLine()!!.toInt()
    for (t in 1..nt) {
        val ntsk = readLine()!!.toInt()
        val tasks = (1..ntsk).map { readLine()!!.split(" ").map { it.toInt() } }
            .mapIndexed { i, l ->  Task(i, l[0], l[1]) }
            .sortedBy { task -> task.start }
        val ans = ArrayList<Pair<Char, Task>>()
        var lc = Task(-1, -1, -1)
        var lj = Task(-1, -1, -1)
        var impossible = false
        for (task in tasks) {
            if (lc.doesNotOverlap(task)) {
                lc = task
                ans.add('C' to task)
            } else if (lj.doesNotOverlap(task)) {
                lj = task
                ans.add('J' to task)
            } else {
                impossible = true
                break
            }
        }
        val s = if (impossible) "IMPOSSIBLE" else {
            ans.sortedBy { it.second.index }
                .map { it.first }
                .joinToString(separator = "")
        }
        println("Case #$t: $s")
    }
}

data class Task(val index: Int, val start: Int, val end: Int) {
    fun doesNotOverlap(t: Task): Boolean {
        return this.start >= t.end || this.end <= t.start
    }
}
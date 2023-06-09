import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>): Unit {
    val n = q.size
    var bribes = 0

    for (i in n - 2 downTo 0) {
        var j = i

        if (q[j] > q[j + 1]) {
            var bribesPerPerson = 0

            while (j <= (q.size - 2) && q[j] > q[j + 1]) {
                val temp = q[j]
                q[j] = q[j + 1]
                q[j + 1] = temp
                
                j++
                bribesPerPerson++
            }

            bribes += bribesPerPerson

            if (bribesPerPerson > 2) {
                println("Too chaotic")
                return
            }
        }

    }

    println(bribes)
}


fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() 
}.toTypedArray()

        minimumBribes(q)
    }
}


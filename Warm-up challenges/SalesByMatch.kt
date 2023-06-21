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
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */


fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val map = mutableMapOf<Int, Int>()

    ar.forEach { current ->
        if (map.containsKey(current))
            map[current] = map[current]!!.plus(1)
        else
            map[current] = 1
    }

    var result = 0

    map.iterator().forEach {
        val pairsForColor = it.value / 2
        result += pairsForColor
    }

    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() 
}.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}

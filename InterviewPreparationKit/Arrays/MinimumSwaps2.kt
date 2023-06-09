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

fun minimumSwaps(arr: Array<Int>): Int {
    var i = 0
    var swaps = 0
    while (i < arr.size) {
        val prev = arr[i] - 1

        if (arr[i] != arr[prev]) {
            val temp = arr[i]
            arr[i] = arr[prev]
            arr[prev] = temp
            swaps++
        } else {
            i++
        }
    }
    return swaps
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() 
}.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}


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
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */


fun jumpingOnClouds(clouds: Array<Int>): Int {
    var steps = 0

    var index = 0

    while (true) {
//        if (index + 1 >= clouds.size) {
//            steps++
//            break
//        }

        if (index + 2 >= clouds.size) {
            if (index + 1 == clouds.size - 1) {
                return ++steps
            }

            break
        }

        val canMakeBigStep = clouds[index + 2] == 0

        index += if (canMakeBigStep) {
            2
        } else {
            1
        }

        steps++

//        if (index >= clouds.size - 1) break
    }

    return steps
}


fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}

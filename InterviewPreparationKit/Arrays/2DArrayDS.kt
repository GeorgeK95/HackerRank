package com.mfutbg.app

import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxHourglass = Int.MIN_VALUE

    for (i in 1 until arr.size - 1) {
        for (j in 1 until arr.size - 1) {
            val top = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
            val middle = arr[i][j]
            val bottom = arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1]
            val total = top + middle + bottom
            if (total > maxHourglass)
                maxHourglass = total
        }
    }

    return maxHourglass
}

fun main(args: Array<String>) {

    val arr = Array(6) { Array(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}

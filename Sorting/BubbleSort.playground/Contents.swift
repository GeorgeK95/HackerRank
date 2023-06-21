import Foundation

/*
 * Complete the 'countSwaps' function below.
 *
 * The function accepts INTEGER_ARRAY a as parameter.
 */

func countSwaps(a: [Int]) -> Void {
    var mutable = a
    
    let n = a.count
    var swaps = 0
    
    for _ in 0 ... n - 1 {
        for j in 0 ... n - 2 {
            if (mutable[j] > mutable[j + 1]) {
                swapArrayValues(a: &mutable, i: j, j: j + 1)
                swaps += 1
            }
        }
    }
    
    print("Array is sorted in \(swaps) swaps.")
    print("First Element: \(mutable.first!)")
    print("Last Element: \(mutable.last!)")
}

func swapArrayValues(a: inout [Int], i: Int, j: Int) {
    let temp = a[i]
    a[i] = a[j]
    a[j] = temp
}
guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
else { fatalError("Bad input") }

guard let aTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

let a: [Int] = aTemp.split(separator: " ").map {
    if let aItem = Int($0) {
        return aItem
    } else { fatalError("Bad input") }
}

guard a.count == n else { fatalError("Bad input") }

countSwaps(a: a)

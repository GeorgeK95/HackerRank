import Foundation

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

func hourglassSum(arr: Array<Array<Int>>) -> Int {
    var maxHourglass = Int.min
    
    for i in 1...arr.count - 2 {
        for j in 1...arr.count - 2 {
            let top = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
            let middle = arr[i][j]
            let bottom = arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1]
            let total = top + middle + bottom
            if total > maxHourglass {
                maxHourglass = total
            }
        }
    }
    
    return maxHourglass
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

var arr = [[Int]]()

for _ in 1...6 {
    guard let arrRowTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

    let arrRow: [Int] = arrRowTemp.split(separator: " ").map {
        if let arrItem = Int($0) {
            return arrItem
        } else { fatalError("Bad input") }
    }

    guard arrRow.count == 6 else { fatalError("Bad input") }

    arr.append(arrRow)
}

guard arr.count == 6 else { fatalError("Bad input") }

let result = hourglassSum(arr: arr)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)

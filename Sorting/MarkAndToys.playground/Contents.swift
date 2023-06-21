import Foundation

/*
 * Complete the 'maximumToys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY prices
 *  2. INTEGER k
 */

func maximumToys(prices: [Int], k: Int) -> Int {
    let sorted = prices.sorted()
    var cash = k
    var toysCount = 0
    
    for price in sorted {
        cash -= price
        
        if cash >= 0 {
            toysCount += 1
        } else {
            break
        }
    }
    
    return toysCount
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let firstMultipleInputTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }
let firstMultipleInput = firstMultipleInputTemp.split(separator: " ").map{ String($0) }

guard let n = Int(firstMultipleInput[0])
else { fatalError("Bad input") }

guard let k = Int(firstMultipleInput[1])
else { fatalError("Bad input") }

guard let pricesTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

let prices: [Int] = pricesTemp.split(separator: " ").map {
    if let pricesItem = Int($0) {
        return pricesItem
    } else { fatalError("Bad input") }
}

guard prices.count == n else { fatalError("Bad input") }

let result = maximumToys(prices: prices, k: k)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)

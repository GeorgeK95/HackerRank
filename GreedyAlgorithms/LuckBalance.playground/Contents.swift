import Foundation

/*
 * Complete the 'luckBalance' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. 2D_INTEGER_ARRAY contests
 */

func luckBalance(k: Int, contests: [[Int]]) -> Int {
     var luckSum = 0
    var mutableContests = contests
    
    mutableContests.sort { $0[0] > $1[0] }
    mutableContests.sort { $0[1] > $1[1] }
    
    let luckiests = mutableContests.prefix(k)
    let theWon = mutableContests.dropFirst(k).filter { $0[1] == 1 }
    let nonImportant = mutableContests.dropFirst(k).filter { $0[1] == 0 }
    
    for row in luckiests {
        luckSum += row[0]
    }
    
    for row in theWon {
        luckSum -= row[0]
    }
    
    for row in nonImportant {
        luckSum += row[0]
    }
    
    return luckSum
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

var contests = [[Int]]()

for _ in 1...n {
    guard let contestsRowTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

    let contestsRow: [Int] = contestsRowTemp.split(separator: " ").map {
        if let contestsItem = Int($0) {
            return contestsItem
        } else { fatalError("Bad input") }
    }

    guard contestsRow.count == 2 else { fatalError("Bad input") }

    contests.append(contestsRow)
}

guard contests.count == n else { fatalError("Bad input") }

let result = luckBalance(k: k, contests: contests)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)

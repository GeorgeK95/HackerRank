import Foundation

/*
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */

func jumpingOnClouds(c: [Int]) -> Int {
    var steps = 0
    var index = 0
    
    while (true) {
        if (index + 2 >= c.count) {
            if (index + 1 == c.count - 1) {
                return steps + 1
            }
            
            break;
        }
        
        let canMakeBigStep = c[index + 2] == 0
        
        if (canMakeBigStep) {
            index += 2
        } else {
            index += 1
        }
        
        steps += 1
    }
    
    return steps
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
else { fatalError("Bad input") }

guard let cTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

let c: [Int] = cTemp.split(separator: " ").map {
    if let cItem = Int($0) {
        return cItem
    } else { fatalError("Bad input") }
}

guard c.count == n else { fatalError("Bad input") }

let result = jumpingOnClouds(c: c)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)

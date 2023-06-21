import Foundation

/*
 * Complete the 'twoStrings' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */

func twoStrings(s1: String, s2: String) -> String {
    // Write your code here
    let charSet = CharacterSet(charactersIn: s1)
    
    for current in s2.unicodeScalars {
        if charSet.contains(current) {
            return "YES"
        }
    }
    
    return "NO"
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let q = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
else { fatalError("Bad input") }

for qItr in 1...q {
    guard let s1 = readLine() else { fatalError("Bad input") }

    guard let s2 = readLine() else { fatalError("Bad input") }

    let result = twoStrings(s1: s1, s2: s2)

    fileHandle.write(result.data(using: .utf8)!)
    fileHandle.write("\n".data(using: .utf8)!)
}

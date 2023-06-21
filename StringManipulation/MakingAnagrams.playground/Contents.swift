import Foundation

/*
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */

func makeAnagram(a: String, b: String) -> Int {
    var counter = 0
   
    var mutableA = a.sorted()
    var mutableB = b.sorted()
    
    for i in 0..<mutableA.count {
        if mutableB.contains(mutableA[i]) {
            counter += 2
            if let index = mutableB.firstIndex(of: mutableA[i]) {
                mutableB.remove(at: index)
            }
        }
    }
    
    return a.count + b.count - counter
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let a = readLine() else { fatalError("Bad input") }

guard let b = readLine() else { fatalError("Bad input") }

let res = makeAnagram(a: a, b: b)

fileHandle.write(String(res).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)

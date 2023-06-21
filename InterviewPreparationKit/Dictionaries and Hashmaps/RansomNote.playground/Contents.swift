import Foundation

/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */

func checkMagazine(magazine: [String], note: [String]) -> Void {
    var words: [String: Int] = [:]
    
    for word in note {
        if let _ = words[word] {
            words[word]! += 1
        } else {
            words[word] = 1
        }
        
    }
    
    for word in magazine {
        if let count = words[word] {
            if count == 1 {
                words.removeValue(forKey: word)
            } else {
                words[word]! -= 1
            }
        }
    }
    
    if words.isEmpty {
        print("Yes")
    } else {
        print("No")
    }
}

guard let firstMultipleInputTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }
let firstMultipleInput = firstMultipleInputTemp.split(separator: " ").map{ String($0) }

guard let m = Int(firstMultipleInput[0])
else { fatalError("Bad input") }

guard let n = Int(firstMultipleInput[1])
else { fatalError("Bad input") }

guard let magazineTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

let magazine: [String] = magazineTemp.split(separator: " ").map {
    String($0)
}

guard magazine.count == m else { fatalError("Bad input") }

guard let noteTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

let note: [String] = noteTemp.split(separator: " ").map {
    String($0)
}

guard note.count == n else { fatalError("Bad input") }

checkMagazine(magazine: magazine, note: note)

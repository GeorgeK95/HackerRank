import Foundation

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

func minimumBribes(q: [Int]) -> Void {
    var mutable = q
    let n = mutable.count
    var bribes = 0
    
    for i in stride(from: n - 2, to: -1, by: -1) {
        var j = i

        if (mutable[j] > mutable[j + 1]) {
            var bribesPerPerson = 0

            while (j <= (mutable.count - 2) && mutable[j] > mutable[j + 1]) {
                let temp = mutable[j]
                mutable[j] = mutable[j + 1]
                mutable[j + 1] = temp

                j += 1
                bribesPerPerson += 1
            }

            bribes += bribesPerPerson

            if (bribesPerPerson > 2) {
                print("Too chaotic")
                return
            }
        }

    }

    print(bribes)
}

guard let t = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
else { fatalError("Bad input") }

for tItr in 1...t {
    guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

    guard let qTemp = readLine()?.replacingOccurrences(of: "\\s+$", with: "", options: .regularExpression) else { fatalError("Bad input") }

    let q: [Int] = qTemp.split(separator: " ").map {
        if let qItem = Int($0) {
            return qItem
        } else { fatalError("Bad input") }
    }

    guard q.count == n else { fatalError("Bad input") }

    minimumBribes(q: q)
}

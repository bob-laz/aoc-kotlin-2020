package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        // a + b = 2020
        // a = 2020 - b
        // for each number, subtract form 2020 and then search the list for that value
        val intInputList = inputList.map { it.toInt() }

        val seenBefore = mutableSetOf<Int>()
        for (i in intInputList) {
            val target = 2020 - i
            // target + i = 2020
            if (seenBefore.contains(target)) {
                return i * target
            }
            seenBefore.add(i)
        }
        return -1
    }

    override fun partTwo(): Any {
        // a + b + c = 2020
        // b + c = 2020 - a
        // b + c = remainingSum
        // c = remainingSum - b
        val intInputList = inputList.map { it.toInt() }
        for (a in intInputList) {
            // hash set used because we can do fast lookups by hash instead of linear traversal of list with 3 for loops
            val hashSet = HashSet<Int>()
            val remainingSum = 2020 - a
            for (b in intInputList) {
                if (hashSet.contains(remainingSum - b)) {
                    return a * b * (remainingSum - b)
                }
                hashSet.add(b)
            }
        }
        return -1
    }
}

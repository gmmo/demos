package com.example.interview

import java.util.*

enum class LeetCode {
    //8
    ARRAY_TWO_SUM,                              //1. Two Sum
    ARRAY_FIND_CLOSEST_ELEMENTS,                //658. Find K Closest Elements
    LINKED_LIST_DELETE_NODE,                    //237. Delete Node in a Linked List
    LINKED_LIST_COPY_WITH_ARBITRARY_POINTER,    //138. Copy List with Random Pointer
    TREE_INVERT_BINARY_TREE,                    //226. Invert Binary Tree
    ARRAY_CONTAINS_DUPLICATE,                   //217. Contains Duplicate
    ARRAY_VALID_ANAGRAM,                        //242. Valid Anagram
    SLIDING_WINDOW_MAX_PROFIT,                  //121. Best Time to Buy and Sell Stock

    //16
    STRING_VALID_PARENTHESIS_STACK,             //20. Valid Parentheses
    LINKED_LIST_REVERSE_LIST,                   //206. Reverse Linked List
    LINKED_LIST_MERGE_SORTED_LIST,              //21. Merge Two Sorted Lists
    LINKED_LIST_FIND_CYCLE,                     //141. Linked List Cycle
    DP_CLIMBING_STAIRS,                         //70. Climbing Stairs
    DP_MIN_COST_CLIMBING_STAIRS,                //746. Min Cost Climbing Stairs
    DP_HOUSE_ROBBER,                            //198. House Robber

    //24
    DP_LONGEST_PALIDROMIC_SUBSTRING,            //5. Longest Palindromic Substring
    BINARY_SEARCH_2D_ARRAY,                     //74. Search a 2D Matrix
    HEAP_KTH_LARGEST_ELEMENT,                   //703. Kth Largest Element in a Stream
    GRAPH_ISLAND_COUNT,                         //200. Number of Islands
    TREE_DEPTH_OF_TREE_BFS_DFS,                 //559. Maximum Depth of N-ary Tree
    GRAPH_CLONE_DFP,                            //133. Clone Graph
    ARRAY_FIND_DUPLICATES_USING_INDEX,          //442. Find All Duplicates in an Array

    //32
    GRAPH_ISLAND_AREA,                          //695. Max Area of Island
    LINKED_LIST_LRU_CACHE,                      //146. LRU Cache
    ARRAY_LONGEST_INCREASE_SUBSEQUENCE,         //674. Longest Continuous Increasing Subsequence
    BACKTRACKING_N_QUEEN,                       //51. N-Queens
    ARRAY_LONGEST_CONSECUTIVE_SUBSEQUENCE,      //128. Longest Consecutive Sequence
    TREE_SORTED_ARRAY_TO_BINARY_TREE,           //108. Convert Sorted Array to Binary Search Tree
    LINKED_LIST_ODD_EVEN,                       //328. Odd Even Linked List
    ARRAY_REMOVE_DUPLICATE_IN_PLACE,            //26. Remove Duplicates from Sorted Array

    //40
    TREE_BINARY_TREE_IS_THE_SAME,               //100. Same Tree
    DP_WORD_BREAK,                              //139. Word Break
    ARRAY_PALINDROMIC_SUBSTRINGS,               //647. Palindromic Substrings
    BINARY_SEARCH_FIRST_LAST_INDEX,             //34. Find First and Last Position of Element in Sorted Array
    ARRAY_MAX_SUBARRAY_SUM,                     //53. Maximum Subarray
    STRING_VALID_NUMBER,                        //65. Valid Number
    BACKTRACKING_GENERATE_PARENTHESES,          //22. Generate Parentheses
    PRODUCT_OF_ARRAY_EXCEPT_SELF,               //238. Product of Array Except Self

    //48
    ENCODE_DECODE_STRINGS,                      //lint code 659 · Encode and Decode Strings
    VALID_SUDOKU,                               //36. Valid Sudoku
    ATOI_STRING,                                //8. String to Integer (atoi)
    MERGE_OVERALAPPING_INTERVALS,               //56. Merge Intervals
    BINARY_TREE_HAS_PATH_SUM,                   //112. Path Sum
    DP_COUNT_BITS,                              //338. Counting Bits
    ARRAY_MISSING_NUMBER,                       //268. Missing Number
    ARRAY_ROTATE_IMAGE,                         //48. Rotate Image

    //56
    ARRAY_REVERSE_WORDS,                        //151. Reverse Words in a String
    ARRAY_REVERSE_ONLY_LETTERS,                 //917. Reverse Only Letters
    MATH_POW_N_X,                               //50. Pow(x, n)
    ARRAY_TWO_SUM_II,                           //167. Two Sum II - Input Array Is Sorted
    WORD_SEARCH_DFS,                            //79. Word Search
    PRIORITY_QUEUE_K_CLOSEST_POINTS,            //973. K Closest Points to Origin
    ARRAY_3SUM,                                 //15. 3Sum
    MOVE_ZEROS,                                 //283. Move Zeroes

    //62
    ADD_TWO_NUMBERS_LINKED_LIST,                //2. Add Two Numbers
    TREE_LEVEL_ORDER_TRAVERSAL,                 //102. Binary Tree Level Order Traversal
    SERIALIZE_DESERIALIZE_TREE,                 //297. Serialize and Deserialize Binary Tree
    BINARY_SEARCH_FIND_MINIMUM,                 //153. Find Minimum in Rotated Sorted Array
    BINARY_SEARCH_SEARCH_ROTATED_ARRAY,         //33. Search in Rotated Sorted Array
    DP_UNIQUE_PATHS,                            //62. Unique Paths

    BIG_SUM,
    DIAGONAL_SUM,
    MAKE_LINKED_LIST,
    GRAPH_DFS,
    BINARY_SEARCH_RECURSIVE,
    BUBBLE_SORT,
    SORTED_LIST_NO_HEAD_PTR,                    //https://stackoverflow.com/questions/34250144/insert-node-to-a-sorted-list-without-head-pointer
    THREE_CONSECUTIVE_NUMBERS,                  //Return 1 if the array contains three increasing consecutive numbers (e.g. 4, 5, 6....).1..., 23, 24, 25, ...D. Otherwise return D.
}

fun leetCode_DP_UNIQUE_PATHS() {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp: MutableList<MutableList<Int>> = MutableList(m) { MutableList(n) { 0 } }
        // set rows and colums
        for (i in 0..m - 1) {
            dp[i][0] = 1
        }

        for (i in 0..n - 1) {
            dp[0][i] = 1
        }

        for (i in 1..m - 1) {
            for (j in 1..n - 1) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }

        val paths = dp[m - 1][n - 1]
        return paths
    }

    val result = uniquePaths(3, 2)
    println("paths = $result")
}

fun main() {
    val test: LeetCode = LeetCode.ARRAY_FIND_DUPLICATES_USING_INDEX

    when (test) {
        LeetCode.DP_UNIQUE_PATHS -> {
            leetCode_DP_UNIQUE_PATHS()
        }
        LeetCode.BINARY_SEARCH_SEARCH_ROTATED_ARRAY -> {
            leetCode_BINARY_SEARCH_SEARCH_ROTATED_ARRAY()
        }
        LeetCode.BINARY_SEARCH_FIND_MINIMUM -> {
            leetCode_BINARY_SEARCH_FIND_MINIMUM()
        }
        LeetCode.SERIALIZE_DESERIALIZE_TREE -> {
            leetCode_SERIALIZE_DESERIALIZE_TREE()
        }
        LeetCode.TREE_LEVEL_ORDER_TRAVERSAL -> {
            leetCode_TREE_LEVEL_ORDER_TRAVERSAL()
        }
        LeetCode.ADD_TWO_NUMBERS_LINKED_LIST -> {
            leetCode_ADD_TWO_NUMBERS_LINKED_LIST()
        }
        LeetCode.MOVE_ZEROS -> {
            leetCode_MOVE_ZEROS()
        }
        LeetCode.ARRAY_3SUM -> {
            leetCode_ARRAY_3SUM()
        }
        LeetCode.PRIORITY_QUEUE_K_CLOSEST_POINTS -> {
            leetCode_PRIORITY_QUEUE_K_CLOSEST_POINTS()
        }
        LeetCode.WORD_SEARCH_DFS -> {
            leetCode_WORD_SEARCH_DFS()
        }
        LeetCode.ARRAY_TWO_SUM_II -> {
            leetCode_ARRAY_TWO_SUM_II()
        }
        LeetCode.MATH_POW_N_X -> {
            leetCode_MATH_POW_N_X()
        }
        LeetCode.ARRAY_REVERSE_ONLY_LETTERS -> {
            leetCode_ARRAY_REVERSE_ONLY_LETTERS()
        }
        LeetCode.ARRAY_REVERSE_WORDS -> {
            leetCode_ARRAY_REVERSE_WORDS()
        }
        LeetCode.ARRAY_ROTATE_IMAGE -> {
            leetCode_ARRAY_ROTATE_IMAGE()
        }
        LeetCode.ARRAY_MISSING_NUMBER -> {
            leetCode_ARRAY_MISSING_NUMBER()
        }
        LeetCode.DP_COUNT_BITS -> {
            leetCode_DP_COUNT_BITS()
        }
        LeetCode.BINARY_TREE_HAS_PATH_SUM -> {
            leetCode_BINARY_TREE_HAS_PATH_SUM()
        }
        LeetCode.MERGE_OVERALAPPING_INTERVALS -> {
            leetCode_MERGE_OVERALAPPING_INTERVALS()
        }
        LeetCode.SORTED_LIST_NO_HEAD_PTR -> {
            leetCode_SORTED_LIST_NO_HEAD_PTR()
        }
        LeetCode.BUBBLE_SORT -> {
            leetCode_BUBBLE_SORT()
        }
        LeetCode.ATOI_STRING -> {
            leetCode_ATOI_STRING()
        }
        LeetCode.VALID_SUDOKU -> {
            leetCode_VALID_SUDOKU()
        }
        LeetCode.ENCODE_DECODE_STRINGS -> {
            leetCode_ENCODE_DECODE_STRINGS()
        }
        LeetCode.PRODUCT_OF_ARRAY_EXCEPT_SELF -> {
            leetCode_PRODUCT_OF_ARRAY_EXCEPT_SELF()
        }
        LeetCode.BACKTRACKING_GENERATE_PARENTHESES -> {
            leetCode_BACKTRACKING_GENERATE_PARENTHESES()
        }
        LeetCode.STRING_VALID_NUMBER -> {
            leetCode_STRING_VALID_NUMBER()
        }
        LeetCode.ARRAY_MAX_SUBARRAY_SUM -> {
            leetCode_ARRAY_MAX_SUBARRAY_SUM()
        }
        LeetCode.BINARY_SEARCH_FIRST_LAST_INDEX -> {
            leetCode_BINARY_SEARCH_FIRST_LAST_INDEX()
        }
        LeetCode.ARRAY_PALINDROMIC_SUBSTRINGS -> {
            leetCode_ARRAY_PALINDROMIC_SUBSTRINGS()
        }
        LeetCode.DP_WORD_BREAK -> {
            leetCode_DP_WORD_BREAK()
        }
        LeetCode.TREE_BINARY_TREE_IS_THE_SAME -> {
            leetCode_TREE_BINARY_TREE_IS_THE_SAME()
        }
        LeetCode.ARRAY_REMOVE_DUPLICATE_IN_PLACE -> {
            leetCode_ARRAY_REMOVE_DUPLICATE_IN_PLACE()
        }
        LeetCode.LINKED_LIST_ODD_EVEN -> {
            leetCode_LINKED_LIST_ODD_EVEN()
        }
        LeetCode.TREE_SORTED_ARRAY_TO_BINARY_TREE -> {
            leetCode_TREE_SORTED_ARRAY_TO_BINARY_TREE()
        }
        LeetCode.ARRAY_LONGEST_CONSECUTIVE_SUBSEQUENCE -> {
            leetCode_ARRAY_LONGEST_CONSECUTIVE_SUBSEQUENCE()
        }
        LeetCode.BACKTRACKING_N_QUEEN -> {
            leetCode_BACKTRACKING_N_QUEEN()
        }
        LeetCode.ARRAY_LONGEST_INCREASE_SUBSEQUENCE -> {
            leetCode_ARRAY_LONGEST_INCREASE_SUBSEQUENCE()
        }
        LeetCode.LINKED_LIST_LRU_CACHE -> {
            leetCode_LINKED_LIST_LRU_CACHE()
        }
        LeetCode.GRAPH_ISLAND_AREA -> {
            leetCode_GRAPH_ISLAND_AREA()
        }
        LeetCode.ARRAY_FIND_DUPLICATES_USING_INDEX -> {
            leetCode_ARRAY_FIND_DUPLICATES_USING_INDEX()
        }
        LeetCode.GRAPH_CLONE_DFP -> {
            leetCode_GRAPH_CLONE_DFP()
        }
        LeetCode.GRAPH_DFS -> {
            leetCode_GRAPH_DFS()
        }
        LeetCode.TREE_DEPTH_OF_TREE_BFS_DFS -> {
            leetCode_TREE_DEPTH_OF_TREE_BFS_DFS()
        }
        LeetCode.GRAPH_ISLAND_COUNT -> {
            leetCode_GRAPH_ISLAND_COUNT()
        }
        LeetCode.HEAP_KTH_LARGEST_ELEMENT -> {
            leetCode_HEAP_KTH_LARGEST_ELEMENT()
        }
        LeetCode.BINARY_SEARCH_2D_ARRAY -> {
            leetCode_BINARY_SEARCH_2D_ARRAY()
        }
        LeetCode.MAKE_LINKED_LIST -> {
            makeLinkedList()
        }
        LeetCode.BIG_SUM -> {
            val ar: Array<Long> = arrayOf(0xdeedbeed, 0xaaaabb0000, 0x7fff0000, 4, 5)
            aVeryBigSum(ar)
        }
        LeetCode.DIAGONAL_SUM -> {
            val arr: Array<Array<Int>> = arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(9, 8, 9),
            )
            diagonalDifference(arr)

        }
        LeetCode.ARRAY_TWO_SUM -> {
            leetCode_TWO_SUM()
        }

        LeetCode.ARRAY_FIND_CLOSEST_ELEMENTS -> {
            leetCode_FIND_CLOSEST_ELEMENTS()
        }

        LeetCode.LINKED_LIST_DELETE_NODE -> {
            leetCode_DELETE_NODE_LINKED_LIST()
        }
        LeetCode.LINKED_LIST_COPY_WITH_ARBITRARY_POINTER -> {
            leetCode_COPY_LINKED_LIST_ARBITRARY_POINTER(inString = "Some param")
        }
        LeetCode.TREE_INVERT_BINARY_TREE -> {
            leetCode_INVERT_BINARY_TREE(inParam = 56.0)
        }
        LeetCode.ARRAY_CONTAINS_DUPLICATE -> {
            leetCode_ARRAY_CONTAINS_DUPLICATE(somevar = true)
        }
        LeetCode.ARRAY_VALID_ANAGRAM -> {
            leetCode_ARRAY_VALID_ANAGRAM(null)
        }

        LeetCode.SLIDING_WINDOW_MAX_PROFIT -> {
            leetCode_SLIDING_WINDOW_MAX_PROFIT(null)
        }

        LeetCode.STRING_VALID_PARENTHESIS_STACK -> {
            leetCode_STRING_VALID_PARENTHESIS_STACK(null)
        }
        LeetCode.BINARY_SEARCH_RECURSIVE -> {
            leetCode_ALGORITHM_BINARY_SEARCH(inVar = null)
        }

        LeetCode.LINKED_LIST_REVERSE_LIST -> {
            leetCode_LINKED_LIST_REVERSE_LIST(inVar = null)
        }

        LeetCode.LINKED_LIST_MERGE_SORTED_LIST -> {
            leetCode_LINKED_LIST_MERGE_SORTED_LIST(inParam = null, inParam2 = null)
        }

        LeetCode.LINKED_LIST_FIND_CYCLE -> {
            leetCode_LINKED_LIST_FIND_CYCLE(null) //copied
        }

        LeetCode.DP_CLIMBING_STAIRS -> {
            leetCode_DP_CLIMBING_STAIRS()
        }

        LeetCode.DP_MIN_COST_CLIMBING_STAIRS -> {
            leetCode_DP_MIN_COST_CLIMBING_STAIRS()
        }
        LeetCode.DP_HOUSE_ROBBER -> {
            leetCode_DP_HOUSE_ROBBER()
        }
        LeetCode.DP_LONGEST_PALIDROMIC_SUBSTRING -> {
            leetCode_DP_LONGEST_PALIDROMIC_SUBSTRING()
        }
        else -> {
            println()
        }
    }
}

fun leetCode_BINARY_SEARCH_2D_ARRAY() {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rowCount = matrix.size
        val columnCount = matrix[0].size
        val matSize = rowCount * columnCount

        val r2c3 = matrix[2][3] // 60
        println(r2c3)

        var l = 0
        var r = matSize - 1

        while (l <= r) {
            val mid = (r + l) / 2
            val row = mid / columnCount
            val col = mid % columnCount
            val element = matrix[row][col]

            if (target < element) {
                r = mid - 1
            } else if (target > element) {
                l = mid + 1
            } else if (target == element) {
                return true
            }
        }

        return false
    }

    val list: Array<IntArray> = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60),
    )

    var res = searchMatrix(list, 12)
    res = searchMatrix(list, -1)
    res = searchMatrix(list, 100)
    res = searchMatrix(list, 30)
    res = searchMatrix(list, 3)

    println()
}

fun leetCode_DP_LONGEST_PALIDROMIC_SUBSTRING() {

    fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right
        while (L >= 0 && R < s.length && s[L] == s[R]) {
            L--
            R++
        }
        return R - L - 1
    }

    fun longestPalindrome(s: String): String {

        if (s.length < 1) return ""
        var start = 0
        var end = 0
        for (i in 0..s.length - 1) {
            val len1: Int = expandAroundCenter(s, i, i)
            val len2: Int = expandAroundCenter(s, i, i + 1)
            val len = Math.max(len1, len2)
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)

    }

    val strs = arrayListOf<String>("babad", "cbbd", "somestuffaaaaaaaaracecar!!")
    for (str in strs) {
        val res = longestPalindrome(str)
        println("longest = $res")
    }
}

fun leetCode_DP_HOUSE_ROBBER() {

    fun rob(nums: IntArray): Int {
        // Create the dp array with one more element
        // loop through the house array
        // result is the last dp array
        // dp+1 = max(dp, (dp-1)+currHouse
        // dp[i+1] = max(dp[i], house[i]+dp[i-1]

        var dpMax: Int = 0
        val dp = IntArray(nums.size + 1)

        dp[0] = 0
        dp[1] = nums[0]

        //sliding window
        // dp[i-1], dp[i], dp[i+1]
        for (i: Int in 1..nums.size - 1) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i])
        }

        dpMax = dp[dp.size - 1]

        return dpMax
    }


    var test = intArrayOf(1, 2, 3, 1)
    println(rob(test))

    test = intArrayOf(6, 7, 1, 3, 8, 2, 4)
    println(rob(test))

    test = intArrayOf(5, 3, 4, 11, 2)
    println(rob(test))
}

fun leetCode_DP_MIN_COST_CLIMBING_STAIRS() {

    fun minCostClimbingStairs(cost: IntArray): Int {
        var dp0: Int
        var dp1 = 0
        var dp2 = 0

        for (i in 0..cost.size - 1) {
            dp0 = cost[i] + Math.min(dp1, dp2)
            dp2 = dp1
            dp1 = dp0
        }

        return Math.min(dp2, dp1)
    }

    fun minCostClimbingStairs2(cost: IntArray): Int {
        // accumulate the previous too
        for (i in 2..cost.size - 1) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2])
        }
        // min of last two
        val last = cost.size - 1
        return Math.min(cost[last], cost[last - 1])
    }


    var min: Int

    var cost = intArrayOf(10, 15, 20)
    min = minCostClimbingStairs2(cost); println(min)

    cost = intArrayOf(16, 19, 10, 12, 18)
    min = minCostClimbingStairs(cost); println(min)

    cost = intArrayOf(2, 5, 3, 1, 7, 3, 4)
    min = minCostClimbingStairs(cost); println(min)

}

fun leetCode_DP_CLIMBING_STAIRS() {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        // sub problems
        dp[0] = 1   // 0 stairs, only one way
        dp[1] = 1   // one stair, only one way

        for (i in 2..dp.size - 1) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[dp.size - 1]
    }

    for (n in 1..5) {
        print("$n = ${climbStairs(n)}, ")
    }

    println()
}


fun leetCode_LINKED_LIST_FIND_CYCLE(inParam: Any? = null) {

    class ListNode(var data: Int = 0) {
        var next: ListNode? = null
    }

    fun showList(head: ListNode?) {
        var it: ListNode? = head
        var maxIter = 6
        while (it != null && maxIter > 0) {
            print("${it.data},")
            it = it.next
            maxIter--
        }
        println()
    }

    fun hasCycle(head: ListNode?): Boolean {
        var hasCycle: Boolean = false

        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast != null && fast.next != null) {
            if (null == slow) {
                hasCycle = true
                break
            }
            slow = slow.next
            fast = fast.next?.next

            if (slow == fast) {
                hasCycle = true
                break
            }
        }

        return hasCycle
    }


    //[3,2,0,-4], pos = 1
    val l1 = ListNode(3)
    val l2 = ListNode(2)
    val l3 = ListNode(0)
    val l4 = ListNode(-4)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l3
    showList(l1)

    val hasCycle = hasCycle(l1)
    println("has cycle = $hasCycle")
}

fun leetCode_LINKED_LIST_MERGE_SORTED_LIST(inParam: Int? = null, inParam2: String? = null) {

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun showList(head: ListNode?) {
        var it: ListNode? = head
        while (it != null) {
            print("${it.`val`},")
            it = it.next
        }
        println()
    }


    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        // create dummy node
        // set current to dummy node
        // insert lowest element while both list are not null
        // remember add to tail.next else it overwrites the head
        // update tail only
        // return dummy.next
        val head = ListNode()
        var tail: ListNode? = head

        var node1 = list1
        var node2 = list2

        while (node1 != null && node2 != null) {
            if (node1.`val` < node2.`val`) {
                tail?.next = node1
                node1 = node1.next
            } else {
                tail?.next = node2
                node2 = node2.next
            }

            tail = tail?.next
        }

        if (node1 != null) {
            tail?.next = node1
        }

        if (node2 != null) {
            tail?.next = node2
        }

        return head.next
    }

    //list1 = [1,2,4], list2 = [1,3,4]
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(4)
    l1.next = l2
    l2.next = l3
    l3.next = null
    showList(l1)


    val p1 = ListNode(1)
    val p2 = ListNode(3)
    val p3 = ListNode(4)
    p1.next = p2
    p2.next = p3
    p3.next = null
    showList(p1)

    val newList = mergeTwoLists(l1, p1)
    showList(newList)
}

fun leetCode_LINKED_LIST_REVERSE_LIST(inVar: Any? = null) {

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {

        // two pointers prev, curr
        // curr->next = prev
        // advance pointers
        // curr->next = saved pointer
        var prev: ListNode? = null
        var curr: ListNode? = head

        while (curr != null) {
            val nextSaved = curr.next
            curr.next = prev
            prev = curr
            curr = nextSaved
        }

        return prev
    }

    val n0 = ListNode(0)
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)

    // fix pointers
    n0.next = n1;n0.`val` = 0
    n1.next = n2;n1.`val` = 1
    n2.next = n3;n2.`val` = 2
    n3.next = n4;n3.`val` = 3
    n4.next = null;n4.`val` = 4

    fun showList(head: ListNode?) {
        var it: ListNode? = head
        while (it != null) {
            print("${it.`val`},")
            it = it.next
        }
        println()
    }

    showList(n0)
    val reverse = reverseList(n0)
    showList(reverse)
}

fun leetCode_ALGORITHM_BINARY_SEARCH(inVar: Any? = null) {
    fun search(nums: IntArray, target: Int, low: Int, high: Int): Int {
        while (low != high) {
            val mid = (low + high) / 2
            if (target > nums[mid]) {
                return search(nums, target, mid + 1, high)
            } else if (target < nums[mid]) {
                return search(nums, target, low, mid - 1)
            } else {
                return mid
            }
        }

        return -1
    }

    val sortedArray = intArrayOf(1, 3, 7, 10, 12, 21)
    var index = search(sortedArray, 12, 0, sortedArray.size - 1)
    println("found = $index")

    index = search(sortedArray, 19, 0, sortedArray.size - 1)
    println("found = $index")
}

fun leetCode_STRING_VALID_PARENTHESIS_STACK(someVar: Int?) {
    fun isValid(s: String): Boolean {
        var result = false

        // create a hash map
        // use a stack
        val stack = Stack<Char>()

        for (c in s) {
            val isCloseBracket: Boolean =
                c == ')' || c == '}' || c == ']'

            // only pops is the brackers are blanced
            // discard edge cases and push the rest

            // two edge cases to consider
            if (stack.isEmpty()) {
                if (isCloseBracket) {
                    return false
                } else {
                    stack.push(c)
                }
            } else {
                // If we found any complete pair of bracket
                // then pop
                if ((stack.last() == '(' && c == ')')
                    || (stack.last() == '{' && c == '}')
                    || (stack.last() == '[' && c == ']')
                ) {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            }
        }

        if (stack.isEmpty()) {
            result = true
        }

        return result
    }

    var expression: String
    var valid: Boolean

    expression = "[]]"
    valid = isValid(expression)
    println("result = $valid")


    expression = "()[]{}"
    valid = isValid(expression)
    println("result = $valid")

    expression = "(([{{{{}}}}]))"
    valid = isValid(expression)
    println("result = $valid")

    expression = ")("
    valid = isValid(expression)
    println("result = $valid")
}

fun leetCode_SLIDING_WINDOW_MAX_PROFIT(somevar: Int? = null) {
    val stockPrice = intArrayOf(7, 1, 5, 3, 6, 4)
    fun maxProfit(prices: IntArray): Int {
        var maxP: Int = 0

        var l: Int = 0
        var r: Int = 1

        while (r < prices.size) {
            // we only have profit if we buy low (left) and sell high (right)
            if (prices[l] < prices[r]) {
                val profit = prices[r] - prices[l]
                maxP = Math.max(profit, maxP)
            } else {
                l = r
            }
            r++
        }

        return maxP
    }

    val maxProfit = maxProfit(stockPrice)
    println(maxProfit)
}

fun leetCode_ARRAY_VALID_ANAGRAM(someParam: Any?) {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val hashS = hashMapOf<Char, Int>()
        val hashT = hashMapOf<Char, Int>()

        for (ii in 0..s.length - 1) {
            val charS = s[ii]
            val charT = t[ii]

            val countS = hashS[charS]
            if (null == countS) {
                hashS.put(charS, 1)
            } else {
                hashS[charS] = countS + 1
            }

            val countT = hashT[charT]
            if (null == countT) {
                hashT.put(charT, 1)
            } else {
                hashT[charT] = countT + 1
            }
        }

        // check if hashes are equal
        var valid: Boolean = true
        if (false) {
            for (ii in 0..s.length - 1) {
                val countS = hashS[s[ii]]
                val countT = hashT[s[ii]]

                if (countS != countT) {
                    valid = false
                    break
                }
            }
        } else {
            if (hashS.size != hashT.size) {
                return false
            }
            for ((key, valueS) in hashS) {
                val valueT = hashT[key]
                if (valueT != valueS) {
                    return false
                }
            }
        }

        return valid
    }

    var s: String = "dustyazz"
    var t: String = "studyzzz"
    println(isAnagram(s, t))

    s = "a gentleman"
    t = "elegant man"
    println(isAnagram(s, t))
}

fun leetCode_ARRAY_CONTAINS_DUPLICATE(somevar: Boolean = true) {

    fun containsDuplicate(nums: IntArray): Boolean {
        var containsDuplicate: Boolean = false
        val hashMap = hashMapOf<Int, Int>()

        // keys are the array values
        for (ii in 0..nums.size - 1) {
            val value = hashMap[nums[ii]]
            if (null == value) {
                hashMap.put(nums[ii], ii)
            } else {
                containsDuplicate = true
                break
            }
        }

        return containsDuplicate
    }

    val arr = intArrayOf(1, 2, 4, 7, 7, 8)
    println(containsDuplicate(arr))
}

fun leetCode_INVERT_BINARY_TREE(inParam: Double = 56.0) {
    //Input: root = [4,2,7,1,3,6,9]
    //Output: [4,7,2,9,6,3,1]

    // Depth first search with swap
    class TreeNode(var value: Int = -1) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /*
        inOrderTraversal (left, right)
        swap nodes
        always check for null
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        if (null != root) {
            invertTree(root.left)
            invertTree(root.right)

            // swap
            var nodeSwap: TreeNode? = TreeNode(-1)
            nodeSwap = root.left
            root.left = root.right
            root.right = nodeSwap
        }

        return root
    }

    fun inOrderTraversal(root: TreeNode?) {
        if (null != root) {
            inOrderTraversal(root.left)
            val value = root.value
            print("$value, ")
            inOrderTraversal(root.right)
        }
    }

    // build tree
    var n4 = TreeNode(4)
    var n2 = TreeNode(2)
    var n1 = TreeNode(1)
    var n3 = TreeNode(3)

    var n7 = TreeNode(7)
    var n6 = TreeNode(6)
    var n9 = TreeNode(9)

    /*
                  n4
            n2          n7
        n1      n3   n6      n9
     */


    n4.left = n2
    n4.right = n7

    n2.left = n1
    n2.right = n3

    n7.left = n6
    n7.right = n9

    inOrderTraversal(n4)
    println()
    val newTree = invertTree(n4)
    inOrderTraversal(newTree)
    println()
}

fun leetCode_COPY_LINKED_LIST_ARBITRARY_POINTER(inString: String?) {
    //Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    //Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

    class Node(var `val`: Int = 0) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        // step 1 make copy and pointer hash
        val hash = hashMapOf<Node?, Node?>()
        hash.put(null, null)

        var head: Node? = node

        while (head != null) {
            val value = head.`val`
            val copy = Node(value)
            hash.put(head, copy)
            head = head.next
        }

        // step 2 fix all pointers
        head = node
        while (head != null) {
            val copy = hash[head]
            copy?.next = hash[head.next]
            copy?.random = hash[head.random]
            head = head.next
        }

        val copy = hash[node]

        return copy
    }

    val n0 = Node(7)
    val n1 = Node(13)
    val n2 = Node(11)
    val n3 = Node(10)
    val n4 = Node(1)

    // fix pointers
    n0.next = n1;n0.`val` = 7; n0.random = null
    n1.next = n2;n1.`val` = 13; n1.random = n0
    n2.next = n3;n2.`val` = 11; n2.random = n4
    n3.next = n4;n3.`val` = 10; n3.random = n2
    n4.next = null;n4.`val` = 1; n4.random = n0

    fun showList(head: Node?) {
        var it: Node? = head
        while (it != null) {
            print("[${it.`val`}]")
            it = it.next
        }
        println()
    }

    val copy = copyRandomList(n0)

    showList(n0)
    showList(copy)
}

fun leetCode_DELETE_NODE_LINKED_LIST() {

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun deleteNode(node: ListNode?) {
        if (null == node) return
        // Since we know input node is not last node, so nextNode will not be null
        val nextNode: ListNode? = node.next
        // Step 2
        node.`val` = nextNode!!.`val`
        // Step 3
        node.next = nextNode.next
        nextNode.next = null
    }

    fun showList(root: ListNode?) {
        var it: ListNode? = root
        while (it != null) {
            print("${it.`val`}, ")
            it = it.next
        }
        println()
    }

    //Input: head = [4,5,1,9], node = 1
    //Output: [4,5,9]

    val n4: ListNode = ListNode(4)
    val n5 = ListNode(5)
    val n1 = ListNode(1)
    val n9 = ListNode(9)

    n4.next = n5
    n5.next = n1
    n1.next = n9

    val root = n4
    showList(root)
    deleteNode(n1)
    showList(root)
}

fun leetCode_FIND_CLOSEST_ELEMENTS() {
    //arr = [1,2,3,4,5], k = 4, x = 3

    val arr = arrayListOf<Int>(1, 2, 3, 4, 5, 8, 10)
    val k = 4
    val x = 5

    var lo: Int = 0
    var hi = arr.size - k

    while (lo < hi) {
        val mid: Int = (lo + hi) / 2
        // understand this part
        if (x - arr[mid] > arr[mid + k] - x) {
            lo = mid + 1
        } else {
            hi = mid
        }
    }

    val result = mutableListOf<Int>()
    // kotlin for loops are inclusive
    for (i in lo..lo + k - 1) {
        result.add(arr[i])

        print("${arr[i]}, ")
    }

    println()
}


fun leetCode_TWO_SUM() {
    // check if the complement is in the hash

    fun twoSum(nums: IntArray, target: Int): Boolean {
        val hash = hashMapOf<Int, Int>()
        var found: Boolean = false

        for (e in nums) {
            val complement = target - e

            val value: Int? = hash[complement]
            if (null != value) {
                found = true
                println("Elements = $value, $complement")
                break
            }

            hash.put(e, complement)
        }

        return found
    }

    val nums = intArrayOf(1, 4, 7, 9)
    val target = 50

    println(twoSum(nums, 50))
}

fun aVeryBigSum(ar: Array<Long>): Long {
    // Write your code here
    var sum: Long = 0
    for (item in ar) {
        print("$item,")
        sum += item
    }
    println(sum)
    return sum
}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var d1 = 0
    var d2 = 0
    val dim = arr[0].size

    for (i in 0..dim - 1) {
        d1 += arr[i][i]
        d2 += arr[dim - 1 - i][i]
    }

    println(d1)
    println(d2)

    val absDiff =
        if (d1 >= d2) d1 - d2
        else d2 - d1

    println(absDiff)

    return absDiff
}

////////////////////////////
// Simple data structures
////////////////////////////

class NodeD(var value: Int = 0) {
    var next: NodeD? = null
    var prev: NodeD? = null
    override fun toString(): String {
        return value.toString()
    }
}

fun makeLinkedList() {
    val root = NodeD(1)
    val node1 = NodeD(2)
    val node2 = NodeD(3)
    val node3 = NodeD(4)

    root.next = node1

    node1.prev = root
    node1.next = node2

    node2.prev = node1
    node2.next = node3

    node3.prev = node2

    var it: NodeD? = root

    while (it != null) {
        println(it)
        it = it.next
    }

    println("end")
}

fun leetCode_HEAP_KTH_LARGEST_ELEMENT() {

    class KthLargest(k: Int, nums: IntArray) {

        val currArr = mutableListOf<Int>()
        val pq: PriorityQueue<Int> = PriorityQueue<Int>()
        var k2: Int? = k


        fun add(x: Int): Int? {
            currArr.add(x)
            val lowestValue: Int? = pq.peek()
            if ((lowestValue is Int) && (x > lowestValue)) {
                pq.remove()
                pq.add(x)
                k2 = pq.peek()
            }
            return k2
        }

        // create priority queue of k elements
        init {
            for (n in 0..nums.size - 1) {
                val x = nums[n]
                currArr.add(x)
                pq.add(x)
                if (pq.size > k) {
                    pq.remove(x)
                }
                k2 = pq.peek()
            }
        }

    }//end

    // 3, [4, 5, 8, 2]
    val temp: ArrayList<Int> = arrayListOf(4, 5, 8, 2)
    val nums = IntArray(temp.size)

    for (n in 0..temp.size - 1) {
        nums[n] = temp[n]
    }

    val obj = KthLargest(3, nums)
    println(obj.add(3))
    println(obj.add(5))
    println(obj.add(10))
    println(obj.add(9))
    println(obj.add(4))
}

fun leetCode_GRAPH_ISLAND_COUNT() {

    fun islandCount(grid: MutableList<MutableList<Char>>): Int {

        var count: Int = 0

        fun bfs(
            grid: MutableList<MutableList<Char>>,
            x: Int, y: Int,
            maxX: Int, maxY: Int
        ) {

            if (x > maxX || x < 0 ||
                y > maxY || y < 0 ||
                grid[y][x] == '0'
            ) {
            } else {

                //
                //             (x, y-1)
                //   (x-1, y)      k      (x+1, y)
                //             (x1, y+1)
                //


                // mark node as visited
                grid[y][x] = '0'
                bfs(grid, x - 1, y, maxX, maxY)
                bfs(grid, x + 1, y, maxX, maxY)
                bfs(grid, x, y - 1, maxX, maxY)
                bfs(grid, x, y + 1, maxX, maxY)
            }
        }

        // loop over the grid
        val col = grid[0].size
        val row = grid.size
        for (y in 0..row - 1) {
            for (x in 0..col - 1) {
                val k = grid[y][x]
                if ('1' == k) {
                    count++
                    bfs(grid, x, y, col - 1, row - 1)
                }
            }
        }

        return count
    }

    val island1: MutableList<MutableList<Char>> = arrayListOf(
        arrayListOf('1', '1', '1', '1', '0'),
        arrayListOf('1', '1', '0', '1', '0'),
        arrayListOf('1', '1', '0', '0', '0'),
        arrayListOf('0', '0', '0', '0', '0')
    )

    val island2: MutableList<MutableList<Char>> = arrayListOf(
        arrayListOf('1', '1', '0', '0', '0'),
        arrayListOf('1', '1', '0', '0', '0'),
        arrayListOf('0', '0', '1', '0', '0'),
        arrayListOf('0', '0', '0', '1', '1')
    )

    val island3: MutableList<MutableList<Char>> = arrayListOf(
        arrayListOf('1', '0', '0', '0', '0'),
        arrayListOf('0', '1', '0', '1', '0'),
        arrayListOf('0', '0', '0', '0', '0'),
        arrayListOf('0', '0', '0', '1', '0')
    )

    var count = islandCount(island1); println(count)
    count = islandCount(island2); println(count)
    count = islandCount(island3); println(count)
}

fun leetCode_GRAPH_CLONE_DFP() {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    fun cloneGraph(node: Node?): Node? {

        val head: Node? = node

        // step 1 make copy and pointer hash
        val hash = mutableMapOf<Node?, Node?>()
        hash.put(null, null)

        val visitedNodes = mutableSetOf<Node>()

        fun dfpMakeHash(node: Node?) {
            if ((node != null) &&
                !visitedNodes.contains(node)
            ) {
                visitedNodes.add(node)
                val copy = Node(node.`val`)
                hash.put(node, copy)
                println("visited = ${node.`val`}")
                for (n in node.neighbors) {
                    dfpMakeHash(n)
                }
            }
        }

        fun dfpCopyGraph(node: Node?) {
            if ((node != null) &&
                !visitedNodes.contains(node)
            ) {
                visitedNodes.add(node)
                val copy = hash[node]
                copy?.`val` = node.`val`
                println("copied = ${copy?.`val`}")
                for (n in node.neighbors) {
                    copy?.neighbors?.add(hash[n])
                    dfpCopyGraph(n)
                }
            }
        }

        dfpMakeHash(head)
        visitedNodes.clear()
        dfpCopyGraph(head)
        val headCopy = hash[head]
        return headCopy
    }

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    node1.neighbors.add(node2); node1.neighbors.add(node4)
    node2.neighbors.add(node1); node2.neighbors.add(node3)
    node3.neighbors.add(node2); node3.neighbors.add(node4)
    node4.neighbors.add(node1); node4.neighbors.add(node3)

    cloneGraph(node1)
    println(node1)
}

fun leetCode_GRAPH_DFS() {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    val visited = mutableSetOf<Node>()

    fun dfp(node: Node?) {
        if (node == null) return

        if (!visited.contains(node)) {
            visited.add(node)
            println("visited = ${node.`val`}")
            for (n in node.neighbors) {
                dfp(n)
            }
        }
    }


    //    1---2
    //    |   |
    //    4---3
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    node1.neighbors.add(node2); node1.neighbors.add(node4)
    node2.neighbors.add(node1); node2.neighbors.add(node3)
    node3.neighbors.add(node2); node3.neighbors.add(node4)
    node4.neighbors.add(node1); node4.neighbors.add(node3)

    dfp(node1)
}

fun leetCode_TREE_DEPTH_OF_TREE_BFS_DFS() {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    var max: Int = 0

    fun getMaxDepthDFS(root: Node?, depth: Int) {
        if (null == root) return
        max = Math.max(max, depth)
        for (node in root.children) {
            getMaxDepthDFS(node, depth + 1)
        }
    }

    fun maxDepthDFS(root: Node?): Int {
        if (null == root) return 0
        getMaxDepthDFS(root, 1)
        return max
    }

    fun getMaxBFS(root: Node?): Int {
        if (null == root) return 0
        var depth: Int = 0

        val q: Queue<Node> = LinkedList<Node>()
        q.add(root)

        while (!q.isEmpty()) {
            val size = q.size

            for (i in 0..size - 1) {
                val currNode = q.remove()
                for (child in currNode.children) {
                    q.add(child)
                }
            }

            depth++
        }

        return depth
    }


    // build tree
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)

    val node7 = Node(7)
    val node11 = Node(11)
    val node14 = Node(14)

    val c1 = listOf<Node?>(node3, node2, node4)
    node1.children = c1
    val c3 = listOf<Node?>(node5, node6, node7)
    node3.children = c3
    val c7 = listOf<Node?>(node11)
    node7.children = c7
    val c11 = listOf<Node?>(node14)
    node11.children = c11


    var depth = maxDepthDFS(node1)
    println(depth)

    depth = getMaxBFS(node1)
    println(depth)
}

fun leetCode_ARRAY_FIND_DUPLICATES_USING_INDEX() {
    fun findDuplicates(nums: IntArray): List<Int> {
        val result = ArrayList<Int>()
        for (i in 0..nums.size - 1) {
            val newIndex = Math.abs(nums[i]) - 1
            if (nums[newIndex] < 0) {
                result.add(newIndex + 1)
            } else {
                nums[newIndex] = -nums[newIndex]
            }
        }
        return result
    }

    val numbers: IntArray = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    val result = findDuplicates(numbers)
    for (r in result) {
        println("$r, ")
    }
    println()
}

fun leetCode_GRAPH_ISLAND_AREA() {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var currArea: Int = 0
        var maxArea: Int = 0

        fun bfs(
            grid: Array<IntArray>,
            x: Int, y: Int,
            maxX: Int, maxY: Int
        ) {

            if (x > maxX || x < 0 ||
                y > maxY || y < 0 ||
                grid[y][x] == 0
            ) {
            } else {

                //
                //             (x, y-1)
                //   (x-1, y)      k      (x+1, y)
                //             (x1, y+1)
                //


                // mark node as visited
                grid[y][x] = 0
                currArea++
                bfs(grid, x - 1, y, maxX, maxY)
                bfs(grid, x + 1, y, maxX, maxY)
                bfs(grid, x, y - 1, maxX, maxY)
                bfs(grid, x, y + 1, maxX, maxY)
            }
        }

        // loop over the grid
        val col = grid[0].size
        val row = grid.size
        for (y in 0..row - 1) {
            for (x in 0..col - 1) {
                val k = grid[y][x]
                if (1 == k) {
                    bfs(grid, x, y, col - 1, row - 1)

                    // consumed all the area
                    maxArea = Math.max(currArea, maxArea)

                    // reset current area
                    currArea = 0
                }
            }
        }

        return maxArea
    }


    val i1: Array<IntArray> = arrayOf(
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
    )

    val i2: Array<IntArray> = arrayOf(
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(1, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 1),
    )

    var maxArea = maxAreaOfIsland(i1); println(maxArea)
    maxArea = maxAreaOfIsland(i2); println(maxArea)
}

fun leetCode_LINKED_LIST_LRU_CACHE() {

    class Node(var value: Int = -1) {
        var prev: Node? = null
        var next: Node? = null
        var key: Int = -1
    }

    class LRUCache(capacity: Int) {

        val head = Node() // newest
        val tail = Node() // oldest
        val hash = hashMapOf<Int, Node>()
        var maxCapacity: Int = -1

        init {
            head.next = tail
            tail.prev = head
            maxCapacity = capacity
        }

        fun add(node: Node) {
            // most recent goes to head
            val headNext = head.next
            head.next = node
            node.prev = head
            node.next = headNext
            headNext?.prev = node
        }

        fun remove(node: Node?) {
            val nextNode = node?.next
            val prevNode = node?.prev
            nextNode?.prev = prevNode
            prevNode?.next = nextNode
        }

        fun get(key: Int): Int {
            var result: Int = -1
            val node: Node? = hash.get(key)
            if (null != node) {
                remove(node)
                add(node)   // accessed, not it is at the head
                result = node.value
            }
            return result
        }

        fun put(key: Int, value: Int) {
            val node: Node? = hash.get(key)
            if (null != node) {
                remove(node)
                add(node)   // accessed, not it is at the head
                node.value = value  // update its value
            } else {
                // full, remove least recent
                if (hash.size == maxCapacity) {
                    hash.remove(tail.prev?.key)
                    remove(tail.prev)
                }

                // add new node
                val newNode = Node(value)
                newNode.key = key
                hash.put(key, newNode)
                add(newNode)
            }
        }
    }


    val lRUCache = LRUCache(2); print("null,")
    var res: Int = -1

    lRUCache.put(1, 0); print("null,") // cache is {1=0}
    lRUCache.put(2, 2); print("null,")// cache is {1=0, 2=2}
    res = lRUCache.get(1); print("$res,")// return 0
    lRUCache.put(3, 3); print("null,")// LRU key was 2, evicts key 2, cache is {1=0, 3=3}
    res = lRUCache.get(2); print("$res,")// returns -1 (not found)
    lRUCache.put(4, 4); print("null,") // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    res = lRUCache.get(1); print("$res,")// return -1 (not found)
    res = lRUCache.get(3); print("$res,")// return 3
    res = lRUCache.get(4);print("$res,")// return 4
}

fun leetCode_BACKTRACKING_N_QUEEN() {
    fun solveNQueens(n: Int): List<List<String>> {

        val N: Int = n

        fun isSafe(board: List<List<String>>, row: Int, col: Int): Boolean {
            //Check this row on left side
            //<--Q
            for (i in 0..col - 1) {
                if (board[row][i] == "Q") {
                    return false
                }
            }

            //Check upper diagonal on left side
            //^...
            //.\..
            //..\.
            //...Q
            var i = row
            var j = col
            while (i >= 0 && j >= 0) {
                if (board[i][j] == "Q") {
                    return false
                }
                i--; j--
            }

            //Check lower diagonal on left side
            //...Q
            //../.
            //./..
            //v...
            i = row
            j = col
            while (j >= 0 && i < N) {
                if (board[i][j] == "Q") {
                    return false
                }
                i++; j--
            }
            return true
        }


        fun solveNQUtil(board: MutableList<MutableList<String>>, col: Int): Boolean {

            //println("base case col: $col")
            /* base case: If all queens are placed
               then return true */
            if (col >= N) {
                return true
            }

            /* Consider this column and try placing
               this queen in all rows one by one */
            //for (int i = 0; i < N; i++) {
            for (i in 0..N - 1) {
                /* Check if the queen can be placed on
                   board[i][col] */
                if (isSafe(board, i, col)) {
                    /* Place this queen in board[i][col] */
                    board[i][col] = "Q"

                    /* recur to place rest of the queens */
                    if (solveNQUtil(board, col + 1) == true) {
                        return true
                    }

                    /* If placing queen in board[i][col]
                       doesn't lead to a solution then
                       remove queen from board[i][col] */
                    board[i][col] = "." // BACKTRACK
                }
            }

            /* If the queen can not be placed in any row in
               this column col, then return false */
            return false
        }

        val board: MutableList<MutableList<String>> = MutableList(n) { MutableList(n) { "." } }
        val result = solveNQUtil(board, 0)

        return board
    }

    fun dumpBoard(board: List<List<String>>, n: Int) {
        for (r in 0..n - 1) {
            for (c in 0..n - 1) {
                val element = board[r][c]
                print("$element, ")
            }
            println()
        }
    }

    for (k in 4..8) {
        dumpBoard(solveNQueens(k), k); println("")
    }

    if (false) {
        val stringArray: Array<Array<String>> = Array(4) { Array(4) { "" } }
        val stringList: List<List<String>> = List(4) { List(4) { "" } }
    }
}

fun leetCode_ARRAY_LONGEST_INCREASE_SUBSEQUENCE() {
    fun findLengthOfLCIS(nums: IntArray): Int {

        var result: Int = 0
        var anchor: Int = 0
        for (i in 0..nums.size - 1) {
            // breaks anchor
            if (i > 0 && nums[i - 1] >= nums[i]) {
                anchor = i
            }
            result = Math.max(result, i - anchor + 1)
        }

        return result
    }

    var seq: IntArray = intArrayOf(1, 3, 5, 4, 7)
    findLengthOfLCIS(seq)
}

fun leetCode_ARRAY_LONGEST_CONSECUTIVE_SUBSEQUENCE() {
    fun longestConsecutive(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        // add all numbers to a set
        for (n in nums) {
            set.add(n)
        }

        var max_seq_length: Int = 0

        for (n in nums) {

            var current_num = n
            var current_length = 1


            // look for the smallest number in the sequence before looping
            // let's say hash has 3,4,5
            // if 5-1 = 4 exists, don't loop forward
            // buf if 3-2 does not exist, this might be the smallest,
            // trying all sub-sequences that start at n-1 and save the longest
            if (!set.contains(current_num - 1)) {
                while (set.contains(current_num + 1)) {
                    current_num += 1
                    current_length += 1
                }
                max_seq_length = Math.max(current_length, max_seq_length)
            }
        }

        return max_seq_length
    }

    val nums = intArrayOf(100, 4, 200, 1, 9, 2)
    println(longestConsecutive(nums))

    val nums2 = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
    println(longestConsecutive(nums2))
}

fun leetCode_TREE_SORTED_ARRAY_TO_BINARY_TREE() {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun makeBinaryTree(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val mid = (start + end) / 2
        val root = TreeNode(nums[mid])
        root.left = makeBinaryTree(nums, start, mid - 1)
        root.right = makeBinaryTree(nums, mid + 1, end)
        return root
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        var root = makeBinaryTree(nums, 0, nums.size - 1)
        return root
    }

    fun preOrder(node: TreeNode?) {
        if (node == null) {
            return
        }
        val num = node.`val`
        print("$num, ")
        preOrder(node.left)
        preOrder(node.right)
    }

    val nums = intArrayOf(-10, -3, 0, 5, 9)
    val root = sortedArrayToBST(nums)
    preOrder(root)

    println()
    val nums2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val root2 = sortedArrayToBST(nums2)
    preOrder(root2)
}

fun leetCode_LINKED_LIST_ODD_EVEN() {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        if (null == head) {
            return null
        }

        var odd = head
        val headEven = head.next
        var even = headEven

        while (even != null && even.next != null && odd != null) {
            odd.next = even.next
            odd = odd.next
            even.next = odd?.next
            even = even.next
        }

        odd?.next = headEven
        return head
    }

    //head = [1,2,3,4,5]

    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)

    n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5

    var head: ListNode? = oddEvenList(n1)

    while (head != null) {
        val v = head.`val`
        print("$v->")
        head = head.next
    }

    println()
}

fun leetCode_ARRAY_REMOVE_DUPLICATE_IN_PLACE() {
    fun removeDuplicates(nums: IntArray): Int {
        var l = 1

        for (r in 1..nums.size - 1) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r]
                l += 1
            }
        }

        return l
    }

    var nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)

    var size = removeDuplicates(nums)
    println(size)
}

fun leetCode_TREE_BINARY_TREE_IS_THE_SAME() {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

        if ((null == p) && (null == q)) {
            return true
        }
        if (null == p || null == q) {
            return false
        }
        if (p.`val` != q.`val`) {
            return false
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    val n1 = TreeNode(1)
    val n2 = TreeNode(2)
    val n3 = TreeNode(3)
    n1.left = n2; n2.right = n3

    val p1 = TreeNode(1)
    val p2 = TreeNode(2)
    val p3 = TreeNode(3)
    p1.left = p2; p2.right = p3


    val same: Boolean = isSameTree(n1, p1)
    println("result = $same")
}

fun leetCode_DP_WORD_BREAK() {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        var result: Boolean = false

        // one more than the size
        val dp: Array<Boolean> = Array(s.length + 1) { false }

        // set last  element to true
        dp[s.length] = true

        // bottom to top approach
        for (i in s.length - 1 downTo 0) {
            //val currString = s.substring(i)
            //println(currString)

            for (w in wordDict) {
                // if current substring of size w is
                // less than the full string, test the substring of size w
                if ((i + w.length <= s.length)
                    && (s.substring(i, i + w.length) == w)
                ) {
                    dp[i] = dp[i + w.length]
                }
                if (dp[i]) {
                    break
                }
            }
        }

        result = dp[0]

        return result
    }

    val wordDict = listOf<String>("apple", "pen", "hello", "world", "car", "ca", "rs")
    var result: Boolean
    var s: String

    s = "cars"
    result = wordBreak(s, wordDict)
    println("$s = $result")

    s = "applenpen"
    result = wordBreak(s, wordDict)
    println("$s = $result")

    s = "helloworld"
    result = wordBreak(s, wordDict)
    println("$s = $result")

}

fun leetCode_ARRAY_PALINDROMIC_SUBSTRINGS() {
    fun countSubstrings(s: String): Int {
        var count: Int = 0
        if (1 == s.length) {
            return 1
        }

        for (i in 0..s.length - 1) {
            var l: Int = i
            var r: Int = i

            while (l >= 0 && r < s.length && s[l] == s[r]) {
                count += 1
                l -= 1
                r += 1
            }

            l = i
            r = i + 1

            while (l >= 0 && r < s.length && s[l] == s[r]) {
                count += 1
                l -= 1
                r += 1
            }
        }
        return count
    }

    var count = countSubstrings("abc")
    println(count)
    count = countSubstrings("aaa")
    println(count)
}

fun leetCode_BINARY_SEARCH_FIRST_LAST_INDEX() {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1, -1)
        //first
        var start = 0
        var end = nums.size - 1
        var first = -1
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] >= target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
            if (nums[mid] == target) {
                first = mid
            }
        }

        // last
        start = 0
        end = nums.size - 1
        var last = -1
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] <= target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
            if (nums[mid] == target) {
                last = mid
            }
        }

        result[0] = first
        result[1] = last
        return result
    }

    //[5,7,7,8,8,10], target = 8
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    var result = searchRange(nums, 8)
}

fun leetCode_ARRAY_MAX_SUBARRAY_SUM() {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum: Int = nums[0]
        var currSum = maxSum
        for (i in 1..nums.size - 1) {
            currSum = Math.max(nums[i] + currSum, nums[i])
            maxSum = Math.max(currSum, maxSum)
        }
        return maxSum
    }

    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val sum = maxSubArray(nums)
    println("max = $sum")
}

fun leetCode_STRING_VALID_NUMBER() {
    fun isNumber(s: String): Boolean {
        var valid: Boolean = true

        var digitseen = false
        var eseen = false
        var dotseen = false
        var countPlusMinus = 0

        for (i in 0..s.length - 1) {

            val ch: Char = s[i]
            var chPrev: Char? = null
            if (i > 0) {
                chPrev = s[i - 1]
            }

            // digits
            if (ch.isDigit()) {
                digitseen = true
            }
            // minus/plus
            else if (ch == '+' || ch == '-') {

                // invalid cases [6-, 6+0, ++--]

                // we cannot have more than 2
                if (countPlusMinus >= 2) {
                    return false
                }

                //+/- in the middle must be proceeded by e
                //e+
                if (i > 0 && (chPrev != 'E' && chPrev != 'e')) {
                    return false
                }

                // last character cannot be +/-
                if (i == s.length - 1) {
                    return false
                }

                countPlusMinus++
            }
            // dot
            else if (ch == '.') {
                // invalid cases
                //[e.] [.7.] [.]
                if (eseen || dotseen) {
                    return false
                }
                // dot as last character with no number
                if (i == s.length - 1 && !digitseen) {
                    return false
                }
                dotseen = true
            } else if (ch == 'e' || ch == 'E') {
                // e/E
                // [ee, e45, 45e]
                if (eseen || !digitseen || i == s.length - 1) {
                    return false
                }
                eseen = true
            } else {
                return false
            }
        }


        return valid
    }

    val nums = arrayListOf(
        "2", "0089", "-0.1", "+3.14",
        "4.", "-.9", "2e10", "-90E3", "3e+7",
        "+6e-1", "53.5e93", "-123.456e789"
    )

    val invalidNums = arrayListOf(
        "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"
    )

    for (n in nums) {
        val valid = isNumber(n)
        println("$n = $valid")
    }

    for (n in invalidNums) {
        val valid = isNumber(n)
        println("$n = $valid")
    }

}

fun leetCode_BACKTRACKING_GENERATE_PARENTHESES() {
    val output_arr = mutableListOf<String>()

    fun backtrack(current_string: String, open: Int, close: Int, max: Int) {
        if (current_string.length == max * 2) {
            output_arr.add(current_string)
        }

        if (open < max) {
            backtrack(current_string + "(", open + 1, close, max)
        }
        if (close < open) {
            backtrack(current_string + ")", open, close + 1, max)
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        backtrack("", 0, 0, n)
        return output_arr
    }

    val output: List<String> = generateParenthesis(5)
    for (s in output) {
        println(s)
    }
}

fun leetCode_PRODUCT_OF_ARRAY_EXCEPT_SELF() {
    fun productExceptSelf(nums: IntArray): IntArray {
        val N = nums.size
        val output_arr = IntArray(N)
        output_arr[0] = 1

        //left product
        for (i in 1..N - 1) {
            output_arr[i] = output_arr[i - 1] * nums[i - 1]
        }

        // right product
        var R: Int = 1
        for (i in N - 1 downTo 0) {
            output_arr[i] = output_arr[i] * R
            R = R * nums[i]
        }
        return output_arr
    }

    val nums = intArrayOf(1, 2, 3, 4)
    val result = productExceptSelf(nums)
    for (r in result) {
        print("$r, ")
    }

    println()
}

fun leetCode_ENCODE_DECODE_STRINGS() {
    fun encode(slist: ArrayList<String>): String {
        var encoded: String = ""

        for (s in slist) {
            encoded += s.length.toString() + "#" + s
        }

        return encoded
    }

    fun decode(s: String): List<String> {
        val decoded = mutableListOf<String>()
        var j = 0

        while (j < s.length) {
            // get count
            val i = j
            while (s[j] != '#') {
                j++
            }
            val len = s.substring(i, j).toInt()
            j++ // skip #
            val str = s.substring(j, j + len)
            decoded.add(str)
            j += len
        }

        val immutableList: List<String> = decoded.toList()
        return immutableList
    }

    val slist = arrayListOf<String>("lint", "co#####################de", "loves", "you")
    val encoded = encode(slist)
    println(encoded)
    val decoded = decode(encoded)
    for (d in decoded) {
        print("$d, ")
    }
    println()
}

fun leetCode_VALID_SUDOKU() {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val seen = HashSet<String>()

        for (r in 0..8) {
            for (c in 0..8) {
                val curr = board[r][c]
                if (curr != '.') {
                    val added_row = seen.add("row_" + r + "_" + curr)
                    val added_col = seen.add("col_" + c + "_" + curr)
                    val added_square = seen.add("sq_" + (r / 3) + "_" + (c / 3) + curr)
                    if (!added_row || !added_col || !added_square) {
                        return false
                    }
                }

            }
        }

        return true
    }

    val stringArray = Array(9) { CharArray(9) { '.' } }

    val arrs = arrayOf(
        arrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    for (r in 0..8) {
        for (c in 0..8) {
            stringArray[r][c] = arrs[r][c]
        }
    }

    val result = isValidSudoku(stringArray)
    println(result)
}

fun leetCode_ATOI_STRING() {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        val s2 = s.trim()
        if (s2.length < 1) {
            return 0
        }
        var sign: Int = 1

        var i = 0
        if (s2[i] == '+') {
            sign = 1
            i++
        } else if (s2[i] == '-') {
            sign = -1
            i++
        }

        var parsed: Long = 0
        // check limits
        val lowLimt: Long = (Int.MIN_VALUE).toLong()
        val highLimit: Long = (Int.MAX_VALUE).toLong()
        var parsedSigned: Long = 0

        while (i < s2.length) {
            val cur = s2[i]
            if (cur.isDigit()) {
                val curInt = cur - '0'
                parsed = (parsed * 10 + curInt)
                parsedSigned = parsed * sign.toLong()
                if (parsedSigned > 0 && parsedSigned > highLimit) {
                    return highLimit.toInt()
                } else if (parsedSigned < lowLimt) {
                    return lowLimt.toInt()
                }

            } else {
                break
            }
            i++
        }

        return parsedSigned.toInt()
    }

    val s: String = "-9223372036854775808"
    val num: Int = myAtoi(s)
    println(num)
}

fun leetCode_SORTED_LIST_NO_HEAD_PTR() {
    class SList(n: Int = 0) {
        var next: SList? = null
        var foo: Int = n

        fun addNode(n: Int) {
            val head: SList = this
            val newNode = SList(n)

            if (n < head.foo) {
                val temp = head.foo
                newNode.next = head.next
                head.next = newNode
                //swap values
                head.foo = n
                newNode.foo = temp
                return
            }

            //scan and insert into the right location
            var p: SList? = head
            var prev = head
            while (p != null && n > p.foo) {
                prev = p
                p = p.next
            }

            if (p != null) {
                val temp = p.foo
                newNode.next = p.next
                p.next = newNode

                // swap values
                newNode.foo = p.foo
                p.foo = n
            } else {
                prev.next = newNode
            }
        }

        fun output() {
            var head: SList? = this
            while (head != null) {
                print("${head.foo}, ")
                head = head.next
            }
            println()
        }
    }

    val list: SList = SList(5)
    list.addNode(3)
    list.addNode(18)
    list.addNode(8)
    list.addNode(12)
    list.addNode(33)
    list.addNode(9)
    list.addNode(1)
    list.addNode(23)
    list.output()

}

fun leetCode_BUBBLE_SORT() {
    fun bubbleSort(nums: IntArray): IntArray {
        var j = 1
        val lastIndex = nums.size - 1

        while (j <= lastIndex) {
            for (i in lastIndex downTo j) {
                if (nums[i - 1] > nums[i]) {
                    val tmp = nums[i - 1]
                    nums[i - 1] = nums[i]
                    nums[i] = tmp
                }
            }
            j++
        }

        return nums
    }

    val nums = intArrayOf(1000, 10, 2, 12, 412, 4, 5, 76, 1)
    val numsSorted = bubbleSort(nums)

    for (n in numsSorted) {
        print("$n, ")
    }

    println()
}

fun leetCode_MERGE_OVERALAPPING_INTERVALS() {
    fun sortArray(intervals: Array<IntArray>) {
        var i = 1
        while (i <= intervals.size - 1) {
            for (j in intervals.size - 1 downTo i) {
                val a1 = intervals[j]
                val a2 = intervals[j - 1]

                if (a1[0] < a2[0]) {
                    for (k in 0..1) {
                        val temp = a1[k]
                        a1[k] = a2[k]
                        a2[k] = temp
                    }
                }
            }
            i++
        }
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }

        val result = mutableListOf<IntArray>()
        intervals.sortBy { internalArray -> internalArray.first() }
        // add first element
        var current = intArrayOf(intervals[0][0], intervals[0][1])
        result.add(current)

        for (j in intervals) {
            //(1,3), (2,6)
            val current_begin = current[0]  //1
            val current_end = current[1]    //3
            val next_begin = j[0]           //2
            val next_end = j[1]             //6
            if (current_end >= next_begin) {
                //merge
                current[1] = Math.max(next_end, current[1])
            } else {
                result.add(j)
                current = j
            }
        }

        return result.toTypedArray()
    }

    val intervals: Array<IntArray> = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(15, 18),
        intArrayOf(8, 10),
        intArrayOf(2, 6),
    )

    val result = merge(intervals)

    for (i in result) {
        val s = i[0].toString() + ", " + i[1].toString()
        print("[$s], ")
    }
    println()
}

fun leetCode_BINARY_TREE_HAS_PATH_SUM() {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        } else if (root.left == null && root.right == null && targetSum - root.`val` == 0) {
            return true
        } else {
            val leftPath = hasPathSum(root.left, targetSum - root.`val`)
            val rightPath = hasPathSum(root.right, targetSum - root.`val`)
            return leftPath || rightPath
        }
    }

    /*
               5
            /     \
           4       8
          /       / \
       11       13   4
       /\             \
     7   2             1
     */

    val t5 = TreeNode(5)
    val t4 = TreeNode(4)
    val t8 = TreeNode(8)
    val t11 = TreeNode(11)
    val t13 = TreeNode(13)
    val t4b = TreeNode(4)
    val t7 = TreeNode(7)
    val t2 = TreeNode(2)
    val t1 = TreeNode(1)

    t5.left = t4
    t5.right = t8

    t4.left = t11

    t11.left = t7

    t11.right = t2

    t8.left = t13
    t8.right = t4b
    t4b.right = t1

    val result = hasPathSum(t5, 22)
    println(result)
}

fun leetCode_ARRAY_ROTATE_IMAGE() {
    fun rotate(matrix: Array<IntArray>) {
        val N = matrix.size - 1

        //transpose
        for (r in 0..N) {
            for (c in r..N) {
                val temp = matrix[r][c]
                matrix[r][c] = matrix[c][r]
                matrix[c][r] = temp
            }
        }

        //swap columns
        for (r in 0..N) {
            for (c in 0..N / 2) {
                val temp = matrix[r][c]
                matrix[r][c] = matrix[r][N - c]
                matrix[r][N - c] = temp
            }
        }
    }

    val m: Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    rotate(m)

    for (r in 0..m.size - 1) {
        for (c in 0..m[r].size - 1) {
            print("${m[r][c]},")
        }
        println()
    }
}

fun leetCode_ARRAY_MISSING_NUMBER() {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        for (n in nums) {
            sum += n
        }
        val n = nums.size + 1
        // sum = (first+last)*n
        //       -------------
        //          2
        val a1 = 0
        val a2 = n - 1
        val missing = ((a1 + a2) * n) / 2 - sum
        return missing
    }

    var nums = intArrayOf(0, 2)
    var miss = missingNumber(nums)
    println(miss)

    nums = intArrayOf(0, 1)
    miss = missingNumber(nums)
    println(miss)

    nums = intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)
    miss = missingNumber(nums)
    println(miss)

    nums = intArrayOf(3, 0, 1)
    miss = missingNumber(nums)
    println(miss)
}

fun leetCode_DP_COUNT_BITS() {
    fun countBits(n: Int): IntArray {
        val dp = IntArray(n + 1)
        dp[0] = 0
        for (i in 1..n) {
            //println("$i /2 = ${i / 2}, $i % 2 - ${i % 2}")
            dp[i] = dp[i / 2] + i % 2
        }
        return dp
    }

    val res = countBits(16)
    for (n in res) {
        print("$n, ")
    }
    println()
}

fun leetCode_PRIORITY_QUEUE_K_CLOSEST_POINTS() {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val result: Array<IntArray> = Array(k) { IntArray(2) }
        val compareByDistance = Comparator<IntArray> { a: IntArray, b: IntArray ->
            // distance to origin
            val da = Math.sqrt((a[0] * a[0] + a[1] * a[1]).toDouble())
            val db = Math.sqrt((b[0] * b[0] + b[1] * b[1]).toDouble())
            if (da < db) {
                1
            } else if (da > db) {
                -1
            } else {
                0
            }
        }
        val maxHeap = PriorityQueue<IntArray>(compareByDistance)
        for (p in points) {
            maxHeap.add(p)
            if (maxHeap.size > k) {
                maxHeap.remove()
            }
        }

        // pop the k closest elements
        var i = 0
        while (!maxHeap.isEmpty()) {
            val e = maxHeap.remove()
            result[i++] = e
        }

        return result
    }

    val list: Array<IntArray>
    val k: Int = 3
    list = arrayOf(
        intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4),
        intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, 0),
    )
    var result: Any?

    result = kClosest(list, k)
    for (r in result) {
        println("${r[0]}, ${r[1]}")
    }
    println()

    //[[3,3],[5,-1],[-2,4]], k = 2
}


fun leetCode_WORD_SEARCH_DFS() {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size

        fun dfs(r: Int, c: Int, count: Int, word: String): Boolean {
            if (count == word.length) {
                return true
            }

            if (r < 0 || r >= rows || c < 0 || c >= cols ||
                board[r][c] != word[count]
            ) {
                return false
            }

            val temp = board[r][c]
            board[r][c] = ' '
            val result: Boolean =
                dfs(r, c - 1, count + 1, word) ||
                        dfs(r, c + 1, count + 1, word) ||
                        dfs(r - 1, c, count + 1, word) ||
                        dfs(r + 1, c, count + 1, word)
            board[r][c] = temp

            return result
        }

        for (r in 0..rows - 1) {
            for (c in 0..cols - 1) {
                val ch = board[r][c]
                if (ch == word[0]) {
                    val result = dfs(r, c, 0, word)
                    if (true == result) {
                        return true
                    }
                }
            }
        }

        return false
    }

    val sarr = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    )

    val result = exist(sarr, "ABCCED")
}

fun leetCode_ARRAY_TWO_SUM_II() {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)

        var s = 0
        var e = numbers.size - 1

        while (s < e) {
            val cs = numbers[s] + numbers[e]
            if (cs == target) {
                break
            }
            // 1, 2, 3, 4, 5 = 9
            else if (cs < target) {
                s++
            } else {
                e--
            }
        }

        result[0] = s + 1; result[1] = e + 1
        return result
    }

    fun output(nums: IntArray) {
        println("[${nums.get(0)}, ${nums.get(1)}]")
    }

    var nums: Any?
    var result: Any?

    nums = intArrayOf(2, 7, 11, 15)
    result = twoSum(nums, 9)
    output(nums)

    nums = intArrayOf(2, 3, 4)
    result = twoSum(nums, 6)
    output(nums)
}


fun leetCode_MATH_POW_N_X() {
    fun myPow2(x: Double, n: Int): Double {
        if (0.0 == x) return 0.0
        if (0 == n) return 1.0
        if (1 == n) return x

        val nabs = Math.abs(n)
        var r = x
        for (i in 1..nabs - 1) {
            r *= x
        }
        if (n < 0) {
            r = 1.0 / r
        }
        return r
    }

    fun myPow(x: Double, n: Int): Double {
        if (1 == n) return x

        val nabs = Math.abs(n)

        fun recursive(x: Double, n: Int): Double {
            if (0.0 == x) return 0.0
            if (0 == n) return 1.0

            val res = recursive(x * x, n / 2)
            val even = (n % 2) == 0
            if (even) {
                return res
            } else {
                return x * res
            }
        }

        val res = recursive(x, nabs)

        if (n > 0) {
            return res
        } else {
            return 1.0 / res
        }
    }

    var r: Double = 0.0
    r = myPow(2.0, -2)
    println(r)

    r = myPow(2.10000, 3)
    println(r)
}

fun leetCode_ARRAY_REVERSE_WORDS() {
    fun reverseWords(s: String): String {
        if (s.isEmpty()) {
            return ""
        }
        // add one space at the end to avoid handling edge cases
        val s2 = "$s "
        val stack = Stack<String>()

        var b = 0
        var e = 0
        for (i in 0..s2.length - 2) {
            val c = s2[i]
            if (c == ' ') {
                b++; e++
            } else {
                e++
                val c2 = s2[e]
                if (c2 == ' ') {
                    // token found
                    val token = s2.substring(b, e)
                    stack.push(token)
                    b = e
                }
            }
        }

        var output = ""
        do {
            output += stack.pop()
            if (stack.isEmpty()) {
                break
            } else {
                output += " "
            }
        } while (true)

        return output
    }

    var s = "   hello   world    "
    //var s = "   ab  cd"
    var r = reverseWords(s)
    println(r)

    s = "the sky is blue"
    r = reverseWords(s)
    println(r)

    s = "a good   example"
    r = reverseWords(s)
    println(r)

}

fun leetCode_ARRAY_REVERSE_ONLY_LETTERS() {
    fun reverseOnlyLetters(s: String): String {

        val stack = Stack<Char>()

        // all in the stack
        for (c in s) {
            if (c.isLetter()) {
                stack.push(c)
            }
        }

        var s2 = ""
        for (c in s) {
            if (c.isLetter()) {
                s2 += stack.pop()
            } else {
                s2 += c
            }
        }

        return s2
    }

    var s = "ab-cd"
    var r = reverseOnlyLetters(s)
    println(r)

    s = "a-bC-dEf-ghIj"
    r = reverseOnlyLetters(s)
    println(r)
}

fun leetCode_ADD_TWO_NUMBERS_LINKED_LIST() {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var l3: ListNode? = head

        var lp1: ListNode? = if (l1 != null) l1 else null
        var lp2: ListNode? = if (l2 != null) l2 else null

        var carry = 0
        while (lp1 != null || lp2 != null) {
            val l1_val = if (lp1 != null) lp1.`val` else 0
            val l2_val = if (lp2 != null) lp2.`val` else 0
            val current_sum = l1_val + l2_val + carry
            carry = current_sum / 10
            val last_digit = current_sum % 10
            val new_node = ListNode(last_digit)
            l3?.next = new_node
            if (lp1 != null) lp1 = lp1.next
            if (lp2 != null) lp2 = lp2.next
            l3 = l3?.next
        }

        if (carry > 0) {
            val last_node = ListNode(carry)
            l3?.next = last_node
            l3 = l3?.next
        }

        return head.next
    }

    val l1: ListNode
    val l2: ListNode
    val n2 = ListNode(2)
    val n4 = ListNode(4)
    val n3 = ListNode(3)

    val n5 = ListNode(5)
    val n6 = ListNode(6)
    val n42 = ListNode(4)

    n2.next = n4; n4.next = n3
    n5.next = n6; n6.next = n42
    l1 = n2
    l2 = n5

    val res = addTwoNumbers(l1, l2)
    println(res)

}

fun leetCode_MOVE_ZEROS() {
    fun moveZeroes(nums: IntArray): Unit {
        var slow = 0
        for (i in 0..nums.size - 1) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i]
            }
        }

        for (i in slow..nums.size - 1) {
            nums[i] = 0
        }
    }

    val nums = intArrayOf(0, 1, 0, 3, 12)
    val result = moveZeroes(nums)
}

fun leetCode_ARRAY_3SUM() {
    fun threeSum(nums: IntArray): List<List<Int>> {

        // see this thread for more examples
        //https://stackoverflow.com/questions/63676163/how-to-initialize-list-listint-in-kotlin
        val output = mutableListOf<MutableList<Int>>()
        nums.sort()

        for (i in 0..nums.size - 3) {
            // skip duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                var low = i + 1
                var high = nums.size - 1
                while (low < high) {
                    val sum = nums[i] + nums[low] + nums[high]
                    if (0 == sum) {
                        val res = mutableListOf<Int>(nums[i], nums[low], nums[high])
                        output.add(res)
                        // skip replicates
                        while (low < high && nums[low] == nums[low + 1]) low++
                        while (low < high && nums[high] == nums[high - 1]) high--
                        low++
                        high--
                    } else if (sum > 0) {
                        high--
                    }
                    // sum < 0
                    else {
                        low++
                    }
                }
            }
        }

        return output
    }

    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val r = threeSum(nums)
    for (n in r) {
        println(n)
    }
}

fun leetCode_BINARY_SEARCH_SEARCH_ROTATED_ARRAY() {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right: Int = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (target == nums[mid]) return mid
            if (nums[left] <= nums[mid]) {
                // L   T M     R
                // 4,5,6,7,0,1,2
                // l =0, r = 6, m = 3
                // go to the correct sorted array (left)
                //if (nums[left] <= target && target < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                // L     M   T R
                // 4,5,6,7,0,1,2
                // l =0, r = 6, m = 3
                // go to the shifte array
                //if (nums[mid] < target && target <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }

        return -1
    }

    //nums = [4,5,6,7,0,1,2], target = 0
    //val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val nums = intArrayOf(5, 1, 2, 3)
    val result = search(nums, 1)
    println(result)

}

fun leetCode_BINARY_SEARCH_FIND_MINIMUM() {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 0) return -1
        if (nums.size == 1) return nums[0]

        //find the seam
        //4,5,6,7,1,2,3,
        //      ---
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = (l + r) / 2
            // minimum is at the seam
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid]
            }
            // if sorted to the left AND not sorted to the right
            // go to the unsorted side
            else if (nums[l] <= nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        // found condition outside the loop is left
        return nums[l]
    }

    //nums = [4,5,6,7,0,1,2], target = 0
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val result = findMin(nums)
    println(result)
}

fun leetCode_SERIALIZE_DESERIALIZE_TREE() {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class Codec {
        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            var s: String = ""

            fun dfs(n: TreeNode?) {
                if (n == null) {
                    s += "*"
                    return
                }

                s += n.`val`.toString() + ","
                dfs(n.left)
                dfs(n.right)
            }

            dfs(root)
            return s
        }

        // Decodes your encoded data to tree.
        fun deserialize(dataIn: String): TreeNode? {
            var data: String = dataIn

            fun decode(): TreeNode? {
                if (data.isEmpty()) {
                    return null
                }

                if (data[0] == '*') {
                    data = data.substring(1)
                    return null
                }

                var pos = 0
                var no = ""
                while (data[pos] != ',') {
                    no += data[pos++]
                }
                val n = TreeNode(no.toInt())
                data = data.substring(pos + 1)
                n.left = decode()
                n.right = decode()
                return n
            }

            if (data.isEmpty()) {
                return null
            }

            val root = decode()
            return root
        }
    }   //class Codec


    val ser = Codec()
    val deser = Codec()

    val n1 = TreeNode(1)
    val n2 = TreeNode(2)
    val n3 = TreeNode(3)
    val n4 = TreeNode(4)
    val n5 = TreeNode(5)
    //serialize as
    // 1,2,**3,4,**5,**

    n1.left = n2
    n1.right = n3
    n3.left = n4
    n3.right = n5

    val data = ser.serialize(n1)
    println(data)
    val ans = deser.deserialize(data)
    println(ans)
}

fun leetCode_TREE_LEVEL_ORDER_TRAVERSAL() {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // breath first search
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val bfs = mutableListOf<MutableList<Int>>()

        if (null == root) {
            return bfs
        }

        val q: Queue<TreeNode> = LinkedList<TreeNode>()
        q.add(root)

        while (!q.isEmpty()) {
            val size = q.size
            val current_list = mutableListOf<Int>()

            // process each node of the queue
            for (i in 0..size - 1) {
                val n = q.remove()
                // visit node value
                current_list.add(n.`val`)

                //add left and right node to the queue
                if (n.left != null) q.add(n.left)
                if (n.right != null) q.add(n.right)
            }

            bfs.add(current_list)
        }

        return bfs
    }

    val root = TreeNode(3)
    val n9 = TreeNode(9)
    val n20 = TreeNode(20)
    val n15 = TreeNode(15)
    val n7 = TreeNode(7)

    root.left = n9
    root.right = n20
    n20.left = n15
    n20.right = n7

    val result = levelOrder(root)
    println(result)

    /*
          3
        /  \
       9   20
          /  \
         15  7
    */

}

# Java LeetCode Solutions

A Maven project for solving LeetCode problems in Java.

## Project Structure

```
java-leetcode/
├── src/
│   ├── main/java/com/leetcode/
│   │   ├── Solution.java          # Base abstract class
│   │   ├── Template.java          # Template for new solutions
│   │   └── Solution{Number}.java  # Your solutions
│   └── test/java/com/leetcode/
│       └── SolutionTest.java      # Base test class
├── pom.xml                         # Maven configuration
└── README.md
```

## Adding a New Solution

1. Copy `Template.java` to `src/main/java/com/leetcode/Solution{Number}.java`
2. Implement the `solve` method with your solution
3. Update `getTitle`, `getUrl`, and `getDifficulty`
4. Add test cases in `src/test/java/com/leetcode/Solution{Number}Test.java`

## Building and Testing

```bash
# Compile
mvn compile

# Run all tests
mvn test

# Run specific test
mvn test -Dtest=Solution1Test

# Package
mvn package
```

## Example

```java
// Solution1.java
public class Solution1 extends Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

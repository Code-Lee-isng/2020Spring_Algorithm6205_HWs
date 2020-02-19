# Thoughts

While finding other two nums to make it equal to target - arr[i], we can refer to LeetCode problem 1 Two Sum. And two pinters is the best method to solve it.

# Brute Force

T, O(n^3), S, O(1). Always the worst way.

# HashMap

T, O(n^2), S, O(n).

Store it in HashMap, using it to find the third element. Since getint element is constant for HashMap, It reduces time complexity.

# Two pointers

Refer to repositories LeetCode 001 Two Sum. Also, with left = 0, we can use binary search to find where the right position is.

# Optimization

Two pointers, binary search finds right position.

# References

repositories LeetCode 001 Two Sum.

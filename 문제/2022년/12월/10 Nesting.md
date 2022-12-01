### Nesting
Determine whether a given string of parentheses (single type) is properly nested.

[URL](https://app.codility.com/demo/results/training45K3RC-4ZJ/)
* * *

### 문제
A string S consisting of N characters is called properly nested if:

- S is empty;
- S has the form "(U)" where U is a properly nested string;
- S has the form "VW" where V and W are properly nested strings.

For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

```java
class Solution { public int solution(String S); }
```

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

- N is an integer within the range [0..1,000,000];
- string S is made only of the characters "(" and/or ")".

### 풀이
```java
import java.util.Stack;

class Solution {
    public static Stack<Character> stack;

    public int solution(String S) {
        stack = new Stack<>();
        for (char c : S.toCharArray()) {
            calc(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void calc(char c) {
        if(c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
        else stack.push(c);
    }
}
```

### 메모

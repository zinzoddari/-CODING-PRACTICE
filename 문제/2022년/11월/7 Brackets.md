### Brackets
Determine whether a given string of parentheses (multiple types) is properly nested.

[URL](https://app.codility.com/demo/results/trainingRQTZD6-XYA/)
* * *


### 문제
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
- S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
- S has the form "VW" where V and W are properly nested strings.
- For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

```java
class Solution { public int solution(String S); }
```

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

- N is an integer within the range [0..200,000];
- string S is made only of the following characters: "(", "{", "[", "]", "}" and/or ")".


### 풀이
```java
import java.util.Stack;

class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if(!stack.isEmpty()) {
                if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == '}' && stack.peek() == '{') stack.pop();
                else if(c == ']' && stack.peek() == '[') stack.pop();
                else stack.push(c);
            }
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
```

### 메모

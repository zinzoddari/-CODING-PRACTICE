### 깊이 우선 탐색(DFS)
DFS란, 그래프 완전 탐색(그래프의 모든 노드를 방문하는) 기법이다.

구현 방법으로는, [ 재귀함수 ]와, [ Stack ]을 이용해서 구현 할 수 있다.

시간 복잡도는 노드 갯수(V)와 에지 갯수(E)를 더한 값으로, [ O(V + E)]이다.
<br/>
<br/>
- #### Stack 이론 구현
1. 사용하고자 하는 데이터를 모두 초기화 한다. (인접리스트, 방문 배열, Stack 등)
2. 시작 점을 Stack에 담고, 방문 배열에 체크를 해준다.
3. Stack에 담겨있는 값을 pop하고, 해당 node와 인접한 값을 Stack에 담고, 방문 배열 체크를 해준다.
4. Stack이 빌 때 까지 3번을 반복한다.

- Stack 구현 코드
```java
public class Dfs {
    static boolean visit[];
    static Stack<Integer> stack = new Stack();
    static StringBuilder stringBuilder;

    public static String stack(int[][] array, int startNode) {
        //사용하고자 하는 데이터 초기화
        stringBuilder = new StringBuilder();

        visit = new boolean[array.length];

        //첫 시작 노드를 Stack에 담고, 방문 배열 체크
        stack.add(startNode);
        visit[startNode] = true;

        dfsStack(array);

        return stringBuilder.toString().trim();
    }

    private static void dfsStack(int[][] array) {
        //Stack이 빌 때까지 반복한다.
        while (!stack.isEmpty()) {
            int node = stack.pop();

            stringBuilder.append(node).append(" ");

            //인접 노드를 Stack에 담아주고, 방문 배열 체크
            for (int i = 0; i < array[node].length; i++) {
                if (!visit[array[node][i]]) {
                    stack.add(array[node][i]);
                    visit[array[node][i]] = true;
                }
            }
        }
    }
}
```
<br />

- 테스트코드
```java
import static org.junit.jupiter.api.Assertions.*;

class DfsTest {

    @Test
    @DisplayName("stack을 이용한 dfs 알고리즘 구현")
    void dfsStack() {
        //given
        int array[][] = {{}, {2, 3}, {5, 6}, {4}, {6}, {}, {}};
        int startNode = 1;

        //when
        String result = Dfs.stack(array, startNode);

        //then
        assertEquals(result, "1 3 4 6 2 5");
    }
}
```
---
- #### 재귀함수 이론 구현
1. 사용하고자 하는 데이터를 모두 초기화 한다. (인접리스트, 방문 배열 등)
2. 시작 노드와 함께 dfs 함수를 호출한다.
3. 해당 노드의 방문 배열을 체크 해 준다.
4. 해당 노드의 인접 노드를 가져와 방문하지 않았다면, 해당 노드를 가지고 dfs 함수를 호출해준다.
<br/>

- 재귀함수 구현 코드

```java
public class Dfs {
    static boolean visit[];
    static StringBuilder stringBuilder;

    public static String recursion(int[][] array, int startNode) {
        //사용하고자 하는 데이터를 모두 초기화 한다. (인접리스트, 방문 배열 등)
        stringBuilder = new StringBuilder();

        visit = new boolean[array.length];

        //시작 노드와 함께 dfs 함수를 호출
        dfsRecursion(array, startNode);

        return stringBuilder.toString().trim();
    }

    private static void dfsRecursion(int[][] array, int startNode) {
        int node = startNode;

        if(visit[node]) {
            return;
        }
        //해당 노드의 방문 배열을 체크 해 준다.
        visit[node] = true;
        stringBuilder.append(node).append(" ");

        for (int j = 0; j < array[node].length; j++) {
            //해당 노드의 인접 노드를 가져와 방문하지 않았다면, 해당 노드를 가지고 dfs 함수를 호출
            if(!visit[array[node][j]]) {
                dfsRecursion(array, array[node][j]);
            }
        }
    }
}
```
<br/>

- 테스트 코드
```java
import static org.junit.jupiter.api.Assertions.*;

class DfsTest {
    @Test
    @DisplayName("재귀함수를 이용한 dfs 알고리즘 구현")
    void recursion() {
        //given
        int array[][] = {{}, {2, 3}, {5, 6}, {4}, {6}, {}, {}};
        int startNode = 1;

        //when
        String result = Dfs.recursion(array, startNode);

        //then
        assertEquals(result, "1 2 5 6 3 4");
    }
}
```

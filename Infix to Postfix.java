// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String str) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put('(', 0);
        map.put(')', 0);
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)) || str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (!stack.empty()) {
                    if (str.charAt(i) == '(') {
                        stack.push(str.charAt(i));
                        continue;
                    } else if (str.charAt(i) == ')') {
                        while (stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        continue;
                    }
                    while (map.get(str.charAt(i)) <= map.get(stack.peek())) {
                        sb.append(stack.pop());
                        if (stack.empty()) {
                            break;
                        }
                    }
                    stack.push(str.charAt(i));
                } else {
                    stack.push(str.charAt(i));
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

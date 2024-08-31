import java.util.Stack;

public class Parser {
    TokenManager tokenManager;
    Stack<Character> stack;
    char currentToken;

    private void advance() {
        currentToken = tokenManager.next();
    }

    public Parser(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        this.stack = new Stack<>();
        stack.push('$');
        stack.push('S');
        advance();
    }

    public boolean validate() {
        boolean finished = false;
        while (!finished) {
            if (stack.isEmpty()) {
                finished = currentToken == '$'; 
                return finished;
            }

            char top = stack.peek();
            switch (top) {
                case 'S':
                    stack.pop();
                    if (currentToken == 'b') {
                        // S --> bSb
                        stack.push('b');
                        stack.push('S');
                        stack.push('b');
                        advance();
                    } else if (currentToken == 'c') {
                        // S --> cA
                        stack.push('A');
                        stack.push('c');
                        advance();
                    } else {
                        finished = true;
                    }
                    break;

                case 'A':
                    stack.pop();
                    if (currentToken == 'b') {
                        // A --> AA
                        stack.push('A');
                        stack.push('A');
                        advance();
                    } else if (currentToken == 'c') {
                        // A --> bAS
                        stack.push('S');
                        stack.push('A');
                        stack.push('b');
                        advance();
                    } else if (currentToken == 'd') {
                        // A --> bc
                        stack.push('c');
                        stack.push('b');
                        advance();
                    } else {
                        finished = true;
                    }
                    break;

                case 'b':
                case 'c':
                    if (currentToken == top) {
                        stack.pop();
                        advance();
                    } else {
                        finished = true;
                    }
                    break;

                default:
                    finished = true;
                    break;
            }
        }
        return false;
    }
}

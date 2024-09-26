import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(checkBrackets("( {  }  )"));
    }

    public static boolean checkBrackets(String brackets) {
        Stack<Character> testStack = new Stack<Character>();

        Character[] openBrackets = {'(', '[', '{'};
        Character[] closeBrackets = {')', ']', '}'};
        List<Character> openBracketsArray = Arrays.asList(openBrackets);
        List<Character> closeBracketsArray = Arrays.asList(closeBrackets);

        char[] bracketsSequence = brackets.toCharArray();
        for (char i: bracketsSequence) {
            if (openBracketsArray.contains(i)) {
                testStack.push(i);
            } else if (closeBracketsArray.contains(i)) {
                try {
                    int testBracketPosition = openBracketsArray.indexOf(testStack.peek());
                    int elementPosition = closeBracketsArray.indexOf(i);
                    if (testBracketPosition != elementPosition) {
                        return false;
                    } else {
                        testStack.pop();
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }

        return testStack.size() == 0;
    }
}

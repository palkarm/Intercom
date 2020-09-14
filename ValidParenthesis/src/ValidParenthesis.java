import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;


public class ValidParenthesis {
    Stack<Character> stack = new Stack<> ();

    public static void main(String[] args) {
        if (isValid ( "()" )){
            System.out.println ( "oooo" );
        }

    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();
        for(char c :s.toCharArray ()){
            if(c=='(')
                stack.push ( ')' );
            else if (c=='{')
                stack.push ( '}' );
            else if(c=='[')
                stack.push ( ']' );
            if(stack.empty ()||stack.pop ()!=c) return false;
        }
        return stack.empty ();
    }
}





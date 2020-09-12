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
        for (int i = 0; i < s.length (); i++) {
            //right bracket pop
            if(s.charAt ( i )=='(' ||s.charAt ( i )=='{' || s.charAt ( i )=='[')
                stack.push ( s.charAt ( i ) );
            else if ( s.charAt ( i )=='(' && !stack.empty ()  && stack.peek ()!=')') return false;
            else if (  s.charAt ( i )=='{'&&!stack.empty () && stack.peek ()!='}') return false;
            else if ( s.charAt ( i )=='[' && !stack.empty ()&& stack.peek ()!=']') return false;
        }
        return stack.empty ();
    }
}





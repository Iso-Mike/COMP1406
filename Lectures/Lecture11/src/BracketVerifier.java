import java.util.*;

public class BracketVerifier{
    public static boolean verifyBrackets(String brackets){
        //We are given an entire string, but there are really only
        //6 characters we need to handle: (, [, {, }, ], )
        HashMap<Character, Character> matches = new HashMap<Character, Character>();
        matches.put(']', '[');
        matches.put(')', '(');
        matches.put('}', '{');

        Stack<Character> memory = new Stack<Character>();
        for(char c: brackets.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                memory.push(c);
            }else if(c == ')' || c == ']' || c == '}') {
                if(memory.isEmpty()){
                    return false;
                }

                Character mostRecent = memory.pop();
                if(matches.get(c) != mostRecent){
                    return false;
                }
            }
        }

        return memory.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(verifyBrackets("")); //should be true
        System.out.println(verifyBrackets("()")); //should be true
        System.out.println(verifyBrackets(")(")); //should be false
        System.out.println(verifyBrackets("([{}({})])")); //should be true
        System.out.println(verifyBrackets("((({{{[[[]]]}})))")); //should be false

        //We could read an entire file and verify the brackets match
        //We could give an error and say 'expecting a bracket at line ___'
    }
}
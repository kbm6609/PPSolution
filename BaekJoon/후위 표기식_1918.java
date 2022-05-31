package test;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> st =new Stack<>();
        String str =sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch ==')'){
                while (st.peek() !='(') {
                    bw.write(st.pop());
                }
                st.pop();
            }else if(ch =='('){
                st.add(ch);
            }
            else if (isOperation(ch)) {
                while (!st.isEmpty()) {
                    if (rank(ch) <= rank(st.peek())) {
                        bw.write(st.pop());
                    } else {
                        break;
                    }
                }
                st.add(ch);
            } else {
                bw.write(ch);
            }
        }
        while (!st.isEmpty()) {
            bw.write(st.pop());
        }
        bw.flush();
        bw.close();
    }
    static boolean isOperation(char ch) {
        if (ch >= 'A' && ch <= 'Z' ) {
            return false;
        }else{
            return true;
        }
    }

    static int rank(char ch) {
        switch (ch) {
            case '+': case'-':
                return  1;
            case '*': case '/':
                return 2;
        }
        return 0;
    }
}

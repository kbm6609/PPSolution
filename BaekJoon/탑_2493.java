package test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        Stack<top> st =new Stack<>();
        String[] str =br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            top t = new top(Integer.parseInt(str[i-1]), i);
            int index= 0;

            while (!st.isEmpty()) {
                if (st.peek().h >= t.h) {
                    index =st.peek().index;
                    break;
                }else{
                    st.pop();
                }
            }
            st.add(t);
            System.out.print(index+" ");
        }
    }
}
class top {
    int h,index;
    public top(int h,int index) {
        this.h = h;
        this.index =index;
    }

}

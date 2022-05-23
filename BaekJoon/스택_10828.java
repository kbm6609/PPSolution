package test;

import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N =Integer.parseInt(br.readLine());
        String[] str;
        Stack<Integer> st =new Stack<>();
        for (int i = 0; i < N; i++) {
            str =br.readLine().split(" ");
            if(str[0].equals("push")){
                st.add(Integer.parseInt(str[1]));
            }else if(str[0].equals("pop")){
                bw.write((st.size() == 0 ? -1:st.pop())+"\n");
            }else if(str[0].equals("size")){
                bw.write(st.size()+"\n");
            } else if (str[0].equals("empty")) {
                bw.write((st.isEmpty() ? 1:0)+"\n");
            }else if(str[0].equals("top")){
                bw.write((st.size() == 0 ? -1:st.peek())+"\n");
            }
        }
        bw.flush();
        bw.close();

    }
}

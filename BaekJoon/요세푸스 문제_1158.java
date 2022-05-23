package test;

import java.util.*;
class Main{
    public static void main(String[] args) {
        ArrayList<Integer> al =new ArrayList<>();
        int N,K;
        Scanner sc =new Scanner(System.in);
        N =sc.nextInt();
        K=sc.nextInt();
        for (int i = 0; i < N; i++) {
            al.add(i+1);
        }
        int index =K-1;
        StringBuilder sb=new StringBuilder();
        sb.append("<");
        sb.append(al.remove(index % N));
        while (al.size() != 0) {
            N--;
            index= (index-1+K)%N;
            sb.append(", " + al.remove(index % N));
        }
        sb.append(">");
        System.out.println(sb);
    }
}

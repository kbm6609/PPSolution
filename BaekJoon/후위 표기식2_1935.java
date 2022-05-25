package test;
import java.util.Scanner;
import java.util.Stack;


class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str =new String();
        int n = sc.nextInt();
        sc.nextLine();
        str = sc.nextLine();
        int[] arrnum = new int[n];

        for(int i=0;i<n;i++){
            arrnum[i] = sc.nextInt();
        }
        double result = run(str,n,arrnum);
        System.out.printf("%.2f",result);

    }
    static double run(String str, int n,int[] arrnum){
        Stack<Double> st =new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A' &&str.charAt(i)<='Z'){
                st.push((double)arrnum[str.charAt(i) - 'A']);
            }else{
                st.push(calcul(st.pop(),st.pop(),str.charAt(i)));
            }
        }
        return st.pop();
    }
    static double  calcul(double b,double a,char op){
        if(op =='+') return a + b;
        else if(op == '-') return a - b;
        else if(op == '*') return a * b;
        else return a / b;
    }

}

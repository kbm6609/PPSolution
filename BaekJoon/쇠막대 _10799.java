package test;
import java.util.Scanner;


 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();

        int result  =run(str);

        System.out.print(result);

    }
    static int run(String str){
        int sum = 0;
        int c=0;
        boolean check =false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                c++;
                check =true;
            }else{
                c--;
                if(check){
                    sum += c;
                    check = false;
                }else{
                    sum++;
                }

            }
        }

        return sum;
    }
}


package test;
import java.util.Scanner;
import java.util.Stack;


class Main {
    public static void main(String[] args) {
        Stack<Character> cst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        char[] arr =new char[2];
        int index;
        char c;
        int num;
        boolean check  =false;
        arr[0]= '(';
        arr[1]= '[';

        Scanner sc = new Scanner(System.in);

        String str =sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            index=-1;
            if(c=='(' || c=='['){
                cst.add(c);
            } else if (c == ')') {
                index =0;
            } else if (c == ']') {
                index =1;
            }else{
                check =true;
            }
            if(index !=-1) {
                num = 0;
                check =true;
                while (!cst.isEmpty()) {
                    char ch = cst.pop();
                    if (ch =='n') {
                        num += ist.pop();
                    }else if(ch == arr[index]){
                        cst.add('n');
                        ist.add((num == 0 ? 1 : num) * (index + 2));
                        check = false;
                        break;
                    }else{
                        break;
                    }
                }
            }
            if(check){
                break;
            }
        }
        if(check || cst.size() !=ist.size()){
            System.out.println(0);
        }else{
            num=0;
            while (!ist.isEmpty()) {
                num+=ist.pop();
            }
            System.out.println(num);
        }


    }
    /**
     *   스택 한개로 해결 하는 방법
     *   스택 없이 해결 하는 방법도 존재.
     */
   /*public static void main(String[] args) {
       Stack<Character> cst = new Stack<>();
       int point =1;
       int sum=0;
        char c;
        char pre='x';
        boolean check  =false;
        Scanner sc = new Scanner(System.in);
        char[] arr= {'(','['};
        int index;
        String str =sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            index= -1;
            if(c=='('){
                cst.add(c);
                point *=2;
            } else if (c == '[') {
                cst.add(c);
                point *=3;
            } else if (c == ')') {
                index=0;
            } else if (c == ']') {
               index=1;
            } else {
                check = true;
            }
            if(index !=-1) {
                if (cst.isEmpty() || cst.pop() != arr[index]) {
                    check = true;
                    break;
                }
                if (pre == arr[index]) {
                    sum += point;
                }
                point /= index+2;
            }
            if(check){
                break;
            }
            pre =c;
        }
        if(check || !cst.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(sum);
        }


    }*/

}


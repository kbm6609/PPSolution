package test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

class insertpoint{
    int f,b;

    insertpoint(int f) {
        this.f =f;
    }
}
class Main {
    static ArrayList<insertpoint> arr = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<StringBuilder> sbs=new ArrayList<>();
    static Set<String> set =new HashSet<>();
    static PriorityQueue<String> pq =new PriorityQueue<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<insertpoint> st =new Stack<>();
        //문자열 나눳을때의 인덱스
        int findex = 0;
        char c;
        boolean check= true;
        for (int i = 0; i < str.length(); i++) {
            c=str.charAt(i);
            if (c == '(') {
                check= true;
                st.add(new insertpoint(findex));
            } else if (c == ')') {
                check= true;
                insertpoint pop = st.pop();
                pop.b = findex-1;
                arr.add(pop);

            } else {
                if(check){
                    check = false;
                    findex++;
                }
            }
        }
        String[] sp =str.replace(" ","").split("[(]|[)]");

        for (int i = 0; i < sp.length; i++) {
            if(!sp[i].equals("")) {
                sbs.add(new StringBuilder(sp[i]));
            }
        }
        run(0,0);
        String[] strings = set.toArray(new String[0]);
        Arrays.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

    }

    static void run(int index,int count)  {
        if (index == arr.size()) {
            if(count !=arr.size()) {
                StringBuilder tmp = new StringBuilder();
                for (StringBuilder i : sbs) {
                    tmp.append(i);
                }
                set.add(tmp.toString());
            }
            return;
        }
        run(index + 1, count);


        insertpoint insertpoint = arr.get(index);
        sbs.get(insertpoint.f).insert(0,"(");
        sbs.get(insertpoint.b).append(")");
        run(index + 1, count + 1);
        sbs.get(insertpoint.f).delete(0,1);
        sbs.get(insertpoint.b).delete(sbs.get(insertpoint.b).length()-1,sbs.get(insertpoint.b).length());
    }
}
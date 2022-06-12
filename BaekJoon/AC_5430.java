package test;

/**
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 */
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        String str;
        String[] arr;
        int num;
        int s, e;
        boolean isfront;

        l1 : for (int i = 0; i < count; i++) {
            str =br.readLine();
            num =Integer.parseInt(br.readLine());
            arr =br.readLine().replaceAll("[\\[|\\]]","").split(",");
            s=0;
            e = arr.length - 1;
            if(arr[0].equals("")) e--;
            isfront =true;
            for(Character ch : str.toCharArray()){
                if(ch =='R'){
                    isfront =!isfront;
                }else if(ch =='D'){
                    if(s>e){
                        bw.write("error\n");
                        continue l1;
                    }
                    if(isfront){
                        s++;
                    }
                    else{
                        e--;
                    }
                }
            }
            bw.write("[");
            if(isfront) {
                for (int k = s; k <= e; k++) {
                    if(k!=s){
                        bw.write(",");
                    }
                    bw.write(arr[k]);
                }
                bw.write("]\n");
            }else{
                for (int k = e; k >= s; k--) {
                    if(k!=e){
                        bw.write(",");
                    }
                    bw.write(arr[k]);
                }
                bw.write("]\n");
            }

        }
        bw.flush();
        bw.close();
    }
}

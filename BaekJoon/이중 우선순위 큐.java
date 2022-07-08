package test;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
//        solution1(N,str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);

//        startTime = System.currentTimeMillis();
        solution();
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> hs =new HashMap<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            int inputNum =Integer.parseInt(br.readLine());
            for (int j = 0; j < inputNum; j++) {
                String[] str = br.readLine().split(" ");
                char ch = str[0].charAt(0);
                int num = Integer.parseInt(str[1]);
                if (ch == 'I') {
                    minPq.add(num);
                    maxPq.add(num);
                    hs.put(num, hs.getOrDefault(num, 0) + 1);
                } else if (ch == 'D') {
                    if(num ==-1){
                        outputPq(minPq,hs);
                    }else {
                        outputPq(maxPq,hs);
                    }
                }

            }
            Integer maxNum = outputPq(maxPq, hs);
            Integer minNum = outputPq(minPq, hs);
            if(maxNum == null) {
                bw.write("EMPTY");
            }
            else if (minNum == null) {
                bw.write(maxNum + " " + maxNum);
            }
            else{
                bw.write(maxNum + " " + minNum);
            }


            bw.write("\n");
//            for (Integer k : hs.keySet()) {
//                bw.write(k+" "+hs.get(k)+"\n");
//            }
//            bw.write("\n");

            maxPq.clear();
            minPq.clear();
            hs.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static Integer outputPq(PriorityQueue<Integer> pq ,HashMap<Integer,Integer> hs){
        while(!pq.isEmpty() && hs.get(pq.peek()) ==0){
            pq.poll();
        }
        if(!pq.isEmpty()){
            Integer num =pq.poll();
            hs.put(num, hs.get(num) - 1);
            return num;
        }
        return null;
    }
}

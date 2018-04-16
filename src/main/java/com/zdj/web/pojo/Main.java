package com.zdj.web.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        List<String[]> list=new ArrayList<String[]>(){
            {
                for(int i=0;i<k;i++) {
                    add(scanner.nextLine().split(" "));
                }
            }
        };
        for(int i=0;i<k;i++){
            String[] split = list.get(i);
            long n=Long.parseLong(split[0]);
            List<BigInteger> bigIntegers=new ArrayList<BigInteger>(split.length-1){
                {
                    for (int j=0;j<n;j++){
                        add(new BigInteger(split[j+1]));
                    }
                }
            };
            BigInteger result=new BigInteger("1");
            boolean ok=false;
            do {
                for (int j = 0; j < bigIntegers.size(); j++) {
                        BigInteger bigInteger =  bigIntegers.get(j);
                        if(bigIntegers.contains(bigInteger.add(result))||bigIntegers.contains(bigInteger.subtract(result))){
                            ok=true;
                            break;
                        }
                }
                if (ok){
                    break;
                }
                result=result.add(new BigInteger("1"));
            }while (true);
            System.out.println(result.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String active=scanner.nextLine();
        long s=Integer.parseInt(scanner.nextLine());
        List<Point> map=new ArrayList<Point>();
        List<Point> start=new ArrayList<Point>();
        for (long i=0;i<s;i++){
            String[] split = scanner.nextLine().split(" ");
            map.add(new Point(Long.parseLong(),Long.parseLong(split[0]split[1])));
            start.add(new Point(Long.parseLong(split[3]),Long.parseLong(split[2])));
        }
        //uuurrdddddl
        for (int i=0;i<s;i++){
            long step=0;
            Point thisMap = map.get(i);
            Point thisStart = start.get(i);
            for (int j=0;j<active.length();j++){
                char c = active.charAt(j);
                step++;
                switch (c){
                    case 'u':{
                        thisStart.setY(thisStart.getY()-1);
                        break;
                    }
                    case 'r':{
                        thisStart.setX(thisStart.getX()+1);
                        break;
                    }
                    case 'd':{
                        thisStart.setY(thisStart.getY()+1);
                        break;
                    }
                    case 'l':{
                        thisStart.setX(thisStart.getX()-1);
                        break;
                    }
                }
                if(thisStart.getX()<=0||thisStart.getY()<=0||thisStart.getX()>thisMap.getX()||thisStart.getY()>thisMap.getY()){
                    System.out.println(step);
                    break;
                }
                if (j==active.length()-1){
                    System.out.println(j+1);
                }
            }
        }
    }
    static class Point{
        private long x;
        private long y;

        public Point() {
        }

        public Point(long x, long y) {

            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public void setX(long x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(long y) {
            this.y = y;
        }
    }
}


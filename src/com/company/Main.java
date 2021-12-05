package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static void Decrease(String number,List<Integer> weights){
        for(int i =0;i<15;i++){
            if(Integer.parseInt(Character.toString(number.charAt(i)))==1){
                weights.set(i,weights.get(i)-1);
            }
        }
    }
    static void Increase(String number,List<Integer> weights){
        for(int i=0;i<15;i++){
            if(Integer.parseInt(Character.toString(number.charAt(i)))==1){
                weights.set(i,weights.get(i)+1);
            }
        }
    }
    static Boolean Proceed(String number,List<Integer> weights,int bias){
        int net = 0;
        for(int i = 0;i<15;i++){
            net+=Integer.parseInt(Character.toString(number.charAt(i)))*weights.get(i);
        }
        if(net>=bias){
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        int bias=9;
        List<String> numbers= new ArrayList<>();
        numbers.add(
                "111" +
                "101" +
                "101" +
                "101" +
                "111");
        numbers.add(
                "001" +
                "001" +
                "001" +
                "001" +
                "001");
        numbers.add(
                "111" +
                "001" +
                "111" +
                "100" +
                "111");
        numbers.add(
                "111" +
                "001" +
                "111" +
                "001" +
                "111");
        numbers.add(
                "101" +
                "101" +
                "111" +
                "001" +
                "001");
        numbers.add(
                "111" +
                "100" +
                "111" +
                "001" +
                "111");
        numbers.add(
                "111" +
                "100" +
                "111" +
                "101" +
                "111");
        numbers.add(
                "111" +
                "001" +
                "001" +
                "001" +
                "001");
        numbers.add(
                "111" +
                "101" +
                "111" +
                "101" +
                "111");
        numbers.add(
                "111" +
                "101" +
                "111" +
                "001" +
                "111");
        List<String> imagesOfNumbers = new ArrayList<>();
        imagesOfNumbers.add(
                "011" +
                "001" +
                "111" +
                "100" +
                "110");
        imagesOfNumbers.add(
                "111" +
                "000" +
                "111" +
                "000" +
                "111");
        imagesOfNumbers.add(
                "111" +
                "001" +
                "111" +
                "000" +
                "111");
        imagesOfNumbers.add(
                "111" +
                "000" +
                "101" +
                "100" +
                "111");
        imagesOfNumbers.add(
                "111" +
                "101" +
                "111" +
                "100" +
                "111");

        List<Integer> weights=new ArrayList<>();
        for(int i =0;i<15;i++){
            weights.add(0);
        }
        
        Random random = new Random();
        for(int i =0;i<10000;i++){
            int rand=random.nextInt(10);
            if(rand==2){
                if(!Proceed(numbers.get(rand),weights,bias)){
                    Increase(numbers.get(rand),weights);
                }
            }
            else{
                if(Proceed(numbers.get(rand),weights,bias)){
                    Decrease(numbers.get(rand),weights);
                }
            }
        }
        System.out.println(weights);
        System.out.println("0 это 2 = "+Proceed(numbers.get(0),weights,bias));
        System.out.println("1 это 2 = "+Proceed(numbers.get(1),weights,bias));
        System.out.println("2 это 2 = "+Proceed(numbers.get(2),weights,bias));
        System.out.println("3 это 2 = "+Proceed(numbers.get(3),weights,bias));
        System.out.println("4 это 2 = "+Proceed(numbers.get(4),weights,bias));
        System.out.println("5 это 2 = "+Proceed(numbers.get(5),weights,bias));
        System.out.println("6 это 2 = "+Proceed(numbers.get(6),weights,bias));
        System.out.println("7 это 2 = "+Proceed(numbers.get(7),weights,bias));
        System.out.println("8 это 2 = "+Proceed(numbers.get(8),weights,bias));
        System.out.println("9 это 2 = "+Proceed(numbers.get(9),weights,bias));

        System.out.println("Узнал 2? "+Proceed(numbers.get(2),weights,bias));
        System.out.println("Узнал 1 образ 2? "+Proceed(imagesOfNumbers.get(0),weights,bias));
        System.out.println("Узнал 2 образ 2? "+Proceed(imagesOfNumbers.get(1),weights,bias));
        System.out.println("Узнал 3 образ 2? "+Proceed(imagesOfNumbers.get(2),weights,bias));
        System.out.println("Узнал 4 образ 2? "+Proceed(imagesOfNumbers.get(3),weights,bias));
        System.out.println("Узнал 5 образ 2? "+Proceed(imagesOfNumbers.get(4),weights,bias));
    }
}
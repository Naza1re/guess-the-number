package com.example.guessthenumber.Logic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class NumberCalculation {

    public static int containsNumbers(ArrayList a, ArrayList b){
        int count = 0;

        for(int i = 0;i<a.size();i++){
            if(b.contains(a.get(i))){
                count++;
            }
        }

        return count;
    }
    public static int generateUniqueFourDigitNumber() {
        ArrayList<Integer> digits = new ArrayList();
        for (int i = 1; i < 10; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);


        int number = 0;

        for (int i = 0; i < 4; i++) {
            number *= 10;
            number += digits.get(i);
        }

        return number;
    }
    public static int correctPosition(ArrayList a,ArrayList b){
        int count = 0;
        for(int i = 0;i<a.size();i++){
            if(a.get(i)==b.get(i)){
                count++;
            }
        }

        return count;
    }
    public static void writeToFile(ArrayList<Integer> a, ArrayList<Integer> b) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt", true))) {
            writer.write(a + "             " + containsNumbers(a, b) + "   " + correctPosition(a, b));
            writer.newLine(); // Добавление символа новой строки
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList returnCollection(int a){
        ArrayList list = new ArrayList();

        int x4 = a/1000;
        int x3 = a%1000/100;
        int x2 = a%100/10;
        int x1 = a%10;

        Collections.addAll(list,x4,x3,x2,x1);

        return list;

    }
    public static void clearFile() {
        try {
            FileWriter fileWriter = new FileWriter("numbers.txt", false);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Ошибка при очистке файла: " + ex.getMessage());
        }
    }




}
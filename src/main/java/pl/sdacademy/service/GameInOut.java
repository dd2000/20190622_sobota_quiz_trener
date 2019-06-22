package pl.sdacademy.service;

import java.util.Scanner;

public class GameInOut {
    Scanner scanner = new Scanner(System.in);

    public void printLine(String text) {
        System.out.println(text);
    }

    public int getInt() {
        return getInt(0);
    }

    public int getInt(int max) {
        boolean badNumber;
        int i = 0;
        Scanner sc = scanner;
        do{
            try{
                i = sc.nextInt();
                badNumber = i > max;
            }
            catch(Exception e){
                System.out.println("Liczba jest zbyt duża");
                sc.next();
                badNumber = true;
            }
        }while(badNumber);
        return i;
    }

}

package org.dafydd.c130.exercises;

import java.util.Scanner;

public class HealthyHearts {


    public static void main(String[] args) {
        int age, maximumHR;
        long lowRange, highRange;

        Scanner myScanner = new Scanner(System.in);

        System.out.print("What is your age? ");
        age = myScanner.nextInt();
        maximumHR = 220 - age;
        lowRange = Math.round(maximumHR * 0.5);
        highRange = Math.round(maximumHR * 0.85);


        System.out.println("Your maximum heart rate should be " + maximumHR + " beats per minute");
        System.out.println("Your target HR Zone is " + lowRange + " - " + highRange + " beats per minute");

    }
}

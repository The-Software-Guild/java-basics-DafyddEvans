package org.dafydd.c130.exercises;

import java.util.Scanner;

public class HealthyHearts {


    public static void main(String[] args) {
        int age, maximumHR;
        age = 0;
        long lowRange, highRange;
        boolean isValid = false;

        Scanner myScanner = new Scanner(System.in);

        while(!isValid) {
            System.out.print("How old are you?: ");

            try {
                age = Integer.parseInt(myScanner.nextLine());
                isValid = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input type, please use numbers only.\n");
            }

        }

        maximumHR = 220 - age;
        lowRange = Math.round(maximumHR * 0.5);
        highRange = Math.round(maximumHR * 0.85);


        System.out.println("Your maximum heart rate should be " + maximumHR + " beats per minute");
        System.out.println("Your target HR Zone is " + lowRange + " - " + highRange + " beats per minute");

    }
}

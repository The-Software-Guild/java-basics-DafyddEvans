package org.dafydd.c130.exercises;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args) {
        String dogName;
        String[] dogBreed = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
        int randomNumber, totalGenetics;
        totalGenetics = 100;

        Scanner myScanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("What is your dog's name? ");
        dogName = myScanner.nextLine();

        System.out.println("Well then, I have this highly reliable report on " +
                dogName + "'s prestigious background right here.\n");

        System.out.println(dogName + " is:\n");

        for(int i = 0; i < 4; i++) {
            /*
                randomNumber can be between 1-96 for the first loop, leaving 1 for each other breed if it is 96
                each subsequent roll allows for the following rolls to be at least 1
             */
            randomNumber = rand.nextInt(totalGenetics - 4 + i) + 1;
            totalGenetics -= randomNumber;
            System.out.println(randomNumber + "% " + dogBreed[i]);
        }
        System.out.println(totalGenetics + "% " + dogBreed[4]);


        System.out.println("\nWow, that's QUITE the dog!");
    }
}

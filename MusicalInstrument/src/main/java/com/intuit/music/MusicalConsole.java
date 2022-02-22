package com.intuit.music;

import java.util.Scanner;

public class MusicalConsole {
    public static void main(String[] args) {
        // Using Scanner for Getting Input from User
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the musical play to check whether its good or not : ");
        String musicalPlayString = input.nextLine();
        System.out.println("You entered musical play : " + musicalPlayString);
        // closing scanner
        input.close();
        new MusicalInstrument(new MusicalPlay()).getMinRemovals(musicalPlayString);
    }
}

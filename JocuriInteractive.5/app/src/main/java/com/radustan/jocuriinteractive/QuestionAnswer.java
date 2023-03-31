package com.radustan.jocuriinteractive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class QuestionAnswer {

    public static Random random = new Random();
    public static int select = random.nextInt(5);

    public static int reloadintre(){
        int selectince = random.nextInt(4);
        return selectince;
    }

    public static String[] forme ={
            "dreptunghi",
            "oval",
            "cerc",
            "triunghi",
            "patrat",
            "romb",
            "trapez",
            "pentagon",
            "hexagon"
    };

    public static String[][] incepintre = {
            {"Fă click pe ",".","1"},
            {"Apasă pe imaginea cu un ", ".","2"},
            {"Apasă cu degetul pe ", ".","3"},
            {"Atinge imaginea cu un ", ".","4"}
    };


    private static Set<Integer> usedNumbers = new HashSet<>();



    public static int getRandomNumber2() {
        int randomNum = random.nextInt(4);
        if (usedNumbers.size() == 4) {
            usedNumbers.clear();
        }
        while (usedNumbers.contains(randomNum)) {
            randomNum = random.nextInt(4);
        }
        usedNumbers.add(randomNum);
        return randomNum;
    }

    public static int[] generateRandomSet() {
        int[] set = new int[4];
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Generate four unique random numbers between 0 and 8
        while (uniqueNumbers.size() < 4) {
            int randomNumber = (int) (Math.random() * 9);
            uniqueNumbers.add(randomNumber);
        }

        // Copy the unique numbers into the set array
        int i = 0;
        for (Integer number : uniqueNumbers) {
            set[i++] = number;
        }

        return set;
    }
    private static int[] NUMBER_SET = generateRandomSet();  // Store the set of numbers generated for subsequent calls
    private static int currentNumberIndex = 0;  // Keep track of the current index in the set array
    public static int generateRandomNumber() {
        if (currentNumberIndex >= NUMBER_SET.length) {
            NUMBER_SET = generateRandomSet();  // If we have used up all the numbers, generate a new set
            currentNumberIndex = 0;  // Reset the index
        }

        return NUMBER_SET[currentNumberIndex++];  // Return the next number in the set
    }

    public static void restartRandomNumberGenerator() {
        usedNumbers.clear();
    }

    public static String[][] choices = {
            {forme[generateRandomNumber()], forme[generateRandomNumber()], forme[generateRandomNumber()], forme[generateRandomNumber()]},
            {forme[generateRandomNumber()],forme[generateRandomNumber()],forme[generateRandomNumber()], forme[generateRandomNumber()]},
            {forme[generateRandomNumber()],forme[generateRandomNumber()],forme[generateRandomNumber()],forme[generateRandomNumber()]},
            {forme[generateRandomNumber()],forme[generateRandomNumber()],forme[generateRandomNumber()],forme[generateRandomNumber()]}
    };



    public static String[] correctAnswers = {
            choices[0][getRandomNumber2()],
            choices[1][getRandomNumber2()],
            choices[2][getRandomNumber2()],
            choices[3][getRandomNumber2()]
    };

    public static String[] question ={
            incepintre[reloadintre()][0] + correctAnswers[0] + ".",
            incepintre[reloadintre()][0] + correctAnswers[1] + ".",
            incepintre[reloadintre()][0] + correctAnswers[2] + ".",
            incepintre[reloadintre()][0] + correctAnswers[3] + "."
    };

}



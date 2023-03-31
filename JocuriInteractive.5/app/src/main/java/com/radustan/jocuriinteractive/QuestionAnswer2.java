package com.radustan.jocuriinteractive;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class QuestionAnswer2 {

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
            "pătrat",
            "romb",
            "trapez",
            "pentagon",
            "hexagon"
    };

    public static String[][] incepintre = {
            {"Fă click pe ","."},
            {"Apasă pe imaginea cu un ", "."},
            {"Apasă cu degetul pe ", "."},
            {"Atinge imaginea cu un ", "."}
    };



    /*static int rand(int j, int k){
        int nr = random.nextInt(3);
        int nr2 = random.nextInt(3)+3;
        int nr3 = random.nextInt(3)+6;

        while(nr == select + k || nr2 == select + k || nr3 == select + k || nr == nr2 || nr == nr3 || nr2 == nr3)
        {
            if(nr == select + k)
                nr = random.nextInt(3);
            if(nr2 == select + k)
                nr2 = random.nextInt(3) + 3;
            if(nr3 == select + k)
                nr3 = random.nextInt(3) + 6;
        }

        String[] treinum={
                String.valueOf(nr),
                String.valueOf(nr2),
                String.valueOf(nr3)
        };
        return Integer.parseInt(treinum[j]);
    }*/


    private static Set<Integer> usedNumbers = new HashSet<>();

/*    public static int getRandomNumber() {
        int randomNum = random.nextInt(9);
        while (usedNumbers.contains(randomNum)) {
            randomNum = random.nextInt(9);
        }
        usedNumbers.add(randomNum);
        return randomNum;
    }*/
    public static int getRandomNumber() {
        int randomNum = random.nextInt(9);
        if (usedNumbers.size() == 9) {
            usedNumbers.clear();
        }
        while (usedNumbers.contains(randomNum)) {
            randomNum = random.nextInt(9);
        }
        usedNumbers.add(randomNum);
        return randomNum;
    }

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

    public static void restartRandomNumberGenerator() {
        usedNumbers.clear();
    }

    public static String[][] choices = {
            {forme[getRandomNumber()], forme[getRandomNumber()], forme[getRandomNumber()], forme[getRandomNumber()]},
            {forme[getRandomNumber()],forme[getRandomNumber()],forme[getRandomNumber()], forme[getRandomNumber()]},
            {forme[getRandomNumber()],forme[getRandomNumber()],forme[getRandomNumber()],forme[getRandomNumber()]},
            {forme[getRandomNumber()],forme[select+1],forme[select+2],forme[select]}
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


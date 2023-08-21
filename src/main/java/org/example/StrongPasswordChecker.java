package org.example;

import java.util.ArrayList;
import java.util.List;

public class StrongPasswordChecker {
    static int lengthSteps=0;
    static int missingCharacterStep = 0;
    static int repetitionSteps = 0;
    static int steps = 0;
    public int strongPasswordChecker(String password) {

        int hasStrongLength = hasStrongLength(password);
        int checkCharacters = checkCharacters(password);
        int repetitionChecker = checkRepitition(password);
        if(hasStrongLength==1 && checkCharacters==1 && repetitionChecker==1){
            System.out.println("Number of steps : "+steps);
            return 1;
        }
        if (lengthSteps >= missingCharacterStep && lengthSteps >= repetitionChecker) {
            steps = lengthSteps;
        }
        if(missingCharacterStep>=lengthSteps && missingCharacterStep>=repetitionChecker){
            steps = missingCharacterStep;
        }
        if(repetitionChecker >= lengthSteps && repetitionChecker >= missingCharacterStep){
            steps = repetitionChecker;
        }
        System.out.println("Number of steps : "+steps);
       return 0;

    }

    private int checkRepitition(String password) {
        int isStrong = 1;
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                isStrong = 0;
                break;
            }
        }
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                repetitionSteps++;
            }
        }
        return isStrong;
    }

    private int hasStrongLength(String password) {
        int isStrong =0 ;
        if(password.length()>=6 && password.length()<=20)
        {
            isStrong = 1;
        }
        if(isStrong==0 ){
            int passwordLength = password.length();
            if(passwordLength< 6){
                lengthSteps = 6-passwordLength;
            }
            else if(passwordLength>20){
                lengthSteps = passwordLength-20;
            }
        }
        return isStrong;
    }

    private int checkCharacters(String password) {
        int isStrong = 0;
        int hasSmallLetter = 0;
        int hasCapitalLetter = 0;
        int hasDigits = 0;
        List<Character> allCharactersLower = new ArrayList<>();
        List<Character> allCharactersUpper = new ArrayList<>();
        List<Character> allDigits = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            allCharactersLower.add(ch);
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            allCharactersUpper.add(ch);
        }

        for (char ch = '0'; ch <= '9'; ch++) {
            allDigits.add(ch);
        }
        for (int i = 0; i<password.length();i++){
            if( allCharactersLower.contains(password.charAt(i)));
            {
                isStrong = 1;
                hasSmallLetter = 1;
                break;
            }
        }
        for (int i = 0; i<password.length();i++){
            if( allCharactersUpper.contains(password.charAt(i)));
            {
                isStrong = 1;
                hasCapitalLetter =1 ;
                break;
            }
        }
        for (int i = 0; i<password.length();i++){
            if( allDigits.contains(password.charAt(i)));
            {
                isStrong = 1;
                hasDigits = 1;
                break;
            }
        }
        if(hasDigits== 0){
            missingCharacterStep++;
        }
        if(hasCapitalLetter==0){
            missingCharacterStep++;
        }
        if(hasSmallLetter==0){
            missingCharacterStep++;
        }
        return isStrong;
    }

    public static void main(String [] args){
        StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
        String password = "aAaaaa";
        int isStrong = strongPasswordChecker.strongPasswordChecker(password);
        System.out.println("Password strength : "+isStrong);
    }
}

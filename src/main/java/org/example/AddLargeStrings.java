package org.example;

public class AddLargeStrings {

    public String addLargeStrings(String str1, String str2){

        if(str1.length() < str2.length()){
            String temp = str1;
            str1= str2;
            str2 = temp;
        }
        if(str1.length()==0){
            return str2;
        }
        if(str2.length()==0){
            return str1;
        }
        int n1 = str1.length();
        int n2= str2.length();
        String finalString = "";
        int carry= 0;

        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();


        for( int i = 0 ; i < n2; i++){
            int sum = str1.charAt(i) - '0' + str2.charAt(i) - '0' + carry;
            if (sum >=10){
                carry = sum %10;
                sum = sum /10;
            }
            finalString = finalString+sum;
        }
        for(int i = n2 ; i< n1; i++){
            int sum = str1.charAt(i) - '0' + carry;
            if (sum >=10){
                carry = sum %10;
                sum = sum /10;
            }
            finalString = finalString+sum;
        }
        return new StringBuffer(finalString).reverse().toString();
    }

    public static void main (String [] args){
        AddLargeStrings add = new AddLargeStrings();
        System.out.println(add.addLargeStrings("123456","7654321"));
    }
}

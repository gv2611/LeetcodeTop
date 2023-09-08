package org.example.StringsArrays;

import java.util.ArrayList;
import java.util.List;

public class TextJustifcation {
    public List<String> fullJustify(String[] words, int maxWidth) {
        String entries = "";
        List<String> finalList = new ArrayList<>();
        int width = 0;
        int word = 0;
        int entry = 0;

        for(int i = 0 ; i<words.length; i++){
            width += words[i].length();
           // word++;
            if(width<=maxWidth){
                entries+=words[i]+" ";
                width += 1;
            }
            else {
                entries = entries.trim();
                finalList.add(entries);
               // finalList.get(entry).trim();
                entry++;
                entries="";
            //    word = 0;
                width = words[i].length();
                if(width<=maxWidth){
                    entries+=words[i]+" ";
                    width +=1;
                }
            }
        }
        entries=entries.trim();
        finalList.add(entries);

        for(int i = 0 ; i<finalList.size();i++){
            String newString ="";

            String str = finalList.get(i);
            int originalStringLen = str.length();
            int remainingLen = maxWidth-originalStringLen;
            String[] str1 = str.split(" ");
            int space = str1.length-1;
            int spaceToBeAdded=0;
            if (space>0){
             spaceToBeAdded = remainingLen/space;}
            for(int j = 0 ; j<str1.length-1 ; j++){
                 newString = newString +  str1[j];
                 if(str1[j] == " "){
                     for(int k = 0; k<spaceToBeAdded;k++){
                         newString+=" ";
                     }
                 }
            }
            finalList.add(newString);


        }
        return finalList;
    }

    public static void main(String [] args){
        TextJustifcation text = new TextJustifcation();
        String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
        String words2[] = {"What","must","be","acknowledgment","shall","be"};
        String words3[] = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(text.fullJustify(words2, 16));
    }
}

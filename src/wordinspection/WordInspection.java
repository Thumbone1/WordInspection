
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thumbone1
 */
public class WordInspection {
    private File file;
    private List<String> words;
    
    public WordInspection(File file) {
        this.file = file;
        this.words = makeWordsList();
    }
    
    public int wordCount() {
        return words.size();
    }
    
    public List<String> wordsContainingZ() {
        List<String> zWords = new ArrayList<String>();
        
        for (String s : words) {
            if (s.contains("z")) {
                zWords.add(s);
            }
        }
        
        return zWords;
    }
    
    public List<String> wordsEndingInL() {
        List<String> lWords = new ArrayList<String>();
        
        for (String s : words) {
            if (s.charAt(s.length()-1) == 'l') {
                lWords.add(s);
            }
        }
        
        return lWords;
    }
    
    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();
        
        for (String s : words) {
            if (isPalindrom(s)) {
                palindromes.add(s);
            }
        }
        
        return palindromes;        
    }
    
    public List<String> wordsWhichContainAllVowels() {
        List<String> vowelWords = new ArrayList<String>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y', 'ä', 'ö'};
        String vowelString = "";
        
        for (String s : words) {
            char[] sChars = s.toCharArray();
            for (char vChar : vowels) {
                for (char sChar : sChars) {
                    if (sChar == vChar) {
                        vowelString += vChar;
                    }
                }
            }
            /**
             * check each letter in the string s. if the letter is a vowel  
             * and that vowel has not been added to vowelsInWord then
             * add that letter to the string vowelsInWord. 
             * 
             * 
             */
        }
        
        return vowelWords;
    }
    
    private boolean isPalindrom(String s) {
        String reversed = "";
        
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        
        return reversed.equals(s);
    }
    
    private List<String> makeWordsList() {
        return new ArrayList<String>(Arrays.asList(readFile().split("\n")));
    }
    
    private String readFile() {
        try {
            Scanner reader = new Scanner(file);
            String s = "";
            
            while (reader.hasNextLine()) {
                s += reader.nextLine();
                s += "\n";
            }
            
            return s;
            
        } catch (FileNotFoundException e) {
            return "File not found! " + e.getMessage();
        }
        
        
    }

}

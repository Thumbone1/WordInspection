
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
        this.words = readFile();
        System.out.println("setup complete!");
    }
    
    public int wordCount() {
        System.out.println("wordCount()...");
        return words.size();
    }
    
    public List<String> wordsContainingZ() {
        System.out.println("wordsContainingZ()...");
        List<String> zWords = new ArrayList<String>();
        
        for (String s : words) {
            if (s.contains("z")) {
                zWords.add(s);
            }
        }
        
        return zWords;
    }
    
    public List<String> wordsEndingInL() {
        System.out.println("wordsEndingInL()...");
        List<String> lWords = new ArrayList<String>();
        
        for (String s : words) {
            if (s.endsWith("l")) {
                lWords.add(s);
                
            }
        }
        
        return lWords;
    }
    
    public List<String> palindromes() {
        System.out.println("palindromes()...");
        List<String> palindromes = new ArrayList<String>();
        
        for (String s : words) {
            if (isPalindrom(s)) {
                palindromes.add(s);
            }
        }
        
        return palindromes;        
    }
    
    
    public List<String> wordsWhichContainAllVowels() {
        System.out.println("wordsWhichContainAllVowels()...");
        List<String> vowelWords = new ArrayList<String>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y', 'ä', 'ö'};
        
        for (String s : words) {
            char[] sChars = s.toCharArray();
            String vowelString = "";
            for (char vChar : vowels) {
                for (char sChar : sChars) {
                    if (sChar == vChar) {
                        vowelString += vChar;  // adds chars to string in the order of aeiouyäö
                    }
                }
            }            
            if (stringContainsAllVowels(vowelString)) {
                vowelWords.add(s);
            }
        }
        
        return vowelWords;
    }
    
    private boolean stringContainsAllVowels(String s) {
        if (s.length() < 8 || s.equals("")) {
            return false;
        }
        
        String vowels = "aeiouyäö";
        String checkString = removeRepeatingLetters(s);
        
        return vowels.equals(checkString);
    }
    
    private String removeRepeatingLetters(String s) {
        
        String newString = "";
        char[] sChars = s.toCharArray();
        
        for (char sChar : sChars) {
            if (!newString.contains("" + sChar)) {
                newString += sChar;
            }
        }
        return newString;
    }
    
    private boolean isPalindrom(String s) {
        String reversed = "";
        
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        
        return reversed.equals(s);
    }
    
    private List<String> readFile() {
        List<String> wordList = new ArrayList<String>();
        try {
            System.out.println("reading file...");
            Scanner reader = new Scanner(file, "UTF-8");
            
            while (reader.hasNextLine()) {
                wordList.add(reader.nextLine());                
            }
            reader.close();
            return wordList;
            
        } catch (FileNotFoundException e) {
            return wordList;
        }
        
        
    }

}

package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection inspector = new WordInspection(file);
        System.out.println(inspector.wordCount());
        System.out.println(inspector.wordsContainingZ());
        System.out.println(inspector.wordsEndingInL());
        System.out.println(inspector.palindromes());
        System.out.println(inspector.wordsWhichContainAllVowels());

    }
}

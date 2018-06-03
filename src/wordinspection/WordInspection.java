

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
            if (s.contains("z") || s.contains("Z")) {
                zWords.add(s);
            }
        }
        return zWords;
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

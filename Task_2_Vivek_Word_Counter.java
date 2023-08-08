import java.io.*;
import java.util.*;

public class Task_2_Vivek_Word_Counter{
   public static void main(String[] args) {
// Initialize Scanner to read user input
    Scanner sc = new Scanner(System.in);
//Allows the user to choose the input type: either 'T' for text input or 'F' for file input.
    System.out.println("Enter 'T' for text input or 'F' for file input:");
    String inputType = sc.nextLine().trim();
    String inputText;

// Read the input text based on the user's choice
    if (inputType.equalsIgnoreCase("T")) {
       System.out.println("Enter your text:");
        inputText = sc.nextLine();} 
    else if (inputType.equalsIgnoreCase("F")) {
       System.out.println("Enter the file path:");
       String filePath = sc.nextLine();
// using try catch block for Exception Handling
       try {
          inputText = readFile(filePath);
        } catch (IOException e) {
          System.out.println("Error reading file: " + e.getMessage());
           return;
        }
        } else {
           System.out.println("Invalid input type. Program exiting.");
           return;
        }
// Close the Scanner after reading the input
         sc.close();
// Split the input text into words using regular expression
         String[] words = inputText.split("[\\s\\p{Punct}]+");
         int wordCount = 0;
 
 // Set of stop words to exclude from word count
          Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "or", "a", "an"));

 // Count the total number of words (excluding stop words)
          for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                    wordCount++;
                }
            }

            // Print the total number of words (excluding stop words)
            System.out.println("Total number of words: " + wordCount);
        }


        // Reads the content of a text file given its file path.

        private static String readFile(String filePath) throws IOException {
            StringBuilder content = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }

            return content.toString();
        }
    }
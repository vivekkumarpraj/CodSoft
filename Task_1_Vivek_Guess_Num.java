import java.util.Scanner;

public class Task_1_Vivek_Guess_Num{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int number, // To hold the random number
      guess, // To hold the number guessed by user
      tries = 0; // To hold number of tries
      int limit = 10; // To hold limit
      int left = 0; // to hold the left chances
      number = (int) (Math.random() * 100) + 1; // get random number between 1 and 100

      System.out.println("====================---------->Guess My Number Game<-----====================");
      // using for loop
      for (int i = 0; i < limit; i++) {
         System.out.println("Enter a guess between 1 and 100 : ");
         guess = sc.nextInt(); // taking user input

                // Using if else laddder (Block 1)
          if (guess > 100 || guess < 0) { // if guess is greater than 100 and less than 0 then its print invalid input
                    // try again
                    tries++;
                    left = limit - tries;
                    System.out.println("Invalid Input!, Try Again only " + " " + left + " guess left ");

                    // Block 2

                } else if (guess > number) { // if guess is greater than number then print too high
                    tries++;
                    left = limit - tries;
                    System.out.println("Too high! Try Again only" + " " + left + " guess left ");

                    // Block 3

                } else if (guess < number) { // if guess is less than number then print too low
                    tries++;
                    left = limit - tries;
                    System.out.println("Too low! Try Again only" + " " + left + " guess left ");

                    // Block 4

                } else {
                    tries++;
                    System.out.println("Correct! You got it in " + tries + " guesses!");
                    break;
                }
            }
            if (tries == limit) { // set the limit
                System.out.println("You cannot guess!, That number is -:" + " " + number);
            }

        }
    }
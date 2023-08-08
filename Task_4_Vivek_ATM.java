import java.util.Scanner;

public class Task_4_Vivek_ATM {
    //This inner class represents a BankAccount with a balance. It provides methods to deposit and withdraw funds.

        public static class BankAccount {
            public double balance;


            // Constructs a BankAccount object with the specified initial balance.

            public BankAccount(double initialBalance) {
                this.balance = initialBalance;
            }


            //  Gets the current balance of the bank account.

            public double getBalance() {
                return balance;
            }


            //  Deposits the specified amount into the bank account.

            public void deposit(double amount) {
                balance += amount;
            }


            //   Withdraws the specified amount from the bank account if sufficient balance is available.

            public boolean withdraw(double amount) {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                } else {
                    return false;
                }
            }
        }


        // This inner class represents an ATMMachine that interacts with a BankAccount to perform ATM operations.

        public static class ATMMachine {
            public BankAccount bankAccount;


            //Constructs an ATMMachine object associated with the specified BankAccount.

            public ATMMachine(BankAccount bankAccount) {
                this.bankAccount = bankAccount;
            }


            // Deposits the specified amount into the associated BankAccount.

            public void deposit(double amount) {
                bankAccount.deposit(amount);
            }


            //  Withdraws the specified amount from the associated BankAccount if sufficient balance is available.

            public boolean withdraw(double amount) {
                return bankAccount.withdraw(amount);
            }


            // Checks the current balance of the associated BankAccount.
            public double checkBalance() {
                return bankAccount.getBalance();
            }
        }

        public static void main(String[] args) {
            // Initialize Scanner to read user input
            Scanner scanner = new Scanner(System.in);

            // Create a BankAccount object with an initial balance of 1000
            BankAccount bankAccount = new BankAccount(1000);

            // Create an ATMMachine object associated with the BankAccount
            ATMMachine atmMachine = new ATMMachine(bankAccount);

            // Main loop to display the menu and process user's choices
            while (true) {
                displayMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        deposit(atmMachine, scanner);
                        break;
                    case 2:
                        withdraw(atmMachine, scanner);
                        break;
                    case 3:
                        checkBalance(atmMachine);
                        break;
                    case 4:
                        System.out.println("Exiting the ATM.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        // Displays the menu options for the ATM system.

        private static void displayMenu() {
            System.out.println("ATM Machine");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
        }


        // Allows the user to deposit funds into the ATM machine. It takes the ATMMachine and Scanner as parameters.

        private static void deposit(ATMMachine atmMachine, Scanner scanner) {
            System.out.print("Enter the deposit amount: ");
            double amount = scanner.nextDouble();

            atmMachine.deposit(amount);
            System.out.println("Deposit successful. New balance: " + atmMachine.checkBalance());
        }


        // Allows the user to withdraw funds from the ATM machine. It takes the ATMMachine and Scanner as parameters.

        public static void withdraw(ATMMachine atmMachine, Scanner scanner) {
            System.out.print("Enter the withdrawal amount: ");
            double amount = scanner.nextDouble();

            if (atmMachine.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + atmMachine.checkBalance());
            } else {
                System.out.println("Insufficient balance. Cannot withdraw.");
            }
        }


        // Checks and displays the current balance of the BankAccount associated with the ATM machine.

        private static void checkBalance(ATMMachine atmMachine) {
            System.out.println("Current balance: " + atmMachine.checkBalance());
        }
    }
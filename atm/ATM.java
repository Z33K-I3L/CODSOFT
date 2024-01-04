 

 import javax.swing.JOptionPane;
 
public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        String menu = "ATM Menu:\n" +
                "1. Withdraw\n" +
                "2. Deposit\n" +
                "3. Check Balance\n" +
                "4. Exit";

        JOptionPane.showMessageDialog(null, menu);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount. Amount must be greater than 0.");
        } else if (amount > bankAccount.getBalance()) {
            JOptionPane.showMessageDialog(null, "Insufficient funds for withdrawal. Current balance: R" + bankAccount.getBalance());
        } else {
            bankAccount.withdraw(amount);
            JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: R" + bankAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount. Amount must be greater than 0.");
        } else {
            bankAccount.deposit(amount);
            JOptionPane.showMessageDialog(null, "Deposit successful. Updated balance: R" + bankAccount.getBalance());
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Current balance: R" + bankAccount.getBalance());
    }

    public static void main(String[] args) {
        String initialBalanceString = JOptionPane.showInputDialog("Enter initial balance: R");
        double initialBalance = Double.parseDouble(initialBalanceString);

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        int choice;
        do {
            atm.displayMenu();
            String choiceString = JOptionPane.showInputDialog("Enter your choice (1-4): ");
            choice = Integer.parseInt(choiceString);

            switch (choice) {
                case 1:
                    String withdrawAmountString = JOptionPane.showInputDialog("Enter withdrawal amount: R");
                    double withdrawAmount = Double.parseDouble(withdrawAmountString);
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    String depositAmountString = JOptionPane.showInputDialog("Enter deposit amount: R");
                    double depositAmount = Double.parseDouble(depositAmountString);
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting ATM. Thank you!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4);
    }
}
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private String description;

    public Transaction(String accountNumber, String type, double amount, String description) {
        this.transactionId = "TXN" + System.currentTimeMillis();
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    public void displayTransaction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("\nTransaction ID: " + transactionId);
        System.out.println("Account: " + accountNumber);
        System.out.println("Type: " + type);
        System.out.println("Amount: $" + amount);
        System.out.println("Time: " + timestamp.format(formatter));
        System.out.println("Description: " + description);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }
}
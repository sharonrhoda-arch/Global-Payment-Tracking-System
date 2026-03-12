import java.util.*;

class Transaction {
    String id;
    String status;

    Transaction(String id, String status) {
        this.id = id;
        this.status = status;
    }
}

public class GlobalPaymentSystem {

    static Scanner sc = new Scanner(System.in);

    // HashMap for storing transactions
    static HashMap<String, Transaction> transactions = new HashMap<>();

    // Queue for alerts
    static Queue<String> alerts = new LinkedList<>();

    // Priority Queue for fraud risk
    static PriorityQueue<Integer> fraudRisk =
            new PriorityQueue<>(Collections.reverseOrder());

    // LinkedList for settlement mismatch
    static LinkedList<String> settlements = new LinkedList<>();

    // Revenue analytics array
    static int revenue[] = {12000, 15000, 14000, 18000, 22000};

    // Add transaction
    static void addTransaction() {
        System.out.print("Enter Transaction ID: ");
        String id = sc.next();

        System.out.print("Enter Status: ");
        String status = sc.next();

        transactions.put(id, new Transaction(id, status));
        System.out.println("Transaction added.");
    }

    // Search transaction
    static void searchTransaction() {
        System.out.print("Enter Transaction ID to search: ");
        String id = sc.next();

        if (transactions.containsKey(id)) {
            Transaction t = transactions.get(id);
            System.out.println("Transaction Found:");
            System.out.println("ID: " + t.id);
            System.out.println("Status: " + t.status);
        } else {
            System.out.println("Transaction not found.");
        }
    }

    // Show alerts
    static void showAlerts() {
        System.out.println("Alerts:");
        for (String a : alerts) {
            System.out.println(a);
        }
    }

    // Fraud center
    static void fraudCenter() {
        System.out.println("Highest Fraud Risk Score: " + fraudRisk.peek());
    }

    // Settlement report
    static void settlementReport() {
        System.out.println("Settlement mismatches:");
        for (String s : settlements) {
            System.out.println(s);
        }
    }

    // Sort revenue analytics
    static void sortRevenue() {
        Arrays.sort(revenue);
        System.out.println("Sorted Revenue Data:");
        for (int r : revenue) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // sample data
        transactions.put("TXN1001", new Transaction("TXN1001", "SUCCESS"));
        transactions.put("TXN1002", new Transaction("TXN1002", "FAILED"));
        transactions.put("TXN1003", new Transaction("TXN1003", "PENDING"));

        alerts.add("128 payments stuck at bank");
        alerts.add("Gateway retry spike");
        alerts.add("SLA breach detected");

        fraudRisk.add(90);
        fraudRisk.add(40);
        fraudRisk.add(70);

        settlements.add("TXN2001 mismatch");
        settlements.add("TXN2002 mismatch");

        int choice;

        do {
            System.out.println("\n=== Global Payment Intelligence System ===");
            System.out.println("1. Add Transaction");
            System.out.println("2. Search Transaction");
            System.out.println("3. View Alerts");
            System.out.println("4. Fraud Center");
            System.out.println("5. Settlement Report");
            System.out.println("6. Revenue Analytics");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    searchTransaction();
                    break;
                case 3:
                    showAlerts();
                    break;
                case 4:
                    fraudCenter();
                    break;
                case 5:
                    settlementReport();
                    break;
                case 6:
                    sortRevenue();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);
    }
}
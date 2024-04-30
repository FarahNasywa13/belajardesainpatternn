package Tugas;

public class Main {
    public static void main(String[] args) {
        // Create order
        Order order = new Order();

        // Create observers (email notifiers)
        EmailNotifier notifier1 = new EmailNotifier("user1@example.com");
        EmailNotifier notifier2 = new EmailNotifier("user2@example.com");

        // Register observers
        order.registerObserver(notifier1);
        order.registerObserver(notifier2);

        // Simulate order status change
        order.setStatus("Shipped");
    }
}
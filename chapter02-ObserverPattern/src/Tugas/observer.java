package Tugas;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete subject
class Order implements Subject {
    private String status;
    private List<Observer> observers = new ArrayList<>();

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}

// Observer interface
interface Observer {
    void update(String status);
}

// Concrete observer
class EmailNotifier implements Observer {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String status) {
        System.out.println("Sending email notification to " + email + ": Order status changed to " + status);
        // Code to send email notification
    }
}
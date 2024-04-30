

User
buatlah contoh kasus code tentang observer pattern
ChatGPT
Tentu, berikut adalah contoh kasus untuk penerapan Observer Pattern:

Contoh Kasus: Pemantauan Stok Barang

Misalkan kita memiliki sebuah sistem manajemen stok barang di sebuah toko online. Ketika jumlah stok suatu barang berubah, kita ingin memberi tahu pengguna yang tertarik tentang perubahan tersebut.

Kita akan menerapkan Observer Pattern untuk memungkinkan objek-objek tertentu (observer) untuk mendaftar dan menerima pemberitahuan ketika stok barang berubah.

Berikut implementasi sederhananya:

python
Copy code
from abc import ABC, abstractmethod

# Subject (Subyek)
class Subject(ABC):
@abstractmethod
def register_observer(self, observer):
pass

    @abstractmethod
    def remove_observer(self, observer):
        pass

    @abstractmethod
    def notify_observers(self):
        pass

# Concrete Subject (Subyek Konkrit)
class Stock(Subject):
def __init__(self, item_name, initial_quantity):
self.item_name = item_name
self.quantity = initial_quantity
self.observers = []

    def register_observer(self, observer):
        self.observers.append(observer)

    def remove_observer(self, observer):
        self.observers.remove(observer)

    def notify_observers(self):
        for observer in self.observers:
            observer.update(self.item_name, self.quantity)

    def set_quantity(self, new_quantity):
        self.quantity = new_quantity
        self.notify_observers()

# Observer (Pemantau)
class Observer(ABC):
@abstractmethod
def update(self, item_name, quantity):
pass

# Concrete Observer (Pemantau Konkrit)
class User(Observer):
def __init__(self, user_name):
self.user_name = user_name

    def update(self, item_name, quantity):
        print(f"Hi {self.user_name}, {item_name} is now available in quantity {quantity}.")

# Usage
if __name__ == "__main__":
# Create stock
stock = Stock("Laptop", 10)

    # Create users
    user1 = User("Alice")
    user2 = User("Bob")

    # Register users as observers
    stock.register_observer(user1)
    stock.register_observer(user2)

    # Change stock quantity
    stock.set_quantity(8)
Dalam contoh ini, Stock adalah subjek yang diamati, dan User adalah pemantau yang mendaftar untuk menerima pemberitahuan ketika stok berubah. Saat stok berubah, Stock memberi tahu semua User yang terdaftar.

User
buatlah analisa singkat dari code disamping : package Tugas;

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
MAIN
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


Desain Observer Pattern: Kode tersebut menerapkan Observer Pattern dengan menggunakan antarmuka Subject dan Observer, serta kelas konkret Order sebagai subjek yang diamati dan EmailNotifier sebagai pemantau konkret yang akan menerima pemberitahuan.
Subject Interface: Antarmuka Subject memiliki tiga metode yaitu registerObserver, removeObserver, dan notifyObservers, yang bertanggung jawab untuk mendaftarkan, menghapus, dan memberi tahu pemantau.
Concrete Subject (Order): Kelas Order adalah subjek konkret yang memiliki atribut status dan daftar observers. Ketika status pesanan berubah, metode setStatus dipanggil, yang kemudian memanggil notifyObservers untuk memberi tahu semua pemantau yang terdaftar.
Observer Interface: Antarmuka Observer memiliki satu metode update, yang akan dipanggil ketika ada pembaruan dari subjek.
Concrete Observer (EmailNotifier): Kelas EmailNotifier adalah pemantau konkret yang mengimplementasikan metode update untuk mengirimkan pemberitahuan melalui email ketika status pesanan berubah.
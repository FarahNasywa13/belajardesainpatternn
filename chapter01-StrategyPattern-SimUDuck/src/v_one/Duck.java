package v_one;

abstract class Duck {
    void quack(){
        System.out.println("Qwek Qwek");
    }

    void swim(){
        System.out.println("Berenang");
    }

    abstract void display();

    void fly(){
        System.out.println("Terbang");
    }
}

class MallardDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedHeadDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }
    @Override
    void quack() {
        System.out.println("Bunyinya squeek, bukan qwak");
    }

    @Override
    void fly() {
        // Tidak ada implementasi, karena bebek mainan tidak dapat terbang
    }
}

class WoodenDuck extends Duck {
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
    @Override
    void quack(){
        // Tidak ada implementasi, karena bebek mainan tidak dapat bersuara
    }

    @Override
    void swim(){
        System.out.println("Mengambang");
    }

    @Override
    void fly(){
        // Tidak ada implementasi, karena bebek mainan tidak dapat terbang
    }
}

package v_two;

interface Quackable {
    void quack();
}

interface Flyable {
    void fly();
}

abstract class Duck {
    abstract void display();

    void swim() {
        System.out.println("Berenang");
    }
}

class MallardDuck extends Duck implements Quackable, Flyable {
    @Override
    public void quack() {
        System.out.println("Qwek Qwek");
    }

    @Override
    public void fly() {
        System.out.println("Terbang");
    }
    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedheadDuck extends Duck implements Quackable, Flyable {
    @Override
    public void quack() {
        System.out.println("Qwek Qwek");
    }

    @Override
    public void fly() {
        System.out.println("Terbang");
    }

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }
}

class WoodenDuck extends Duck {
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
}

class ToyDuck extends Duck implements Flyable {
    @Override
    public void fly() {
        System.out.println("Terbang seperti mainan");
    }

    @Override
    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}

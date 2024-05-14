package v_one;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Mallard-------------");
        MallardDuck mallard = new MallardDuck();
        mallard.quack();
        mallard.swim();
        mallard.display();
        mallard.fly();

        System.out.println("-----------RedHead-------------");
        MallardDuck redhead = new MallardDuck();redhead.quack();
        redhead.swim();
        redhead.display();
        redhead.fly();

        System.out.println("-----------Rubber-------------");
        RubberDuck rubber = new RubberDuck();
        rubber.quack();
        rubber.swim();rubber.display();
        rubber.fly();

        System.out.println("-----------Wooden-------------");
        WoodenDuck wood = new WoodenDuck();
        wood.quack();
        wood.swim();
        wood.display();
        wood.fly();
    }
}






// Penggunaan
//public class Main {
//    public static void main(String[] args) {
//        Order order1 = new Order(5, new RegularShipping());  // Membuat order dengan pengiriman reguler
//        Order order2 = new Order(5, new ExpressShipping());  // Membuat order dengan pengiriman kilat
//
//      Menghitung biaya pengiriman
//        System.out.println("Biaya pengiriman untuk order 1: " + order1.calculateShippingCost());
//        System.out.println("Biaya pengiriman untuk order 2: " + order2.calculateShippingCost());
//    }
//}


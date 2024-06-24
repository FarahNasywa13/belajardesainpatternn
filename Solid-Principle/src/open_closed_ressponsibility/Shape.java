package open_closed_ressponsibility;

// Interface untuk bentuk geometri
interface Shape {
    double calculateArea();
}
// Implementasi untuk lingkaran
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Implementasi untuk persegi
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

// Kelas utama untuk menjalankan program
class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(2);
        Shape square = new Square(4);

        // Menghitung luas dari lingkaran dan persegi tanpa mengubah implementasi Shape
        System.out.println("Luas lingkaran: " + circle.calculateArea());
        System.out.println("Luas persegi: " + square.calculateArea());
    }
}

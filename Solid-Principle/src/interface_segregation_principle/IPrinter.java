package interface_segregation_principle;
class Rectangle {
    private int width;
    private int height;


    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Mengubah tinggi secara konsisten
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height); // Mengubah tinggi secara konsisten
    }
}

class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(9, 7);
        System.out.println("Area persegi panjang: " + rectangle.getArea()); // 15

        Square square = new Square(5);
        square.setWidth(7);
        System.out.println("Area persegi: " + square.getArea()); // 49 (Hasil benar)
    }
}
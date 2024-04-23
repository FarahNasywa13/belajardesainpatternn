public class Unggas {
    public String nama;
    public String warna;

    public void display() {
        System.out.println("Nama : " + nama);
        System.out.println("Warna: " + warna);
    }
}

class Penguin extends Unggas{
    public void swim() {
        System.out.println("Berenang");
    }
}

class Elang extends Unggas{
    public void terbang() {
        System.out.println("Terbang");
    }
}
package kedua;

// Definisi kelas Computer
public class Main {
    public static void main(String[] args) {
        // Membuat builder untuk membangun sebuah ComputerSet
        ComputerSetBuilder builder = new ComputerSetBuilder();

        // Memasukkan spesifikasi komputer ke dalam builder
        builder.computer(new Computer("HP", "Gaming")); // Ganti dengan merek dan model komputer yang diinginkan
        builder.keyboard("Keyboard mekanis"); // Jenis keyboard
        builder.mouse("Mouse nirkabel"); // Jenis mouse
        builder.speaker("Sistem speaker 2.1"); // Jenis speaker
        builder.monitor("Monitor IPS 27 inci"); // Jenis monitor

        // Mendapatkan hasil dari pembangunan ComputerSet
        ComputerSet computerSet = builder.getResult();

        // Menampilkan hasil ComputerSet
        System.out.println("Spesifikasi ComputerSet :");
        System.out.println("Computer: " + computerSet.getComputer());
        System.out.println("Keyboard: " + computerSet.getKeyboard());
        System.out.println("Mouse: " + computerSet.getMouse());
        System.out.println("Speaker: " + computerSet.getSpeaker());
        System.out.println("Monitor: " + computerSet.getMonitor());
    }
}

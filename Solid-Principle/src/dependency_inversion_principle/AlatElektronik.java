package dependency_inversion_principle;

// Program yang mengikuti DIP
interface AlatElektronik {
    void nyalakan();
}

class Lampu implements AlatElektronik {
    @Override
    public void nyalakan() {
        System.out.println("Lampu menyala");
    }
}

class KipasAngin implements AlatElektronik {
    @Override
    public void nyalakan() {
        System.out.println("Kipas Angin menyala");
    }
}

class Tombol {
    private AlatElektronik alat;

    public Tombol(AlatElektronik alat) {
        this.alat = alat;
    }

    public void tekan() {
        alat.nyalakan();
    }
}

// Penggunaan
class Main {
    public static void main(String[] args) {
        AlatElektronik lampu = new Lampu();
        Tombol tombolLampu = new Tombol(lampu);
        tombolLampu.tekan();

        AlatElektronik kipas = new KipasAngin();
        Tombol tombolKipas = new Tombol(kipas);
        tombolKipas.tekan();
    }
}
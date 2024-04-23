public class User {
    public String nama;
    public String email;
    public String alamat;
    public String nohp;
    public int umur;
    public String password;

    public void getName () {
        System.out.println(this.nama);
    }
    public void hashPass () {
        System.out.println(this.password);
    }

}

class Mahasiswa extends User{
    public String nim;

    public void getNim () {
        System.out.println(this.nim);
    }
}

class Dosen  extends User {
    public String nip;
    public String nidn;

    public void getNip() {
        System.out.println(this.nip);
    }
}
public interface Kendaraan {

    public void bergerak();

    public void berhenti();
}
    class Sepeda implements Kendaraan{
        @Override
        public void bergerak() {

        }

        @Override
        public void berhenti() {

        }
    }

    class SepedaMotor implements Kendaraan{

        @Override
        public void bergerak() {
            System.out.println("Tarikkkk mangg");
        }

        @Override
        public void berhenti() {
            System.out.println("Stoppp pakkkk");

        }
    }

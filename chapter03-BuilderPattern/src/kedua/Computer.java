package kedua;
class Computer {
    private String brand;
    private String model;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}

// Definisi kelas ComputerSet
class ComputerSet {
    private Computer computer;
    private String keyboard;
    private String mouse;
    private String speaker;
    private String monitor;

    public ComputerSet(Computer computer, String keyboard, String mouse, String speaker, String monitor) {
        this.computer = computer;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.speaker = speaker;
        this.monitor = monitor;
    }

    public Computer getComputer() {
        return computer;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getMonitor() {
        return monitor;
    }
}

// Definisi kelas ComputerSetBuilder
class ComputerSetBuilder {
    private Computer computer;
    private String keyboard;
    private String mouse;
    private String speaker;
    private String monitor;

    public ComputerSetBuilder computer(Computer computer) {
        this.computer = computer;
        return this;
    }

    public ComputerSetBuilder keyboard(String keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public ComputerSetBuilder mouse(String mouse) {
        this.mouse = mouse;
        return this;
    }

    public ComputerSetBuilder speaker(String speaker) {
        this.speaker = speaker;
        return this;
    }

    public ComputerSetBuilder monitor(String monitor) {
        this.monitor = monitor;
        return this;
    }

    public ComputerSet getResult() {
        return new ComputerSet(computer, keyboard, mouse, speaker, monitor);
    }
}

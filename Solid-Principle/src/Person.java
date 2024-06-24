// Program yang mematuhi SRP
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hello, nama saya " + name + ", saya berusia " + age + " tahun.");
    }
}

class TaskManager {
    public void performTask(String gender) {
        if (gender.equals("Laki-laki")) {
            System.out.println("Memperbaiki mobil.");
        } else if (gender.equals("Perempuan")) {
            System.out.println("Memasak.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Person john = new Person("Jonatan", 30);
        john.introduce();

        Person jane = new Person("Farah", 25);
        jane.introduce();

        TaskManager taskManager = new TaskManager();
        taskManager.performTask("Laki-laki"); // Contoh tugas khusus untuk laki-laki
        taskManager.performTask("Perempuan"); // Contoh tugas khusus untuk perempuan
    }
}

package liskov_substitution_principle;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass yang mewakili kucing
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meonggggg!");
    }
}

// Subclass yang mewakili anjing
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Gokk gokk!");
    }
}

// Metode untuk mengoperasikan objek Animal
class Main {
    public static void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Cat();
        Animal animal3 = new Dog();

        makeAnimalSound(animal1); // Output: Animal makes a sound
        makeAnimalSound(animal2); // Output: Meongggggg!
        makeAnimalSound(animal3); // Output: gokk gokk!
    }
}

interface ShippingStrategy {
    double calculateShippingCost(double weight);
}

// Langkah 2: Implementasikan strategi-strategi konkret
class RegularShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(double weight) {
        // Biaya pengiriman reguler
        return 2.5 * weight;
    }
}

class ExpressShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(double weight) {
        // Biaya pengiriman express
        return 5.0 * weight;
    }
}

class PrimeShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(double weight) {
        // Biaya pengiriman prime
        return 0; // Gratis untuk pengiriman Prime
    }
}

// Langkah 3: Buat kelas "ShippingContext" yang memiliki objek strategi
class ShippingContext {
    private ShippingStrategy strategy;

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShipping(double weight) {
        return strategy.calculateShippingCost(weight);
    }
}
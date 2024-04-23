// Abstract Strategy
interface ShippingStrategy {
    double calculateCost(Order order);
}

// Concrete Strategy 1
class RegularShipping implements ShippingStrategy {
    @Override
    public double calculateCost(Order order) {
        // Biaya pengiriman reguler
        return order.getTotalWeight() * 10;
    }
}

// Concrete Strategy 2
class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculateCost(Order order) {
        // Biaya pengiriman kilat
        return order.getTotalWeight() * 20;
    }
}

// Context
class Order {
    private double totalWeight;
    private ShippingStrategy shippingStrategy;

    public Order(double totalWeight, ShippingStrategy shippingStrategy) {
        this.totalWeight = totalWeight;
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShippingCost() {
        return shippingStrategy.calculateCost(this);
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
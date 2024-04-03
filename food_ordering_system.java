import java.util.*;

abstract class FoodItem {
    protected String name;
    protected double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    abstract void display();
}

interface Orderable {
    void placeOrder(int quantity);

    void cancelOrder();

}

class Pizza extends FoodItem implements Orderable {
    private String Size;

    public Pizza(String name, double price, String size) {
        super(name, price);
        Size = size;
    }

    public void placeOrder(int quantity) {
        System.out.println("Order Details: " + quantity + " Pizza " + name + " Size: " + Size);
    }

    public void cancelOrder() {
        System.out.println("Your Order is cancelled");
    }

    void display() {
        System.out.println("Pizza name:" + name + " Size " + Size);
        System.out.println("Price is: " + price);
    }
}

class Shake extends FoodItem implements Orderable {
    private String Size;

    public Shake(String name, double price, String size) {
        super(name, price);
        this.Size = size;
    }

    public void placeOrder(int quantity) {
        System.out.println("Order Details: " + quantity + " Shake: " + name + " Size: " + Size);
    }

    public void cancelOrder() {
        System.out.println("Your Order is cancelled.");
    }

    void display() {
        System.out.println("Shake name:" + name + " Size " + Size);
        System.out.println("Price is: " + price);
    }
}

class InvalidMenuItemException extends Exception {

    InvalidMenuItemException(String s) {
        super(s);
    }

}

class PaymentFailedException extends Exception {
    PaymentFailedException(String s) {
        super(s);
    }
}

class FoodOrderingSystem {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int itemNumber = 0;
        int quantity = 0;

        FoodItem menu[] = new FoodItem[4];

        boolean b1 = true;
        while (b1) {
            menu[0] = new Pizza("1) Margherita", 349, "Regular");
            menu[1] = new Pizza("2) Pepperoni", 449, "Regular");
            menu[2] = new Shake("3) Chocolate", 149, "Regular");
            menu[3] = new Shake("4) Strawberry", 249, "Large");

            // Display
            System.out.println("Welcome To Food Ordering System: \n MENU:");
            for (FoodItem temp : menu) {
                temp.display();

            }
            System.out.println("Enter Item Number You wish to Order: ");
            itemNumber = sc.nextInt();

            try {
                if (itemNumber < 1 || itemNumber > menu.length) {
                    throw new InvalidMenuItemException("Invalid Item Number Selected.");
                } else {
                    System.out.println("Enter Quantity for Your Order: ");
                    quantity = sc.nextInt();

                    ((Orderable) menu[itemNumber - 1]).placeOrder(quantity);
                    b1 = false;
                }
            } catch (InvalidMenuItemException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        boolean b = true;
        while (b) {
            try {
                System.out.println("Select a payment method: \n 1.Cash \n 2.Credit Card \n Enter The Payment Method.");

                int paymentMethod = sc.nextInt();

                payment(menu[itemNumber - 1].getPrice() * quantity, paymentMethod);
                System.out.println("Payment Succesfull.. Order Placed !! ");
                b = false;
            } catch (PaymentFailedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static void payment(double amount, int paymentMethod) throws PaymentFailedException {
        switch (paymentMethod) {
            case 1:

                // For Cash-Payment

                System.out.println("Your Total Bill is: " + amount);
                System.out.println("Enter Bill Amount to pay: ");
                double cash = sc.nextDouble();
                if (cash < amount) {
                    throw new PaymentFailedException("Payment Failed !!");
                }
                break;

            case 2:

                // For Credit-Card Payment

                System.out.println("Your Total Bill is; " + amount);
                System.out.println("Enter Bill Amount to pay: ");
                double credit = sc.nextInt();

                if (credit < amount) {
                    throw new PaymentFailedException("Payment Failed !!");
                }
                System.out.println("Enter Credit Card number:(valid:12345678)");
                int creditcard = sc.nextInt();

                if (creditcard != 12345678) {
                    throw new PaymentFailedException("Payment Failed !!");
                }
                break;

            default:
                throw new PaymentFailedException("Payment Method Invalid !!");

        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;






class Product {
    int pid;
    String pname;
    double price;
    int quantity;


    // constructor with all fields

    Product(int pid, String pname, double price, int quantity) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
    }

    //calculate total price of this product(wiith 5% discount if quantity>3)

    double getTotalPrice() {
        double totalPrice = price * quantity;
        if (quantity > 3) {
            totalPrice *= 0.95; // apply 5% discount
        }
        return totalPrice;
    }

    // format product details printing 

    @Override
    public String toString() {
        return String.format("Product ID: %d, Name: %s, Price: %.2f, Quantity: %d, Total Price: %.2f",
                pid, pname, price, quantity, getTotalPrice());

    }
    
}


// oreder class to hold multiple products and calculate totals

class Order {
    ArrayList<Product> products = new ArrayList<>();
    double  totalcost =0.0;

    // add product to order and update total cost
    void addproduct(Product p) {
        products.add(p);
        totalcost += p.getTotalPrice();
    }


    // calculate discount on total cost if total cost > 5000 (10% discount)
    double getFinalTotal() {
        if (totalcost > 5000) {
            return totalcost * 0.90; // apply 10% discount
        }
        return totalcost;
    }

    // print details invoice

    void printInvoice(){
        System.out.println("\nInvoice Details:");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s%n", "PID", "Product Name", "Price", "Quantity", "Total Price");

        for (Product p : products) {
            System.out.printf("%-10d %-20s %-10.2f %-10d %-15.2f%n", p.pid, p.pname, p.price, p.quantity, p.getTotalPrice());
        }
        System.out.printf("Total Cost: %.2f%n", totalcost);
        double discount = totalcost - getFinalTotal(); // Calculate discount as difference between total and final cost
        System.out.printf("Discount: %.2f%n", discount);
        System.out.printf("Final Total: %.2f%n", getFinalTotal());
    }





}


public class EcommeraceOrders {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Welcome to the E-commerce Order System");
        System.out.println("How many products do you want to order?");
        int numberOfProducts = sc.nextInt();


        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Enter details for product " + (i + 1) + " (pid, pname, price, quantity):");
            
            System.out.println("Product ID:");
            int pid = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Product name:");
            String pname = sc.nextLine();

            System.out.println("product price:");
            double price = sc.nextDouble();

            System.out.println("product quantity:");
            int quantity = sc.nextInt();

            Product p = new Product(pid, pname, price, quantity);
            order.addproduct(p);
        }


        order.printInvoice();
        sc.close();

    }





}
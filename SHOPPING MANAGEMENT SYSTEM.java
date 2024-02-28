import java.util.*;

class sm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shop sh = new Shop(10, 5);
		boolean flag = true;

		while (flag) {
			System.out.println("\n=== Shop Management System ===");
			System.out.println("1. Add Product");
			System.out.println("2. Remove Product");
			System.out.println("3. Update Product Quantity");
			System.out.println("4. Update Product Price");
			System.out.println("5. Add Customer");
			System.out.println("6. Remove Customer");
			System.out.println("7. Update Customer Membership Status");
			System.out.println("8. Display Products");
			System.out.println("9. Display Customers");
			System.out.println("10. Exit");
			System.out.println("Enter your choice:");

			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					sh.addProducts(sc);
					break;
				case 2:
					sh.removeProducts(sc);
					break;
				case 3:
					sh.updateProductQuantity(sc);
					break;
				case 4:
					sh.updateProductPrice(sc);
					break;
				case 5:
					sh.addCustomers(sc);
					break;
				case 6:
					sh.removeCustomer(sc);
					break;
				case 7:
					sh.updateCustomerMembershipStatus(sc);
					break;
				case 8:
					sh.displayProducts();
					break;
				case 9:
					sh.displayCustomers();
					break;
				case 10:
					flag = false;
					System.out.println("Exit from the Shopping Management System. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 10.");
			}
		}

	}
}

class Product {
	String name;
	Integer id;
	Double price;
	Integer quantity;

	Product(String name, Integer id, Double price, Integer quantity) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}

	// Display product information
	void displayInfo() {
		System.out.println("Product: " + name + ", ID: " + id + ", Price: $" + price + ", Quantity: " + quantity);
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	Integer getId() {
		return id;
	}

	void setId(Integer id) {
		this.id = id;
	}

	Double getPrice() {
		return price;
	}

	void setPrice(Double price) {
		this.price = price;
	}

	Integer getQuantity() {
		return quantity;
	}

	void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

class Customer {
	Integer customerId;
	String name;
	String contactInfo;
	String membershipStatus;

	Customer(Integer id, String name, String contactInfo, String membershipStatus) {
		this.customerId = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.membershipStatus = membershipStatus;
	}

	// Getters and setters
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getContactInfo() {
		return contactInfo;
	}

	void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	String getMembershipStatus() {
		return membershipStatus;
	}

	void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	Integer getCustomerId() {
		return customerId;
	}

	void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	// Display customer information
	void displayInfo() {
		System.out.println("Customer: " + customerId + name + ", Contact Info: " + contactInfo + ", Membership Status: "
				+ membershipStatus);
	}

}

class Shop {
	int productCount = 0;
	int customerCount = 0;

	Product[] productArr;
	Customer[] customerArr;

	Shop(int maxProducts, int maxCustomers) {
		this.productArr = new Product[maxProducts];
		this.customerArr = new Customer[maxCustomers];
		this.productCount = 0;
		this.customerCount = 0;
	}

	// this method will add all products

	void addProducts(Scanner sc) {
		System.out.println("Enter how many products you want to add:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			while (true) {
				System.out.println("Enter product ID:");
				int id = sc.nextInt();

				System.out.println("Enter product name:");
				String name = sc.next();

				System.out.println("Enter product price:");
				double price = sc.nextDouble();

				System.out.println("Enter product quantity:");
				int quantity = sc.nextInt();

				Product productEntity = new Product(name, id, price, quantity);

				this.productArr[productCount++] = productEntity;
				System.out.println("Product has been added successfully!");

				break;
			}
		}
	}

	

	// method to remove products

	void removeProducts(Scanner sc) {
		System.out.println("Enter the product id to remove:");
		int idToRemove = sc.nextInt();

		for (int i = 0; i < this.productArr.length; i++) {
			if (this.productArr[i] != null && this.productArr[i].getId() == idToRemove) {
				System.arraycopy(this.productArr, i + 1, this.productArr, i, this.productArr.length - 1 - i);
				this.productCount--;
				System.out.println("Product has been removed successfully!");
				return;
			}
		}

		System.out.println("Product with ID " + idToRemove + " not found.");
	}

	// method will display product

	void displayProducts() {
		if (this.productArr == null || this.productCount == 0) {
			System.out.println("No products available to display.");
			return;
		}

		for (int i = 0; i < this.productCount; i++) {
			this.productArr[i].displayInfo();
		}
	}

	// update product quantity

	void updateProductQuantity(Scanner sc) {
		System.out.println("Enter a product id to update quantity:");
		Integer id = sc.nextInt();

		for (int i = 0; i < this.productCount; i++) {
			if (this.productArr[i].getId().equals(id)) {
				System.out.println("Enter a new quantity:");
				Integer quantityToUpdate = sc.nextInt();
				this.productArr[i].setQuantity(quantityToUpdate);
				System.out.println("Product quantity has been updated successfully!");
				return;
			}
		}

		System.out.println("Product with ID " + id + " not found.");
	}

	// method to update product price

	void updateProductPrice(Scanner sc) {
		System.out.println("Enter a product id to update price:");
		Integer id = sc.nextInt();

		for (int i = 0; i < this.productCount; i++) {
			if (this.productArr[i].getId().equals(id)) {
				System.out.println("Enter a new price:");
				Double priceToUpdate = sc.nextDouble();
				this.productArr[i].setPrice(priceToUpdate);
				System.out.println("Product price has been updated successfully!");
				return;
			}
		}

		System.out.println("Product with ID " + id + " not found.");
	}

	// Customer related info:

	void addCustomers(Scanner sc) {
		System.out.println("Enter how many customers you want to add:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			while (true) {
				System.out.println("Enter customer ID:");
				int customerId = sc.nextInt();

				if (isPresentCustomerIdOrNot(customerId)) {
					System.out.println("Customer with the same ID already exists. Please choose a different ID.");
					continue;
				}

				System.out.println("Enter customer name:");
				String name = sc.next();

				System.out.println("Enter customer contactInfo:");
				String contactInfo = sc.next();
				System.out.println("Enter customer membership status(NONE/SILVER/GOLD/PREMIUM) :");
				String memberShipStatus = sc.next();

				Customer customerEntity = new Customer(customerId, name, contactInfo, memberShipStatus);

				this.customerArr[customerCount++] = customerEntity;
				System.out.println("Customer has been added successfully!");

				break;
			}
		}
	}

	boolean isPresentCustomerIdOrNot(Integer id) {
		for (int j = 0; j < this.customerArr.length; j++) {
			if (this.customerArr[j] != null && (this.customerArr[j].getCustomerId() == id)) {
				return true;
			}
		}
		return false;
	}

	void removeCustomer(Scanner sc) {
		System.out.println("Enter the customer id to remove:");
		int idToRemove = sc.nextInt();

		for (int i = 0; i < this.customerArr.length; i++) {
			if (this.customerArr[i] != null && this.customerArr[i].getCustomerId().equals(idToRemove)) {
				System.arraycopy(this.customerArr, i + 1, this.customerArr, i, this.customerArr.length - 1 - i);
				this.customerCount--;
				System.out.println("Customer has been removed successfully!");
				return;
			}
		}

		System.out.println("Customer with ID " + idToRemove + " not found.");
	}

	void displayCustomers() {
		if (this.customerArr == null || this.customerCount == 0) {
			System.out.println("No customers available to display.");
			return;
		}

		for (int i = 0; i < this.customerCount; i++) {
			this.customerArr[i].displayInfo();
		}
	}

	void updateCustomerMembershipStatus(Scanner sc) {
		System.out.println("Enter a customer id to update membership status:");
		Integer customerId = sc.nextInt();

		for (int i = 0; i < this.customerCount; i++) {
			if (this.customerArr[i].getCustomerId().equals(customerId)) {
				System.out.println("Enter a new membership status:");
				String memberShipStatus = sc.next();
				this.customerArr[i].setMembershipStatus(memberShipStatus);
				System.out.println("Customer membership status has been updated successfully!");
				return;
			}
		}

		System.out.println("Customer with ID " + customerId + " not found.");
	}
}

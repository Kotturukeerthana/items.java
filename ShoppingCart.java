import java.util.ArrayList;
import java.util.ListIterator;

class ShoppingCart {

	ArrayList<Item> items;
	double totalAmount;
	double payableAmount;
	double discount;
	double tax;
	String coupon;

	ShoppingCart() {
		this.items = new ArrayList<>();
		this.coupon = "";
		this.totalAmount = 0;
		this.payableAmount = 0;
		this.discount = 0;
		this.tax = 0;
	}

	/*
	 * 5. Add parameter to cart
	 */
	void addToCart(Item item) {
		this.items.add(item);
	}

	/**
	 * 6. Display the cart Items using iterator
	 */
	public void showCart() {
		ListIterator<Item> iterator = items.listIterator();
		while (iterator.hasNext()) {
			Item currentItem = iterator.next();
			System.out.println(currentItem);
		}
	}

	/**
	 * 7. Remove the item from cart
	 * @param i to be removed from cart items
	 */
	public void removeFromCart(Item i) {
		items.remove(i);
	}

	public double getTotalAmount() {
		ListIterator<Item> iterator = items.listIterator();
		this.totalAmount = 0;
		while (iterator.hasNext()) {
			Item currentItem = iterator.next();
			this.totalAmount = this.totalAmount + (currentItem.getUnitPrice() * currentItem.getQuantity());
		}
		return this.totalAmount;
	}

	public void applyCoupon(String coupon) {
		this.coupon = coupon;
		if (coupon.equals("IND10")) {
			this.discount = this.getTotalAmount() * 0.1;
			this.totalAmount = this.totalAmount - this.discount;
		} else {
			this.totalAmount = this.totalAmount;
		}
	}

	public double getPayableAmount() {
		this.payableAmount = 0;
		this.tax = this.totalAmount * 0.14;
		this.payableAmount = this.totalAmount + this.tax;
		return this.payableAmount;
	}

	public void printInvoice() {
		ListIterator<Item> iterator = items.listIterator();
		while (iterator.hasNext()) {
			Item currentItem = iterator.next();
			System.out.print(currentItem.getProductName() + "\t");
			System.out.print(currentItem.getQuantity() + "\t");
			System.out.print(currentItem.getUnitPrice() + "\t");
			System.out.println(currentItem.getUnitPrice() * currentItem.getQuantity());
		}
		System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
		this.applyCoupon(this.coupon);
		System.out.println("\t\t\t" + "Discount : " + this.discount);
		this.getPayableAmount();
		System.out.println("\t\t\t" + "Tax      : " + this.tax);
		System.out.println("\t\t\t" + "Total    : " + this.getPayableAmount());
	}
}
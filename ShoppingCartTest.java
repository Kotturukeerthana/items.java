import java.util.*;

public class ShoppingCartTest {
	public static void main(String[] args) {

		Item i1 = new Item("Tomato", 3, 100);
		Item i2 = new Item("Onion", 3, 100);
		Item i3 = new Item("potato", 3, 100);
		Item i4 = new Item("palak", 3, 100);
		Item i5 = new Item("cucumber", 3, 100);

		ShoppingCart cart = new ShoppingCart();

		/*
		 * 8. Add all the items to the cart
		 */

		cart.addToCart(i1);
		cart.addToCart(i2);
		cart.addToCart(i3);
		cart.addToCart(i4);
		cart.addToCart(i5);

		cart.showCart();

		/* remove the item sent as an argument from the cart */
		cart.removeFromCart(i3);

		System.out.println("After removing item i3:");
		cart.showCart();

		double totalAmount = cart.getTotalAmount();
		System.out.println("Total Amount: " + totalAmount);

		double payableAmount = cart.getPayableAmount();
		System.out.println("Payable Amount: " + payableAmount);

		/* apply a coupon code */
		cart.applyCoupon("IND50");

		System.out.println("After applying IND50 coupon:");
		cart.printInvoice();

		cart.applyCoupon("IND10");

		System.out.println("After applying IND10 coupon:");
		cart.printInvoice();

		cart.addToCart(new Item("Milk", 5, 30.00));

		System.out.println("After adding new item 'Milk':");
		cart.printInvoice();
	}
}
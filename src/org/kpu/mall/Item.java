package org.kpu.mall;

public class Item {
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	public Item(String order_product, int order_price, int order_number) {
		this.itemName = order_product;
		this.itemPrice = order_price;
		this.itemQuantity = order_number;
	}
	public String get_itemName() {
		return this.itemName;
	}
	public int get_itemPrice() {
		return this.itemPrice;
	}
	public int get_itemQuantity() {
		return this.itemQuantity;
	}
	public void set_itemQuantity(int n) {
		this.itemQuantity = n;
	}
}
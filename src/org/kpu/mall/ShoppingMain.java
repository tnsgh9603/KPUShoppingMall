package org.kpu.mall;

public class ShoppingMain {
	public static void main(String[] args) {
		Mall mall = new KpuMall();
		mall.displayItem();
		mall.buyItem();
		mall.showReceipt();
		System.out.println("\n" + " 안녕히 가세요 !!" );
	}
}
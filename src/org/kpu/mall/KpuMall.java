package org.kpu.mall;
import java.util.*;

public class KpuMall implements Mall {
	private HashMap<String, Item> shoppingCart = new HashMap<String, Item>();
	
	Scanner scanner= new Scanner(System.in);
	String order_product = null;
	int order_num=0;
	int order_price=0;
	int order_number=0;
	int sum=0;
	int num=0;
	public void displayItem() {
		System.out.println("------------------------");
		System.out.println("-     KPU FOOD MALL    -");
		System.out.println("------------------------");
		System.out.println(" 1. �Ұ����                2000");
		System.out.println(" 2. �ſ�Ŷ��                3000");
		System.out.println(" 3. �����ܹ���                4000");
		System.out.println(" 4. �ع�������                5000");
		System.out.println(" 5. ���簥����                6000");
		System.out.println("------------------------");
	}
	public void buyItem() {
		boolean flag = true;
		while(flag) {
			try {
				System.out.print("�ֹ��ϼ���. ����(9) >> ");
				order_num = scanner.nextInt();
				if(order_num == 1) {
					order_product="�Ұ����";
					order_price = 2000;
				}
				else if (order_num == 2) {
					order_product="�ſ�Ŷ��";
					order_price = 3000;
				}
				else if (order_num == 3) {
					order_product="�����ܹ���";
					order_price = 4000;
				}
				else if (order_num == 4) {
					order_product="�ع�������";
					order_price = 5000;
				}
				else if (order_num == 5) {
					order_product="���簥����";
					order_price =6000;
				}
				else if (order_num == 9) {
					flag = false;
					System.out.println("�ֹ� �����մϴ�.");
					System.out.println("");
				}
				else {
					System.out.println("�ٽ� �Է����ּ���");
					continue;
				}
				if (flag) {
					System.out.print("������ >> ");
					order_number = scanner.nextInt();
					System.out.println(order_product + " �ֹ� �Ϸ�. �� ���� : " + order_number);
					sum += order_price * order_number;
					if(shoppingCart.get(order_product) ==null) {
						shoppingCart.put(order_product, new Item(order_product,order_price,order_number));
					}
					else {
						order_number += shoppingCart.get(order_product).get_itemQuantity();
						shoppingCart.get(order_product).set_itemQuantity(order_number);
					}
					System.out.println("");
					System.out.println("------------------------");
				}
			}
			catch (InputMismatchException e) {
				System.out.println(" ��Ȯ�ϰ� �Է����ּ���!");
				scanner.nextLine();
			}
		}
		scanner.close();
	}
	public void showReceipt() {
		System.out.println("-------------------");
		System.out.println("-     Receipt     -");
		System.out.println("-------------------");

		Set<String> keys = ((Map<String, Item>) shoppingCart).keySet();
		Iterator<String> it = keys.iterator(); 
		String max_product=null;
		int max_money=0;
		while(it.hasNext()) {
			String name = it.next();
			Item score = shoppingCart.get(name);
			System.out.println(" [ " + score.get_itemName() + ", " + score.get_itemPrice() + "��, " + score.get_itemQuantity() + "�� ]");
			if(score.get_itemPrice() * score.get_itemQuantity()>max_money) {
				max_product= score.get_itemName();
				max_money = score.get_itemPrice() * score.get_itemQuantity();
			}
		}
		System.out.println("");
		System.out.println("�� ���� �ݾ��� " + sum + "�� �Դϴ�.");
		System.out.println("�ְ� ���� ��ǰ�� "+ max_product + "("+max_money+"��) �Դϴ�." );
	}
}
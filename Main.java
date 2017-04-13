package training1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的名字：");
		String name = sc.next();
		Customer cus = new Customer(name);
		String flag = null;
		System.out.println("是否借书（Y/N）");
		flag = sc.next();
		while(flag.equals("Y") || flag.equals("y")) {
			cus.addRental();
			System.out.println("是否借书（Y/N）");
			flag = sc.next();
		}
		System.out.println("完成借阅。");
		cus.bill();
	}
}

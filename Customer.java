package training1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	//客户的名字
	private String name;
	//所租的书的信息
	List<Rental> bookRental = new ArrayList<Rental>();
	
	Customer(String name) {
		this.name = name;
	}
	//加入该名客户所租书的一条信息
	public void addRental() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您所要借阅的书籍:");
		String title = sc.next();
		System.out.println("0,普通图书");
		System.out.println("1,新书");
		System.out.println("2,计算机图书");
		System.out.println("请输入您所要借阅书籍的类型编号:");
		int typeCode = sc.nextInt();
		try {
			boolean flag = false;
			for(int i = 0; i < Book.bookList.size(); i++) {
				if(Book.bookList.get(i) == typeCode)
					flag = true;
			}
			if(!flag) {
				throw new MyException(typeCode);
			}
		}catch(MyException e) {
			System.out.println(e.toString());
		}
		
		System.out.println("请输入您要借阅的天数：");
		int leaseDays = sc.nextInt();
		
		this.bookRental.add(new Rental(title, typeCode, leaseDays));
	}
	
	//输出该名客户的租赁信息
	public void bill() {
		System.out.println(this.name+"借书记录：");
		System.out.println();
		double sum = 0;
		System.out.println("----------------------------------------");
		int n = this.bookRental.size();
		for(int i = 0; i < n; i++) {
			System.out.printf("书名：%s\t", this.bookRental.get(i).book.getTitle());
			System.out.printf("借阅天数：%d\t", this.bookRental.get(i).getLeaseDays());
			System.out.println("租金："+this.bookRental.get(i).getPrice()+"元");
			sum += this.bookRental.get(i).getPrice();
		}
		System.out.println("----------------------------------------");
		System.out.println("总租金："+sum+"元");
	}
}

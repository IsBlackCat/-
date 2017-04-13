package training1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Book {
	//此为所有书籍的类型集合
	public static List<Integer> bookList = new ArrayList<Integer>();
	static {
		bookList.add(0);
		bookList.add(1);
		bookList.add(2);
	}
	//此为三种书的编码，用0，1，2来代表书的类型
	public int commonBook = 0;
	public int newBook = 1;
	public int computerBook = 2;
	//书的名字
	private String title;
	//书的代码编码
	private int typeCode;
	//当初始化书时，要给名字和类型
	Book(String title, int typeCode) {
		this.title = title;
		this.typeCode = typeCode;
	}
	public int getCommonBook() {
		return commonBook;
	}
	public void setCommonBook(int commonBook) {
		this.commonBook = commonBook;
	}
	public int getNewBook() {
		return newBook;
	}
	public void setNewBook(int newBook) {
		this.newBook = newBook;
	}
	public int getComputerBook() {
		return computerBook;
	}
	public void setComputerBook(int computerBook) {
		this.computerBook = computerBook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}
	
}

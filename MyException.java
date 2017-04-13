package training1;

public class MyException extends Exception{
	private int typeCode;
	MyException(int typeCode) {
		this.typeCode = typeCode;
	}
	
	public String toString() {
		return "图书类型输入错误！不能为"+typeCode+"。";
	}
}

package training1;

public class Rental {
	//借阅的天数
	private int leaseDays; 
	//所借的书
	Book book;
	Rental(String title, int typeCode, int leaseDays) {
		book = new Book(title, typeCode);
		this.leaseDays = leaseDays;
	}
	//返回借阅的书的租金
	public double getPrice() {
		if(book.getTypeCode() == 0) {
			return leaseDays;
		}else if(book.getTypeCode() == 1) {
			return leaseDays > 3 ? (leaseDays-3)*2+4.5 : leaseDays*1.5;
		}else if(book.getTypeCode() == 2) {
			return leaseDays*1.5;
		}
		return -1;
	}
	
	public int getLeaseDays() {
		return leaseDays;
	}
	public void setLeaseDays(int leaseDays) {
		this.leaseDays = leaseDays;
	}
	
	
}

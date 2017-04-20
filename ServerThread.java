package training1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	Socket socket = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		OutputStream os = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStreamWriter osr = null;
		BufferedWriter bw = null;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			osr = new OutputStreamWriter(os);
			bw = new BufferedWriter(osr);
			
			bw.write("请输入您的名字：");
			bw.newLine();
			bw.flush();
			String name = br.readLine();
			Customer cus = new Customer(name);
			
			bw.write("是否借书（Y/N）");
			bw.newLine();
			bw.flush();
			String flag = br.readLine();
			while(flag.equals("y") || flag.equals("Y")) {
				cus.addRental(br, bw);
				bw.write("是否借书（Y/N）");
				bw.newLine();
				bw.flush();
				flag = br.readLine();
			}
			
			bw.write("完成借阅。");
			bw.newLine();
			bw.flush();
			cus.bill(br, bw);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(osr != null) osr.close();
				if(is != null) is.close();
				if(os != null) os.close();
				if(socket != null) socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

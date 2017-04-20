package training1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket socket = null;
		//存放用户的ip地址
		List<String> addressUser = new ArrayList<String>();
		
		System.out.println("******服务端已经启动，等待客户端边接******");
		
		while(true) {
			socket = ss.accept();
			ServerThread st = new ServerThread(socket);
			st.start();
			addressUser.add(socket.getLocalSocketAddress().toString());
			System.out.println(addressUser.size()+",当前用户IP地址为"+addressUser.get(addressUser.size()-1));
		}
		
	}
}

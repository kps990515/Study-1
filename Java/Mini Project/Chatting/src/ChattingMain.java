
public class ChattingMain {
	public static void main(String args[]){
		// 서버 생성
		Server server = new Server(10004);
		server.process();
		
		// 클라이언트 생성
		Client client = new Client();
		client.setConnect();
	}
}
import mail.IProxy;
import mail.Mail;
import mail.Proxy;

public class PatternMain {

	public static void main(String[] args) {
		
		// 메일 대행자 생성
		IProxy mailProxy = new Proxy();
		
		// 편지글 작성
		Mail mail = new Mail();
		
		// 대행자를 통한 발송
		mailProxy.sender(mail);
		

	}

}

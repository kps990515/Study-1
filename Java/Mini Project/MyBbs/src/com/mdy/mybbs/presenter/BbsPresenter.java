package com.mdy.mybbs.presenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.mdy.mybbs.model.Bbs;
import com.mdy.mybbs.model.BbsLoader;
import com.mdy.mybbs.view.BbsDetail;
import com.mdy.mybbs.view.BbsInput;
import com.mdy.mybbs.view.BbsList;

public class BbsPresenter {
	
	final boolean START = true;
	final boolean FINISH = false;
	
	boolean runFlag = START;
	
	// ������ �ӽ� �����
	ArrayList<Bbs> datas;
	
	Scanner scanner;
	BbsInput input;
	BbsList list;
	BbsDetail detail;
	BbsLoader loader;
	
	long number = 0;
	
	/**
	 * new �����ڰ� ȣ��Ǹ� init() �Լ��� ���� �ʱ�ȭ���ش�.
	 */
	
	// BbsPresenter ������
	public BbsPresenter(){
		init();
	}
	
	/**
	 * �ʱ�ȭ �Լ�, ����� ��ü���� �̸� �޸𸮿� �ε��صд�.
	 */
	private void init(){
		scanner = new Scanner(System.in);
		input = new BbsInput();
		list = new BbsList();
		detail = new BbsDetail();
		loader = new BbsLoader();
		datas = new ArrayList<>();
	}
	
	public void start(){
		
		while(runFlag){
			System.out.println("���ɾ �Է��ϼ���. [��:���, w:����, r:�󼼺���]");
			String command = scanner.nextLine();
			switch(command){
				case "l":
					datas = loader.read();
					list.showList(datas);
					break;
				case "w":
					write();
					break;
				case "r":
					goDetail();
					break;
			}
		}
	}
	
	private void write(){
		Bbs bbs = input.process(scanner);
//		number = number + 1;
		number = loader.readCount();
		bbs.setId(number);
		bbs.setDate(getDate());
		loader.write(bbs);
		
		datas.add(bbs);
//		datas.add(input.process(scanner));    // ���ٷ� �ۼ��� ���.
	}
	
	private String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long currentTime = System.currentTimeMillis();
		return sdf.format(currentTime);
	}

	// �󼼺���� �̵�
	private void goDetail(){
		System.out.println("�۹�ȣ�� �Է��ϼ���:");
		String temp = scanner.nextLine();
		long id = Long.parseLong(temp);
		for( Bbs bbs : datas ){
			if(bbs.getId() == id){
				detail.showNo(bbs.getId());
				detail.showTitle(bbs.getTitle());
				detail.showAuthor(bbs.getAuthor());
				detail.showDate(bbs.getDate());
				detail.showViewCount(bbs.getView());
				detail.showContent(bbs.getContent());
				detail.endDetail(); // ���� �Ʒ��� ������ �׾��ش�.
				break; // ���ǹ��� ���յǸ� �ݺ����� �����Ѵ�.
			}
		}
		
	}
	
	public void end(){
		runFlag = FINISH;
	}
}
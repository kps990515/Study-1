package com.mdy.polymorphism_upcasting;

public class Parent {

	public String name = null;
	public int age = 0;
	 
	public Parent(){}   // �� �κ��� ���� Child Ŭ�������� ������ �����Ҷ� ��������.
	
	public Parent(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void showInformation(){
		System.out.println("�̸��� "+ name + " �Դϴ�.");
		System.out.println("���̴� "+ age + " �Դϴ�.");
	}
	
	public void goSomewhere(){
		System.out.println("ȸ�翡 ���ϴ�.");
	}
	
	public void liveWhere(){
		System.out.println("���￡ ��� �ֽ��ϴ�.");
	}

}
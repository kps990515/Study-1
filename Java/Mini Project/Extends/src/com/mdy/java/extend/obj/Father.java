package com.mdy.java.extend.obj;

public class Father extends Fix implements Cook{
	public String lastname;
	public String name;
	
	public int age;
	public int money;
	public String house;
	public String car;
	public String wife; // 부모클래스의 속성은 포괄적인 것으로 해야 자식클래스도 사용할 수 있다.

	public void process9(){
		process();
	}
	
	
	public void goDestination(){
		
		process9();
		
		System.out.println("9줄의 결과");
	}


	@Override
	public void boil() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void gril() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void fry() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void oven() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void steam() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void disassemble() {
		System.out.println("분해하였습니다");
		
	}


	@Override
	public void replacePart() {
		System.out.println("교체하였습니다");
		
	}


	@Override
	public void clean() {
		System.out.println("청소하였습니다");
		
	}


	@Override
	public void assemble() {
		System.out.println("조립완료");
		
	}
}

package cn.itcast.test;

import org.springframework.mock.web.MockHttpServletRequest;

import java.math.BigDecimal;

public class Demo2 {
	public static void main(String[] args) {
//		T t = new T();
//		Thread t1= new Thread(t,"窗口1");
//		Thread t2= new Thread(t,"窗口2");
//		Thread t3= new Thread(t,"窗口3");
//		t1.start();
//		t2.start();
//		t3.start();
		count();


	}
	public static void count(){
		int a=1,b;
		b=
			a++ +
			++a;
		System.out.println(b);

	}

}

package cn.itcast.test;

import java.io.Serializable;

public class Person implements Serializable{
	public String name;
	public  int age;
	private static final long serialVersionUID = 23471L;


	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
}

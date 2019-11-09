package com.abc.homework;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-11-09 18:57
 **/
public class Animal {
	String name;

	Animal(String name) {
		this.name = name;
	}

	void cry() {
	}

	void run() {
		System.out.println(name + "可以动！");
	}

	void eat() {
	}

	public static class Dog extends Animal {
		Dog(String name) {
			super(name);
		}

		@Override
		void cry() {
			System.out.println(name + "可以汪汪叫");
		}

		@Override
		void run() {
			System.out.println(name + "可以奔跑");
		}

		@Override
		void eat() {
			System.out.println(name + "喜欢吃肉");
		}
	}

	public static class Cat extends Animal {
		Cat(String name) {
			super(name);
		}
		@Override
		void cry() {
			System.out.println(name + "喵喵叫");
		}
		@Override
		void eat() {
			System.out.println(name + "喜欢吃鱼");
		}
	}

	public static class TestAnimal {
		public static void main(String[] args) {
			Cat c = new Cat("小猫");
			c.cry();
			c.run();
			c.eat();
			Dog d = new Dog("小狗");
			d.cry();
			d.run();
			d.eat();
		}
	}
}

package Practise;

import java.util.LinkedList;

public class MyStack implements Stack {
	LinkedList<Hero> heros = new LinkedList<Hero>();

	@Override
	public void push(Hero h) {
		heros.addLast(h);
	}

	@Override
	public Hero pull() {
		return heros.removeLast();
	}

	@Override
	public Hero peek() {
		return heros.getLast();
	}

	public static void main(String[] args) {

		MyStack heroStack = new MyStack();
		for (int i = 0; i < 5; i++) {
			Hero h = new Hero("hero name " + i);
			System.out.println("压入 hero:" + h);
			heroStack.push(h);
		}
		for (int i = 0; i < 5; i++) {
			Hero h = heroStack.pull();
			System.out.println("弹出 hero" + h);
		}
	}
}

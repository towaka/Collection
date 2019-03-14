package Practise.HeroNode;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
	// 左子节点
	public HeroNode leftNode;
	// 右子节点
	public HeroNode rightNode;
	// 值
	public Hero hero;

	public void add(Hero other) {
		if (hero == null) {
			hero = other;
		}

		else {
			if (other.hp>hero.hp) {
				if (leftNode == null)
					leftNode = new HeroNode();
				leftNode.add(other);
			}

			else {
				if (rightNode == null)
					rightNode = new HeroNode();
				rightNode.add(other);
			}
		}
	}

	// 中序遍历所有的节点
	public List<Hero> values() {
		List<Hero> heros = new ArrayList<>();

		// 先添加左节点，左节点的遍历结果
		if (null != leftNode)
			heros.addAll(leftNode.values());

		// 当前节点
		heros.add(hero);

		// 然后添加右节点，右节点的遍历结果
		if (null != rightNode)

			heros.addAll(rightNode.values());

		return heros;
	}
	
	public static void main(String[] args) {
		List<Hero> heros = new ArrayList<Hero>();
		
		System.out.println("------为英雄们赋予名字和血量------");
		for(int i=0;i<10;i++) {
			Hero h = new Hero();
			h.name = "hero "+ (i+1);
			h.hp = (int) (Math.random()*899+100);//血量100以上，1000以下
			heros.add(h);
		}
		
		
		System.out.println("------放入二叉树前------");
		for(Hero h:heros) {
			System.out.println(h.name+" "+h.hp);
		}
		
		System.out.println("------放入二叉树------");
		HeroNode roots = new HeroNode();
        for (int i = 0;i<heros.size();i++) {
            roots.add(heros.get(i));
        }
        
        System.out.println("------放入二叉树后------");
        for(Hero h:roots.values()) {
			System.out.println(h.name+" "+h.hp);
		}
        
	}
}

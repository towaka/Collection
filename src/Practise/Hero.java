package Practise;

public class Hero implements Comparable<Hero>{
	public String name;
    public float hp;
    public int damage;
  
    public Hero() {
  
    }
  
    // 增加一个初始化name的构造方法
    public Hero(String name) {
  
        this.name = name;
    }
    
    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
  
    // 重写toString方法
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }

	public String getName() {
		return name;
	}

	public float getHp() {
		return hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
   
    
     
}

package com.codingdojo.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super();
		this.energyLevel = 300;
	}
	
	public void fly() {
		if (this.energyLevel >= 50) {
			System.out.println("The bat takes off.");
			this.energyLevel -= 50;
		} else {
			System.out.println("The bat doesn't have enough energy to do this.");
		}
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		if (this.energyLevel >= 100) {
			System.out.println("The town is on fire!");
			this.energyLevel -= 100;
		} else {
			System.out.println("The bat doesn't have enough energy to do this.");
		}
	}
}

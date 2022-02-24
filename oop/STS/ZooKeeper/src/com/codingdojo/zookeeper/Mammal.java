package com.codingdojo.zookeeper;

public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int displayEnergy() {
		System.out.printf("Energy level: %d\n", this.energyLevel);
		return this.energyLevel;
	}
}

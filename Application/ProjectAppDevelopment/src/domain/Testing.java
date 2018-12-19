package domain;

import java.time.Year;
import java.util.TreeSet;

import species.HeckCattle;
import species.KonikHorse;
import species.LargeHerbivore;
import species.RedDeer;

public class Testing {

	public static void main(String[] args) {
		LargeHerbivore deer = new RedDeer();
		LargeHerbivore horse = new KonikHorse();
		LargeHerbivore cow = new HeckCattle();
		
		TreeSet<LargeHerbivore> set = new TreeSet<LargeHerbivore>();
		set.add(deer);
		set.add(horse);
		set.add(cow);
		
		NaturePreserve preserve = NaturePreserve.instance(set);
		System.out.println(preserve.getSpecies("Red Deer").getCarryingCap());
		System.out.println(preserve.getState(2).getSpecies("Heck Cattle").getCurrentPopulation());
		System.out.println(preserve.getState(3).getSpecies("Konik Horse").getCurrentPopulation());

	}
}

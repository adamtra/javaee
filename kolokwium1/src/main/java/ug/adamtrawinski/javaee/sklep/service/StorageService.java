package ug.adamtrawinski.javaee.sklep.service;

import ug.adamtrawinski.javaee.sklep.domain.Laptop;

import java.util.HashMap;
import java.util.Map;

public class StorageService {
	
	private Map<Long, Laptop> db = new HashMap<Long, Laptop>();

	public void add(Laptop laptop) {
		Laptop newLaptop = new Laptop(laptop.getId(), laptop.getName(), laptop.isUsed(), laptop.getPrice(), laptop.getReleaseDate());
		db.put(laptop.getId(), newLaptop);
	}

	public Map<Long, Laptop> getAllLaptops(){
		return db;
	}

}

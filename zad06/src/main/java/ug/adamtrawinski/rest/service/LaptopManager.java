package ug.adamtrawinski.rest.service;

import ug.adamtrawinski.rest.domain.Laptop;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class LaptopManager {
	
	private List<Laptop> db = Collections.synchronizedList(new ArrayList<>());

	public void addLaptop(Laptop laptop) {
		db.add(laptop);
	}

	public Laptop updateLaptop(Laptop laptop) {
		for (int i = 0; i < db.size(); i++) {
			if(db.get(i).getId() == laptop.getId()) {
				db.set(i, laptop);
				return laptop;
			}
		}
		return null;
	}

	public void deleteLaptop(long id){
		Laptop delete = null;
		for(Laptop laptop: db) {
			if(laptop.getId() == id) {
				delete = laptop;
				break;
			}
		}
		db.remove(delete);
 	}
	
	public Laptop getLaptop(long id) {
		for(Laptop laptop: db) {
			if(laptop.getId() == id) {
				return laptop;
			}
		}
		return null;
	}
	
	public List<Laptop> getAllLaptops(){
		return db;
	}
	
	public void deleteAllLaptops(){
		db.clear();
	}

}

package de.hs_furtwangen.informatik.meldeauskunft.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository{
	
	List<Resident> list = new ArrayList<Resident>();
	
public ResidentRepositoryStub(){
	
	Date myDate = Date.valueOf("2002-11-25");
	
	Resident Resident1 = new Resident("Jan", "wolf", "street", "city", myDate);
	Resident Resident2 = new Resident("mo", "er", "str", "cit", null);
	Resident Resident3 = new Resident("mos", "ers", "str2", "citz", null);
	
	
	list.add(Resident1);
	list.add(Resident2);
	list.add(Resident3);
}

	public List<Resident> getResidents() {
		return list;
	}
	
}

package de.hs_furtwangen.informatik.meldeauskunft.service;


import java.sql.Date;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import static org.junit.Assert.*;

import org.junit.Test;

public class ResidentServiceTest {
	
	ResidentRepository stub = new ResidentRepositoryStub();
	BaseResidentService service = new BaseResidentService();
	
	@Test
	public void getFilteredResidentsList(){
		
		service.setResidentRepository(stub);
		
		Resident suche = new Resident("Jan", "", "", "", null);
		
		List<Resident> filteredlist = service.getFilteredResidentsList(suche);
	
		assertEquals(filteredlist.get(0).getGivenName(),suche.getGivenName());
	}
	
	@Test
	public void getFilteredResidentsList2(){
		
		Date myDate = Date.valueOf("2002-11-25");
		
		service.setResidentRepository(stub);
		
		Resident suche = new Resident("Jan", "", "", "", myDate);
		
		List<Resident> filteredlist = service.getFilteredResidentsList(suche);
	
		assertEquals(filteredlist.get(0).getDateOfBirth(),suche.getDateOfBirth());
	}
	
	@Test
	public void getFilteredResidentsList3(){
		
		
		service.setResidentRepository(stub);
		
		Resident suche = new Resident("Jan", "", "", "", null);
		
		List<Resident> filteredlist = service.getFilteredResidentsList(suche);
	
		assertNotEquals(filteredlist.get(0).getDateOfBirth(),suche.getDateOfBirth());
	}
	
	@Test
	public void  getUniqueResident(){
		try{
			service.setResidentRepository(stub);
			Resident suche = new Resident("*", "", "", "", null);
			
			service.getUniqueResident(suche);
			fail("Erwartete Ausnahme wurde nicht geworfen");
		} catch(Exception e){
		}
	}
	
	@Test
	public void  getUniqueResident2(){
		try{
			service.setResidentRepository(stub);
			Resident suche = new Resident("Jan", "", "", "", null);
			
			Resident gesucht = service.getUniqueResident(suche);
			assertEquals(gesucht.getGivenName(), suche.getGivenName());
		} catch(Exception e){
		}
	}
	
	@Test
	public void  getUniqueResident3(){
		try{
			service.setResidentRepository(stub);
			Resident suche = new Resident("J*", "", "", "", null);
			
			service.getUniqueResident(suche);
			fail("Erwartete Ausnahme wurde nicht geworfen");
		} catch(Exception e){
		}
	}
	
}

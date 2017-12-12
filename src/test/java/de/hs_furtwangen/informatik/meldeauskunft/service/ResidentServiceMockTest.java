package de.hs_furtwangen.informatik.meldeauskunft.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;

import org.easymock.EasyMock;
import org.junit.Test;

public class ResidentServiceMockTest {
	
	BaseResidentService service = new BaseResidentService();
	ResidentRepository mock = EasyMock.createMock(ResidentRepository.class);
	
	@Test
	public void getFilteredResidentsList(){
		
		service.setResidentRepository(mock);
		
		List<Resident> list = new ArrayList<Resident>();
		
		Date myDate = Date.valueOf("2002-11-25");
		Resident Resident1 = new Resident("Jan", "wolf", "street", "city", myDate);
		Resident Resident2 = new Resident("mo", "er", "str", "cit", null);
		Resident Resident3 = new Resident("mos", "ers", "str2", "citz", null);
		
		list.add(Resident1);
		list.add(Resident2);
		list.add(Resident3);
		
		EasyMock.expect(mock.getResidents()).andReturn(list);
		EasyMock.replay(mock);
		Resident suche = new Resident("Jan", "", "", "", null);
		List<Resident> filteredlist = service.getFilteredResidentsList(suche);
		EasyMock.verify(mock);
	}

}

package com.drools;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class Test3 {
	
	public static void main(String[] args) {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kcontainer = ks.getKieClasspathContainer();
		KieSession kieSession = kcontainer.newKieSession("rulesSession");
		
		Room room = new Room();
		room.setName("1A");
		

		Room r2 = new Room();
		r2.setName("1B");
		

//		List<Room> rooms = new ArrayList<Room>();
//		rooms.add(r1);
//		rooms.add(r2);

		Fire fire = new Fire();
		fire.setRoomHasFire("true");
		
//		for (Room r : rooms) {
//		if (r.isRoomHasFire()) {
//		f.setRooms( rooms);
//		}
//		}
		
		
		// insert the fact into working memory
		kieSession.insert(room);
		kieSession.insert(fire);
	//	kieSession.insert(person2);
		//kieSession.insert(person3);
		
		// fire all the rules present in production memory
		kieSession.fireAllRules();
		kieSession.dispose();
		//System.out.println("product discount ::-> "+product.getDiscount());
		System.out.println("rule execution end..");
	
	}

}

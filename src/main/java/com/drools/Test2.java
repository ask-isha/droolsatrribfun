package com.drools;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class Test2 {
	
	public static void main(String[] args) {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kcontainer = ks.getKieClasspathContainer();
		KieSession kieSession = kcontainer.newKieSession("rulesSession");
		
		
		Product product= new Product();
		product.setProductName("mobile");
		product.setProductPrice(65000.0);
		
		Address address1 = new Address();
		address1.setCity("KOL");
		
		Address address2 = new Address();
		address2.setCity("HYD");
		
		Person person = new Person();
		person.setProduct(product);
		person.setUserType("Regular");
		person.setName("Sayan");
		person.setAge(50);
		
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address1);
		addressList.add(address2);
		
		person.setAddress(addressList);
		
		Person person2 = new Person();
		person2.setUserType("Regular");
		person2.setName("Rahul");
		person2.setAge(45);
		
		Person person3 = new Person();
		person3.setUserType("Non-Regular");
		person3.setName("Sachin");
		person3.setAge(32);
		
		// insert the fact into working memory
		kieSession.insert(product);
		kieSession.insert(person);
		kieSession.insert(person2);
		//kieSession.insert(person3);
		
		// fire all the rules present in production memory
		kieSession.fireAllRules();
		kieSession.dispose();
		//System.out.println("product discount ::-> "+product.getDiscount());
		System.out.println("rule execution end..");
	
	}

}

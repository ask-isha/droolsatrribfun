package com.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class Test {
	
	public static void main(String[] args) {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kcontainer = ks.getKieClasspathContainer();
		KieSession kieSession = kcontainer.newKieSession("rulesSession");
		
		
		Product product= new Product();
		product.setProductName("Laptop");
		product.setProductPrice(65000.0);
		
		Person person = new Person();
		person.setProduct(product);
		person.setUserType("Regular");
		person.setName("Sayan");
		
		// insert the fact into working memory
		kieSession.insert(product);
		kieSession.insert(person);
		
		
		Agenda agenda = kieSession.getAgenda();
		agenda.getAgendaGroup("print").setFocus();
		agenda.getAgendaGroup("discount").setFocus();
		
		// fire all the rules present in production memory
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("product discount ::-> "+product.getDiscount());
		System.out.println("rule execution end..");
	
	}

}

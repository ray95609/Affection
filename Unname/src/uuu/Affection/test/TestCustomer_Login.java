package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;

public class TestCustomer_Login {

	public static void main(String[] args) {
		
				CustomerService cService=new CustomerService();
							
				try {
					System.out.println(cService.login("A123123123","CTT123"));
				} catch (AffectionException e) {
				System.out.println(e.getMessage());	//for user
				//e.printStackTrace();				//for developer
				Logger.getLogger("...").log(Level.SEVERE, e.getMessage(), e);
				//Logger.getLogger("...").log(Level.SEVERE,e.getMessage(),e );
				}

	}

}

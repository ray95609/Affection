package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionAtaInvalidException;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;

public class testUpdata {

	public static void main(String[] args) {
		CustomerService cService=new CustomerService();
		Customer c1 =new Customer();
		
		try {
		c1.setId("N176024294");
		c1.setPassword("GTAWESA");
		c1.setName("沼璞稻");
		c1.setEmail("Cbd@gmail.com");
		c1.setBirthday(1950,01,12);
		c1.setGender('M');
		c1.setPhone("0911223344");
		c1.setAddress("沼澤區");
		c1.setSubscribed(true);
				//runtime exception
		
		try {
			cService.updata(c1);
		} catch (AffectionException e) {
			System.out.println(e.getMessage());//for user
			Logger.getLogger("...").log(Level.SEVERE, e.getMessage(), e);//for developer
		}
		
		}catch(AffectionAtaInvalidException e){
			System.out.println(e.getMessage());//for user
			Logger.getLogger("...").log(Level.SEVERE, e.getMessage(), e);//for developer
		}
		
				
		Customer c2;
		try {
			c2 = cService.login("N176024294", "GTAWESA");
			System.out.println(c2);
		} catch (AffectionException e) {
			System.out.println(e.getMessage());//for user
			Logger.getLogger("...").log(Level.SEVERE, e.getMessage(), e);
		}
		
				

	}
		
		
		
	}


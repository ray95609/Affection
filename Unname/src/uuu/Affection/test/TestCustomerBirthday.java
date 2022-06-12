package uuu.Affection.test;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionAtaInvalidException;

public class TestCustomerBirthday {

	public static void main(String[] args) {
		try {
			Customer c = new Customer();
			c.setBirthday("2014-01-12");
			System.out.println(c.getBirthday());
	
			c.setBirthday("2000-1-12");
			System.out.println(c.getBirthday());

			c.setBirthday(2000,1,32);
			System.out.println(c.getBirthday());
		
		}catch(AffectionAtaInvalidException e) {
			System.out.println(e.getMessage());
		}
	}

}

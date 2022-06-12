package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.OrderService;

public class testHistoryById {

	public static void main(String[] args) {
		OrderService oService= new OrderService();
		
		try {
			System.out.println(oService.getOrderHistoryByCustomerId("A123456789"));
		}catch(AffectionException e) {
			Logger.getLogger("測試歷史訂單").log(Level.SEVERE, e.getMessage(), e);
		}

	}

}

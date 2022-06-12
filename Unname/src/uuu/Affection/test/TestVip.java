package uuu.Affection.test;

import uuu.Affection.entity.VIP;

public class TestVip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VIP vip_1=new VIP();
		VIP vip_2=new VIP();
		
		
		vip_1.setId("A123456789");
		System.out.println(vip_1.getId());
		
		vip_1.setName("杜紫萼");
		System.out.println(vip_1.getName());
		
		vip_1.setDiscount(15);
		System.out.println(vip_1.getDiscount());
		System.out.println(vip_1.getDiscounting());
		
		System.out.println(vip_1);
	
		
		
		
		
	}

}

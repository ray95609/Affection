package uuu.Affection.test;

import uuu.Affection.entity.Outlet;

public class TestOutlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outlet outlet_1=new Outlet();
		
		outlet_1.setName("善新人");
		outlet_1.setId(100001);
		outlet_1.setStock(0);
		outlet_1.setNeed(20);
		outlet_1.setPrice(50000);
		outlet_1.setDiscount(21);
		
		System.out.println("折價專案編號:"+outlet_1.getId());
		System.out.println("折價專案名稱:"+outlet_1.getName());
		System.out.println("折價品需求:"+outlet_1.getNeed());
		System.out.println("折價品目前庫存:"+outlet_1.getStock());
		System.out.println("折扣前售價"+outlet_1.getPrice()+"元");
		System.out.println("折價品折扣(外):"+outlet_1.getDiscount()+"%off");
		System.out.println("折價品折扣(台):"+outlet_1.getDiscounting());
		System.out.println("售價:"+(int)outlet_1.getListPrice()+"元");
		System.out.println("折扣後售價:"+outlet_1.getPrice()+"元");
		
		System.out.println(outlet_1);
		
	}

}

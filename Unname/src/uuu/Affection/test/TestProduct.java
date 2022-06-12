package uuu.Affection.test;

import uuu.Affection.entity.Product;

public class TestProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p =new Product();//無參數建構式//預設建構式//較常用
		p.setId(1);
		p.setName("尿布");
		p.setPrice(1500);
		p.setStock(0);
		p.setNeed(100);
		p.setDescription("捐贈尿布~幫助失親兒童");
		p.setPhotoUrl(("https://i1.momoshop.com.tw/1628678315/goodsimg/0007/040/962/7040962_L2_m.webp"));
		
		
		System.out.println("捐贈物品編號");
		System.out.println(p.getId());
		System.out.println();
		
		System.out.println("捐贈物品");
		System.out.println(p.getName());
		System.out.println();
		
		System.out.println("捐贈物品價格");
		System.out.println(p.getPrice());
		System.out.println();
		
		System.out.println("捐贈物品庫存");
		System.out.println(p.getStock());
		System.out.println();
		
		System.out.println("目前需求數量");
		System.out.println(p.getNeed());
		System.out.println();
		
		System.out.println("捐贈物品描述");
		System.out.println(p.getDescription());
		System.out.println();
		
		System.out.println("捐贈物品照片");
		System.out.println(p.getPhotoUrl());
		System.out.println();
		
		
		
		System.out.println("----------------------------------------------------------");
		
		
		
		System.out.println(p);
		
//		Product p_2=new Product("2","冰箱",50000.0);//Class Product內需有建構式 //常用於測試人員
//		
//		
//		System.out.println("捐贈物品編號");
//		System.out.println(p_2.getId());
//		System.out.println();
//		
//		System.out.println("捐贈物品");
//		System.out.println(p_2.getName());
//		System.out.println();
//		
//		System.out.println("捐贈物品價格");
//		System.out.println(p_2.getPrice());
//		System.out.println();
		
		
		
		
		
	}

}

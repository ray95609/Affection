package uuu.Affection.test;

public class TestPromotion {

	public static void main(String[] args) {
	
	String id="A123456789";
	char firstnumber=id.charAt(0);
	System.out.println(firstnumber);
	
	int firstint=firstnumber;//字元轉換成整數a=65(字碼)
	System.out.println(firstint);
	
	int firstint1=(firstnumber+'0');//字元A=65+字元0=48
	System.out.println(firstint1);
	
	int firstint2=(char)firstnumber;
	System.out.println(firstint2);
			
	char secnumber =id.charAt(1);
	System.out.println(secnumber);
	
	char thenumber=1;
	int thechar=thenumber;//1的字碼
	System.out.println(thechar);
	
	char thechar1=(char)thenumber;//1的字碼
	System.err.println(thechar1);
	
	char thecar2=(char)(thenumber+'0');//1的字碼+0的字碼=字碼被移項刪除
	System.out.println(thecar2);
	
	//看老師的~~~燒腦阿~
	
	}
}
	

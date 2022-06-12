package uuu.Affection.test;

public class TestOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//看老師的~燒腦~~
		//最重要->三元運算子(?:)
		int price =100;
		int money =1000;		
		
		System.out.println(money>price?"買":"不買");//if(money>price)
		 										  //print("買")else print("不買")	
		
		
		
		String id="B123456789";
		char char_n1=id.charAt(0);
		int n1=0;
		
		if(char_n1=='A')
		{n1=10;}
		else if(char_n1=='B')
		{n1=11;}
		else if(char_n1=='C')
		{n1=12;}
		
		
		char a ='A';
		int a_1='A';
		int A=a-'A'+10;//型別轉換
		char b=98;//b字碼=98
		
		
		int C=1;
		int B=2;
		C =(byte)(C+10+B);//強制轉型只會轉最靠近byte的變數
	
		
		
		System.out.println(a);
		System.out.println(A);
		System.out.println(a_1);
		System.out.println((char)65);//強制型別轉換//轉成65字碼
		System.out.println((char)65-'A'+10);//65轉字碼'A'-'A'+10=10
		System.out.println((char)65-'a'+10);
		System.out.println('A'-'a'+10);//65-97+10=-22
		System.out.println(b);
	}

}

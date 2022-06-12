package uuu.Affection.entity;//entity,用於儲存的類別,儲存就不會用來運算

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

import uuu.Affection.exception.AffectionAtaInvalidException;
//匯入專案用import(名稱不能跟已存專案重複)
//配合各個專案的商業環境條件,建立不同的workspace
//一個專案一個workspace
//workspace可以switch
//檢查utf-8編碼>檢查compiler java版本>檢查installed JRE
public class Customer {//類別
	//屬性只會存在，類別中，方法外
	//屬性前的accessibility(存取權限)4種範圍
	//-private(私人)->只有本屬性內能存取
	//~預設->同package內可以存取
	//#protected(加密)->同package內可以存取,不同package,除非繼承(extent)否則無法存取
	//+public(公開)->無限制皆可存取
	//存取權限public>protected>預設>private
	
	
	public Customer() {//無參考建構式//子類別不會繼承建構式
//		super();
	}

	//有參考建構式//子類別不會繼承建構式
	public Customer(String id, String name, String password)
	{	super();
		this.setId(id);;
		this.setPassword(password);
		this.setName(name);
	}
	

	
	
	private String id;//必要欄位，須符合身分證字號規則
	private String password;//必要欄位，6~20字元
	private String name;//必要欄位，2~20字元
	private String email;//必要欄位，須符合email規則
	private LocalDate birthday;//必要欄位,須年滿20歲
	private char gender;//必要欄位,性別
	//非必要欄位,才要給初值
	private String phone="";//非必要欄位,電話
	private String address="";//非必要欄位,地址
	private boolean subscribed=false;//非必要欄位,是否訂閱
	
//	public static void main(String[] args) {//方法
	
	
	
	//封裝id
	public String getId() {	return id;}
	//讀取id,回傳checkid
	public void setId(String id) {
		if(checkid(id)==true)this.id = id;
		else{throw new AffectionAtaInvalidException("身分證字號格式錯誤:"+id);}
		}
	
	//檢查id,matches=檢查[]一個位置{}重複幾次=第一碼[A~Z],第二碼[1289],[0~9]重複8次{8}
	/**
	 * 檢查身分證邏輯
	 * @param id
	 * @return
	 */
	public boolean checkid(String id) {
		//先把子母換成數字>個個數字依序乘以1.9.8.7.6.5.4.3.2.1.1>總和>除以10>餘0=true
		//1-gular expression
		if(id != null && id.length()==10 && id.matches("[A-Z][1289][0-9]{8}"))
		{//2-一個字串取出對應的數字
		char first_char=id.charAt(0);
		int first_number=0;
		if (first_char>='A' && first_char<'I')
		{first_number=first_char-'A'+10;}//型態轉換字元->轉字碼->轉整數->計算
		else if(first_char>='J' && first_char<'O')
		{first_number=first_char-'J'+18;}
		else if(first_char>='P' && first_char<'W')
		{first_number=first_char-'P'+23;}
		//switch case  只能用==+(byte,short,int,char)(左右兩邊型態相同)
		else 
			{switch(first_char) {
			case 'X':first_number=30;break;
			case 'Y':first_number=31;break;
			case 'W':first_number=32;break;
			case 'Z':first_number=33;break;
			case 'I':first_number=34;break;
			case 'O':first_number=35;break;}
			}
		//3-sum=*1,9,8,7,6,5,4,3,2,1,1
		int n1=first_number/10;
		int n2=(first_number%10)*9;
		int n3=(id.charAt(1)-'0')*8;//沒-'0'=字元序列號碼=48*8,-'0'後轉型從char->int=0*8
		int n4=(id.charAt(2)-'0')*7;
		int n5=(id.charAt(3)-'0')*6;	
		int n6=(id.charAt(4)-'0')*5;	
		int n7=(id.charAt(5)-'0')*4;
		int n8=(id.charAt(6)-'0')*3;
		int n9=(id.charAt(7)-'0')*2;
		int n10=id.charAt(8)-'0';
		int n11=id.charAt(9)-'0';
		
//		sum+ =n6*5//->sum = sum+(n6*5)
		
		int sum=n1+n2+n3+n4+n5+n6+n7+n8+n9+n10+n11;
		
//		for (int i=8,j=1;i>0 && j<9 ;i--,j++)
//		{	int n_1=0;
//			int n =id.charAt(i)*(j);}
//		int sum=n+n11+(n2*9)+n1;
//		
//		System.out.println(n);
		
		//sum%10==0
		return(sum%10==0) ;}//return條件為sum%10==0
		else {return false;}
	}
	
	public static final int MAX_PASSWORD_LENGTH=20;
	public static final int MIN_PASSWORD_LENGTH=5;
	
	public String getPassword() {return password;}
	public void setPassword(String password) {
		//strip>去除空格>再指派給自己//字串長度>5 <20
		if(password!=null && password.length()<=MAX_PASSWORD_LENGTH && (password=password.strip()).length()>MIN_PASSWORD_LENGTH)
		{this.password = password;}
		else {String errMsg =String.format("密碼輸入錯誤密碼長度%d~%d"+name, MAX_PASSWORD_LENGTH, MIN_PASSWORD_LENGTH);
			throw new AffectionAtaInvalidException("密碼格式錯誤\n姓名長度需6~20:"+password);}
		}
	
	
	public static final int MAX_NAME_LENGTH=20;
	public static final int MIN_NAME_LENGTH=2;
	
	//封裝name
	public void setName(String name) {
		if(name!=null && name.length()<=MAX_NAME_LENGTH && (name=name.strip()).length()>MIN_NAME_LENGTH)
		{this.name=name;}
		else {String errMsg =String.format("姓名輸入錯誤姓名長度%d~%d:"+name, MAX_NAME_LENGTH, MIN_NAME_LENGTH);
			throw new AffectionAtaInvalidException(errMsg);}
		}
		
	//讀取name
	public String getName() {return name;}

	public static final String EMAIL_FORMAT="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		
	public String getEmail() {return email;}
	public void setEmail(String email)
	//email的正規表達法
	{if(email!=null && email.matches(EMAIL_FORMAT))
	{this.email = email;}
	else {
		throw new AffectionAtaInvalidException("客戶email格式不正確:"+email);}
	}
	
		
	/**
	 * 計算並回傳客戶年齡
	 * 宣告方法常用於有連結此類別中其他類別物件,其他類別物件有經常出現的計算
	 * @return
	 */
	//宣告getAge()方法,並回傳
	//宣告方法常用於有連結此類別中其他類別物件
	//其他類別物件有經常出現的計算
		public int getAge() {
		int thisyear=LocalDate.now().getYear();
		
		if(getBirthday()!=null) {
			int birthyear=this.getBirthday().getYear();
			int age =thisyear-birthyear;//this.->引用自己類別屬性
			return age;}
			else{return -1;}//return到哪裡??
		}//TODO 之後改成thow exception
		/**
//		 * 老師版
//		 * @return
//		 */
//		public int getAge() {
//			//今年-這個客戶物件(this.)出生的年
//			int thisYear = LocalDate.now().getYear();
//			//System.out.println(thisYear); //for test
//			
//			if(this.birthday!=null) {
//				int birthYear = this.birthday.getYear();		
//				int age = thisYear-birthYear;		
//				return age;
//			}else {
//				System.out.println("生日為null，無法計算年齡");
//				return -1; //TODO:第13章要改成throw exception
//			}
//		}
//				
		//Overloading
		//同一類別有多個相同名稱的方法,但參數不相同
		/**
		 * 計算客戶年齡
		 * @param datetype
		 */
		public void setBirthday (String typedate){//不回傳，參考string型態的typedate當參數
		try {
			LocalDate date =LocalDate.parse(typedate);
			this.setBirthday(date);}
		//轉換string到localdate
		//TODO 之後要加上try...catch
		catch(DateTimeParseException e) { //java.time.format.DateTimeParseException
			//System.out.println("客戶生日日期資料不正確: " + dateStr );
			throw new AffectionAtaInvalidException("客戶生日日期資料不正確: " + typedate );
			}		  
		}
		
		/**
		 * 檢查客戶年齡
		 * 用於3個整數的日期輸入
		 * @param year
		 * @param month
		 * @param day
		 */
		//一個類別可以有同名的方法，但是參數要不一樣(參數個數不同or參數型別不同)  
		//set多用於void
		public void setBirthday (int sety, int setm, int setyd){
		try {
			LocalDate date =LocalDate.of(sety, setm, setyd);//轉換3個整數為localdate
			this.setBirthday(date);//告訴setBirthday參數要參考這邊的LocalDate date!
			}catch(DateTimeException e) { //java.time.DateTimeException
				//System.out.println("客戶生日日期資料不正確:" + e.getMessage());
				throw new AffectionAtaInvalidException("客戶生日資料不正確:" + e.getMessage());
			}			  
		}
		
		
		public static final int MIN_AGE=20;
		
		/**
		 * 計算年齡通知法代
		 * @param date
		 */
		public void setBirthday(LocalDate date)
		{if( Period.between(date, LocalDate.now()).getYears()>=MIN_AGE)
		{this.birthday=date;}
		else {
			throw new AffectionAtaInvalidException
			(date+"\n您未成年,請取得法定代理人同意\n已通知您的法定代理人");}
			//System.out.println("您未成年,請取得法定代理人同意\n已通知您的法定代理人");
		}
		
				
		/**
		 * Private屬性用get方法讀取
		 * 讀取生日
		 * @return
		 */
		public LocalDate getBirthday() {return this.birthday;}
		
		
		
		
		public static final char MALE='M';
		public static final char FEMALE='F';
		public static final char SECRET='S';
		
		public char getGender() {return gender;	}
		
		public void setGender(char gender) {
			if(gender==MALE|| gender==FEMALE || gender==SECRET)//char基本型別一定有值,不會是null
			{this.gender = gender;}
			else {throw new AffectionAtaInvalidException("性別格式錯誤:"+gender);}
		}
		
		public String getPhone() {return phone;	}
		
		public void setPhone(String phone) {this.phone = phone;	}
		
		public String getAddress() {return address;	}
		
		public void setAddress(String address) {this.address = address;	}
		
		public boolean isSubscribed() {	return subscribed;}
		public void setSubscribed(boolean subscribed) {	this.subscribed = subscribed;}
		
		
		/**
		 * toString
		 * 用來印出屬性資料測試
		 * 相當重要
		 */
		@Override
		public String toString() {
			return this.getClass().getSimpleName()
					+"\n客戶身分證字號:" + id 
					+ "\n密碼:" + password 
					+ "\n客戶大名:" + name 
					+ "\nemail:" + email
					+ "\n客戶誕辰:" + birthday 
					+ "\n客戶的秘密:"+ getAge()+"歲"
					+ "\n客戶性別:" + gender 
					+ "\n聯絡方式:" + phone 
					+ "\n聯絡地址:" + address
					+ "\n是否訂閱:"+ subscribed  ;
		}

		
		
		
		@Override
		public int hashCode() 
		{final int prime = 31;
		int result = 1;result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
		}
		
		
		/**
		 * equal
		 * id相同則customer相同
		 * 判斷是否為相同人別
		 * 人別判斷多為instanceof
		 */
		@Override
		public boolean equals(Object obj) {if (this == obj) 
		{return true;}
			if (!(obj instanceof Customer)) 
			{return false;}
			Customer other = (Customer) obj;
			if (id == null)
			{if (other.id != null) 
			{return false;}
			}
			else if (!id.equals(other.id))
			{return false;}
			return true;
		}

		
		
		
		
		
		
		
		
}	


	



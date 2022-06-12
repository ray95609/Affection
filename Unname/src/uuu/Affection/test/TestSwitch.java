package uuu.Affection.test;

import java.time.LocalDate;

public class TestSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weekday=LocalDate.now().plusDays(2).getDayOfWeek().getValue();
		if (weekday==1|weekday==2|weekday==4)
		{System.out.println("整天");}
		else if(weekday==3|weekday==5)
		{System.out.println("半天");}
		else {System.out.println("放假");}
		
		switch(weekday)
		{case 1: 
		 case 2:
		 case 4:
			 System.out.println("整天");break;
		 case 3:
		 case 5:
			 System.out.println("半天");break;
			  default:
			 System.out.println("放假");break;
		}
		
	}

}

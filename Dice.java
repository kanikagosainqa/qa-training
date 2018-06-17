package qaTraining;

import java.util.Random;

public class Dice {
	int sides;
	String output;
	
	public Dice(int sides){
		this.sides = sides;
	}
		
	public void roll(){
		Random random = new Random(); 
		output= result(random.nextInt(sides)+1);
    }
	
	public String check(){
		if(sides==2 || sides==4 || sides==6)
			return output;
		return ("Can't be possible");
	}
	
	public String result(int number){
		if(sides==2)
		{
			switch (number) 
			{
			case 1:return "heads";
			case 2:return "tails";	
			}	
		}
		else
		{
			switch (number) 
			{
			case 1:return "one";
			case 2:return "two";
			case 3:return "three";
			case 4:return "four";
			case 5:return "five";
			case 6:return "six";
			}	
		}
		return null;
	}
	
	public static void main(String[] args) 
	{  
		Dice dice = new Dice(3);
		dice.roll();
		System.out.println(dice.check());
	}

}
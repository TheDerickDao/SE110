import io.*;
public class TestCode
{
	public static String exceedAmount(double backerPledge, double currentAmount, double totalAmount)
	{		
		double tempVal;
		String state = "";
		
		if (backerPledge < 0.0)
		{
			backerPledge = 1.0;
		}
		if (currentAmount < 0.0)
		{
			currentAmount = 0.0;
		}
		if (totalAmount < 0.0)
		{
			totalAmount = 1.0;
		}
		
		tempVal = backerPledge + currentAmount;
		if (tempVal < totalAmount)
		{
			state = "Not Exceeded";
		}
		else if (tempVal > totalAmount)
			{
				state = "Exceeded";
			}
			else if (tempVal == totalAmount)
				{
					state = "Equal";
				}
		
		return state;
	}
	
	public static String search(String searchWord, String projectDescription)
	{
		String found;
		
		if (projectDescription.toLowerCase().contains(searchWord.toLowerCase()))
		{
			found = "Found";
		}
		else
		{
			found = "Not Found";
		}
		
		return found;
	}
	
	public static double fundingPerDay(double currentAmount, double totalAmount, int daysLeft)
	{
		double amountPerDay, tempVal;
		
		if (currentAmount < 0.0)
		{
			currentAmount = 0.0;
		}
		if (totalAmount < 0.0)
		{
			totalAmount = 1.0;
		}
		if (daysLeft < 0)
		{
			daysLeft = 0;
		}
		
		tempVal = totalAmount - currentAmount;
		if (daysLeft == 0)
		{
			amountPerDay = 0;
		}
		else
		{
			amountPerDay = tempVal / (double)daysLeft;
		}
		return amountPerDay;
	}
}
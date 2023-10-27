package com.Account.utils;

import java.time.LocalDate;
import com.Account.Core.Customer;
import com.Account.Core.Plan;
import com.Account.utils.CustInfoExc;

public class ValidationRules {
	
private static LocalDate parseDate(String dob)
{
    LocalDate date= LocalDate.parse(dob);
    return date;
}
	
public static void validateRegAmount(Plan sPlan,double rAmount)throws CustInfoExc
{
      if(sPlan.getPlanCost()>rAmount)
    	  throw new CustInfoExc("Opening Amount is lower then min. required for this plan.");
}

private static Plan planValidate(String sPlan)throws IllegalArgumentException
{
   return Plan.valueOf(sPlan.toLowerCase());	
}



public static Customer detailsCheck(String fName, String lName, String email, String password, double rAmount,
		String dob,String sPlan)throws IllegalArgumentException,CustInfoExc
{
	Plan splan=planValidate(sPlan);
	
    validateRegAmount(splan,rAmount);
	
	LocalDate date=parseDate(dob);
	
   return new Customer(fName,lName,email,password,rAmount,date,splan);	
}
	
	
}
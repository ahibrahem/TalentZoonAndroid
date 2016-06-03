package com.iti.ahmed.talentzone;

/**
 * Created by ahmed on 19/05/2016.
 */
public class Validation {


    public static Boolean ckeckEmpty(String input)
    {
        if(input.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public static Boolean checkLengthName(String input)
    {
        if(input.length()>=3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean checkLengthPass(String input)
    {
        if(input.length()>=6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}

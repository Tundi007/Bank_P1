public class CentralBank implements IBank
{

    private String accountNumber_String;

    private String cardNumber_String;

    private String cardDate_Date;

    private String cvv2_String;

    public String GetAccountNumber_Method()
    {

        if(Checkpoint.CardNumberValidation_Method(accountNumber_String))
            return accountNumber_String;
        
        return "";

    }

    public Boolean SetAccountNumber_Method(String accountNumber_String)
    {

        if(Checkpoint.AccountNumberValidation_Method(accountNumber_String))
            return false;

        this.accountNumber_String = accountNumber_String;

        return true;

    }

    public String GetCardNumber_Method()
    {

        if(cardNumber_String != null)
            return cardNumber_String;
        
        return "";

    }

    public Boolean SetCardNumber_Method(String cardNumber_String)
    {


        if(cardNumber_String.length() == 16)
            return false;

        this.cardNumber_String = cardNumber_String;

        return true;

    }

    public static class Checkpoint
    {

        public static Boolean CardNumberValidation_Method(String cardNumber_String){return false;}

        public static Boolean AccountNumberValidation_Method(String accountNumber_String){return false;}

        public static Boolean CardDateValidation_Method(String cardDate_String){return false;}

        public static Boolean Cvv2Validation_Method(String cvv2_String){return false;}

    }
    
    public String GetCardDate_Method(){return "";}

    public String GetCvv2_Method(){return "";}

    public Boolean SetCardDate_Method(String cardDate_String){return false;}

    public Boolean SetCvv2_Method(String cvv2_String){return false;}

    
}

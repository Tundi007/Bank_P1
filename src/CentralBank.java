import java.time.LocalDate;

abstract class CentralBank implements IBank
{

    char[][] bankDefinedAccountNumber_String;

    String bankDefinedCardNumber_String;

    String accountNumber_String = "";

    String cardNumber_String = "";

    LocalDate cardDate_LocalDate;

    String cvv2_String = "";

    @Override
    public String GetAccountNumber_Method()
    {

        if(accountNumber_String.isBlank())
            return "";

        return accountNumber_String;

    }

    @Override
    public String GetCardNumber_Method()
    {

        if(cardNumber_String.isBlank())        
            return "";

        return cardNumber_String;

    }

    
    @Override
    public String GetCardDate_Method()
    {

        if(cardDate_LocalDate == null)        
            return "";

        return cardDate_LocalDate.toString();

    }

    @Override
    public String GetCvv2_Method()
    {

        if(cvv2_String.isBlank())        
            return "";

        return cvv2_String;

    }

    @Override
    public int SetAccountNumber_Method(String accountNumber_String)
    {

        accountNumber_String = accountNumber_String.trim();

        if(Checkpoint.AccountNumberValidation_Method(accountNumber_String) == 1)
            return 1;

        if(Checkpoint.BankDefined.AccountNumberValidation_Method(accountNumber_String) == 1)
            return 1;

        this.accountNumber_String = accountNumber_String;

        return 0;

    }

    @Override
    public int SetCardNumber_Method(String cardNumber_String)
    {

        cardNumber_String = cardNumber_String.trim();

        if(Checkpoint.CardNumberValidation_Method(cardNumber_String) == 1)
            return 1;

        if(Checkpoint.BankDefined.CardNumberValidation_Method(cardNumber_String) == 1)
            return 1;

        this.cardNumber_String = cardNumber_String;

        return 0;

    }

    @Override
    public int SetCardDate_Method(String cardDate_String)
    {

        cardDate_String = cardDate_String.trim();

        LocalDate tempCardDate_LocalDate = LocalDate.parse(cardDate_String);//yyyy-dd-mm

        if(tempCardDate_LocalDate == null | Checkpoint.CardDateValidation_Method(tempCardDate_LocalDate) == 1)
            return 1;

        this.cardDate_LocalDate = tempCardDate_LocalDate;

        return 0;

    }

    @Override
    public int SetCvv2_Method(String cvv2_String)
    {

        cvv2_String = cvv2_String.trim();

        if(Checkpoint.Cvv2Validation_Method(cvv2_String) == 1)
            return 1;

        this.cvv2_String = cvv2_String;

        return 0;

    }

    protected static class Checkpoint extends IBank.Checkpoint
    {

        protected static class BankDefined
        {

            protected static int AccountNumberValidation_Method(String accountNumber_String)
            {
            
                return 0;
            
            }
    
            protected static int CardNumberValidation_Method(String cardNumber_String)
            {
                
                return 0;
            
            }
        
        }

    }
    
}

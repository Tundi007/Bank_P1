import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CentralBank implements IBank
{

    private final int userSession_Int;

    CentralBank(int userSession_Int)
    {

        this.userSession_Int = userSession_Int;

    }

    private String accountNumber_String;

    private String cardNumber_String;

    private String cardDate_String;

    private String cvv2_String;

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

        if(cardDate_String.isBlank())        
            return "";

        return cardDate_String;

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

        this.accountNumber_String = accountNumber_String;

        return 0;

    }

    @Override
    public int SetCardNumber_Method(String cardNumber_String)
    {

        cardNumber_String = cardNumber_String.trim();

        if(Checkpoint.CardNumberValidation_Method(cardNumber_String) == 1)
            return 1;

        this.cardNumber_String = cardNumber_String;

        return 0;

    }

    @Override
    public int SetCardDate_Method(String cardNumber_String)
    {

        cardNumber_String = cardNumber_String.trim();

        if(Checkpoint.CardDateValidation_Method(cardNumber_String) == 1)
            return 1;

        this.cardNumber_String = cardNumber_String;

        return 0;

    }

    @Override
    public int SetCvv2_Method(String cardNumber_String)
    {

        cardNumber_String = cardNumber_String.trim();

        if(Checkpoint.Cvv2Validation_Method(cardNumber_String) == 1)
            return 1;

        this.cardNumber_String = cardNumber_String;

        return 0;

    }

    private static class Checkpoint
    {

        private static int AccountNumberValidation_Method(String accountNumber_String)
        {

            if(accountNumber_String.length() != 10)
                return 1;

            return 0;
        
        }

        private static int CardNumberValidation_Method(String cardNumber_String)
        {

            if(cardNumber_String.length() != 16)
                return 1;

            if(!String.format("%1$c%2$c%3$c%4$c",
                cardNumber_String.charAt(0),
                cardNumber_String.charAt(1),
                cardNumber_String.charAt(2),
                cardNumber_String.charAt(3)).equals("5051"))
                return 1;

            return 0;

        }

        private static abstract class BankDefined
        {

            public abstract int BankDefinedAccountNumberValidation_Method(String accountNumber_String);
    
            public abstract int BankDefinedCardNumberValidation_Method(String cardNumber_String);
        
        }

        private static int CardDateValidation_Method(String cardDate_String)
        {

            if(Period.of(5, 0, 0).minus(Period.between(
                LocalDate.parse(cardDate_String,DateTimeFormatter.ofPattern("yyyy/mm/dd")),
                LocalDate.now())).isNegative())
                return 1;

            return 0;
            
        }

        private static int Cvv2Validation_Method(String cvv2_String)
        {

            if(cvv2_String.length() != 3 & cvv2_String.length() != 4)
                return 1;
            
            return 0;
        
        }

    }
    
}

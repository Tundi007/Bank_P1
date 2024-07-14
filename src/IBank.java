
import java.time.LocalDate;
import java.time.Period;

interface  IBank
{

    String GetAccountNumber_Method();

    String GetCardNumber_Method();

    String GetCardDate_Method();

    String GetCvv2_Method();

    int SetAccountNumber_Method(String accountNumber_String);

    int SetCardNumber_Method(String cardNumber_String);

    int SetCardDate_Method(String cardDate_String);

    int SetCvv2_Method(String cvv2_String);
    
    static class Checkpoint
    {

        protected static int AccountNumberValidation_Method(String accountNumber_String)
        {

            if(accountNumber_String.length() != 10)
                return 1;

            return 0;
        
        }

        protected static int CardNumberValidation_Method(String cardNumber_String)
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

        protected static int CardDateValidation_Method(LocalDate tempCardDate_LocalDate)
        {

            Period CardDate_Period;

            if((Period.of(5, 0, 0).minus(CardDate_Period = Period.between(
                tempCardDate_LocalDate,
                LocalDate.now()))).isNegative() |
                CardDate_Period.isNegative())
                return 1;

            return 0;
            
        }

        protected static int Cvv2Validation_Method(String cvv2_String)
        {

            if(cvv2_String.length() != 3 & cvv2_String.length() != 4)
                return 1;
            
            return 0;
        
        }

    }
    
}
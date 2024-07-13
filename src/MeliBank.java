
public class MeliBank extends CentralBank
{

    public int userSession_Int;

    public MeliBank(int userSession_Int)
    {

        this.userSession_Int = userSession_Int;

    }

    public static class Checkpoint extends CentralBank.Checkpoint
    {

        public static class BankDefined
        {

            public static int BankDefinedAccountNumberValidation_Method(String accountNumber_String)
            {
    
                return 1;
    
            }

            public static int BankDefinedCardNumberValidation_Method(String cardNumber_String)
            {
    
                return 1;
    
            }

        }

    }

}

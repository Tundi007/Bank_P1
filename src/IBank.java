interface  IBank
{

    public String GetAccountNumber_Method();

    public String GetCardNumber_Method();

    public String GetCardDate_Method();

    public String GetCvv2_Method();

    public int SetAccountNumber_Method(String accountNumber_String);

    public int SetCardNumber_Method(String cardNumber_String);

    public int SetCardDate_Method(String cardDate_String);

    public int SetCvv2_Method(String cvv2_String);
    
    public static abstract class Checkpoint
    {

        public abstract int AccountNumberValidation_Method(String accountNumber_String);

        public abstract int CardNumberValidation_Method(String cardNumber_String);

        public abstract int CardDateValidation_Method(String cardDate_String);

        public abstract int Cvv2Validation_Method(String cvv2_String);

    }
    
}
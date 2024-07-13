interface  IBank
{

    public String GetAccountNumber_Method();

    public String GetCardNumber_Method();

    public String GetCardDate_Method();

    public String GetCvv2_Method();

    public Boolean SetAccountNumber_Method(String accountNumber_String);

    public Boolean SetCardNumber_Method(String cardNumber_String);

    public Boolean SetCardDate_Method(String cardDate_String);

    public Boolean SetCvv2_Method(String cvv2_String);
    
}

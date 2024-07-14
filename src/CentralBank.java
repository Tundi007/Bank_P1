import java.time.LocalDate;

abstract class CentralBank implements IBank
{

    private static final char[][] definedAccountNumber_2DChar = {"".toCharArray(),"".toCharArray()};

    private static final char[] definedCardNumber_ArrayChar = "".toCharArray();

    private int accountType_Int = 0;

    private String accountNumber_String = "";

    private String cardNumber_String = "";

    private LocalDate cardDate_LocalDate;

    private String cvv2_String = "";

    @Override
    public final String GetAccountNumber_Method()
    {

        if (accountNumber_String.isBlank())
            return "";

        return accountNumber_String;

    }

    @Override
    public final String GetCardNumber_Method()
    {

        if (cardNumber_String.isBlank())        
            return "";

        return cardNumber_String;

    }

    
    @Override
    public final String GetCardDate_Method()
    {

        if (cardDate_LocalDate == null)        
            return "";

        return cardDate_LocalDate.toString();

    }

    @Override
    public final String GetCvv2_Method()
    {

        if (cvv2_String.isBlank())        
            return "";

        return cvv2_String;

    }

    @Override
    public final int SetAccountNumber_Method(String accountNumber_String)
    {

        accountNumber_String = accountNumber_String.trim();

        if (Checkpoint.AccountNumberValidation_Method(accountNumber_String) == 1)
            return 1;

        if ((accountType_Int = Checkpoint.BankDefined.AccountNumberValidation_Method(accountNumber_String.toCharArray())) == 0)
            return 2;

        this.accountNumber_String = accountNumber_String;

        return accountType_Int;

    }

    @Override
    public final int SetCardNumber_Method(String cardNumber_String)
    {

        cardNumber_String = cardNumber_String.trim();

        if (Checkpoint.CardNumberValidation_Method(cardNumber_String) == 1)
            return 1;

        if (Checkpoint.BankDefined.CardNumberValidation_Method(cardNumber_String.toCharArray()) == 1)
            return 2;

        this.cardNumber_String = cardNumber_String;

        return 0;

    }

    @Override
    public final int SetCardDate_Method(String cardDate_String)
    {

        cardDate_String = cardDate_String.trim();

        LocalDate tempCardDate_LocalDate = LocalDate.parse(cardDate_String);//yyyy-dd-mm

        if (tempCardDate_LocalDate == null | Checkpoint.CardDateValidation_Method(tempCardDate_LocalDate) == 1)
            return 1;

        this.cardDate_LocalDate = tempCardDate_LocalDate;

        return 0;

    }

    @Override
    public final int SetCvv2_Method(String cvv2_String)
    {

        cvv2_String = cvv2_String.trim();

        if (Checkpoint.Cvv2Validation_Method(cvv2_String) == 1)
            return 1;

        this.cvv2_String = cvv2_String;

        return 0;

    }

    protected static class Checkpoint extends IBank.Checkpoint
    {

        protected static class BankDefined
        {

            protected final static int AccountNumberValidation_Method(char[] accountNumber_ArrayChar)
            {

                for(int definedNumber_Int = 0; definedNumber_Int < definedAccountNumber_2DChar.length; definedNumber_Int++)
                {

                    switch (definedAccountNumber_2DChar[definedNumber_Int].length)
                    {

                        case 3 ->
                        {

                            if (String.format("%1$c%2$c%3$c",
                                    accountNumber_ArrayChar[4],
                                    accountNumber_ArrayChar[5],
                                    accountNumber_ArrayChar[6]
                                ).equals(
                                    String.format("%1$c%2$c%3$c",
                                        definedAccountNumber_2DChar[definedNumber_Int][0],
                                        definedAccountNumber_2DChar[definedNumber_Int][1],
                                        definedAccountNumber_2DChar[definedNumber_Int][2]
                                    )
                                )
                            )
                                return definedNumber_Int+1;
                            
                        }

                        case 4 ->
                        {

                            if (String.format("%1$c%2$c%3$c%4$c",
                                    accountNumber_ArrayChar[4],
                                    accountNumber_ArrayChar[5],
                                    accountNumber_ArrayChar[6],
                                    accountNumber_ArrayChar[7]
                                ).equals(
                                    String.format("%1$c%2$c%3$c%4$c",
                                        definedAccountNumber_2DChar[definedNumber_Int][0],
                                        definedAccountNumber_2DChar[definedNumber_Int][1],
                                        definedAccountNumber_2DChar[definedNumber_Int][2],
                                        definedAccountNumber_2DChar[definedNumber_Int][3]
                                    )
                                )
                            )
                                return definedNumber_Int+1;
                            
                        }

                    }

                }
            
                return 0;
            
            }
    
            protected final static int CardNumberValidation_Method(char[] cardNumber_String)
            {

                if (!String.format("%1$c%2$c%3$c%4$c",
                                cardNumber_String[4],
                                cardNumber_String[5],
                                cardNumber_String[6],
                                cardNumber_String[7]
                                ).equals(
                                    String.format("%1$c%2$c%3$c%4$c",
                                        definedCardNumber_ArrayChar[0],
                                        definedCardNumber_ArrayChar[1],
                                        definedCardNumber_ArrayChar[2],
                                        definedCardNumber_ArrayChar[3]
                                    )
                                )
                            )
                    return 1;
                
                return 0;
            
            }
        
        }

    }
    
}


import java.time.LocalDate;
import java.time.Period;

abstract class CentralBank
{

    private final char[][] definedAccountNumber_2DChar;

    private final char[] definedCardNumber_ArrayChar;

    private final String[] accountType_ArrayString;

    private int accountType_Int = -1;

    private String accountNumber_String = "";

    private String cardNumber_String = "";

    private LocalDate cardDate_LocalDate;

    private String cvv2_String = "";

    private final double[] accountInterest_ArrayInt;

    protected CentralBank(String[] accountType_ArrayString, char[][] definedAccountNumber_2DChar, char[] definedCardNumber_ArrayChar,double[]accountInterest_ArrayInt)
    {

        this.accountInterest_ArrayInt = accountInterest_ArrayInt;

        this.definedAccountNumber_2DChar = definedAccountNumber_2DChar;

        this.definedCardNumber_ArrayChar = definedCardNumber_ArrayChar;

        this.accountType_ArrayString = accountType_ArrayString;

    }

    public final String GetAccountType_ArrayString()
    {

        if(accountType_Int == -1)
            return "";

        return accountType_ArrayString[accountType_Int];

    }

    public final String GetAccountNumber_Method()
    {

        if (accountNumber_String.isBlank())
            return "";

        return accountNumber_String;

    }

    public final String GetCardNumber_Method()
    {

        if (cardNumber_String.isBlank())        
            return "";

        return cardNumber_String;

    }

    
    public final String GetCardDate_Method()
    {

        if (cardDate_LocalDate == null)
            return "";

        return cardDate_LocalDate.toString();

    }

    public final String GetCvv2_Method()
    {

        if (cvv2_String.isBlank())        
            return "";

        return cvv2_String;

    }

    public int SetAccountNumber_Method(String accountNumber_String)
    {

        accountNumber_String = accountNumber_String.trim();

        if (Checkpoint.AccountNumberValidation_Method(accountNumber_String) == 1)
            return 1;

        if ((accountType_Int = Checkpoint.BankDefined.AccountNumberValidation_Method(accountNumber_String.toCharArray(),definedAccountNumber_2DChar)) == 0)
            return 2;

        this.accountNumber_String = accountNumber_String;

        return accountType_Int;

    }

    public int SetCardNumber_Method(String cardNumber_String)
    {

        cardNumber_String = cardNumber_String.trim();

        if (Checkpoint.CardNumberValidation_Method(cardNumber_String) == 1)
            return 1;

        if (Checkpoint.BankDefined.CardNumberValidation_Method(cardNumber_String.toCharArray(),definedCardNumber_ArrayChar) == 1)
            return 2;

        this.cardNumber_String = cardNumber_String;

        return 0;

    }

    public final int SetCardDate_Method(String cardDate_String)
    {

        cardDate_String = cardDate_String.trim();

        LocalDate tempCardDate_LocalDate = LocalDate.parse(cardDate_String);//yyyy-dd-mm

        if (tempCardDate_LocalDate == null | Checkpoint.CardDateValidation_Method(tempCardDate_LocalDate) == 1)
            return 1;

        this.cardDate_LocalDate = tempCardDate_LocalDate;

        return 0;

    }

    public final int SetCvv2_Method(String cvv2_String)
    {

        cvv2_String = cvv2_String.trim();

        if (Checkpoint.Cvv2Validation_Method(cvv2_String) == 1)
            return 1;

        this.cvv2_String = cvv2_String;

        return 0;

    }
    
    abstract private static class Checkpoint
    {

        private static int AccountNumberValidation_Method(String accountNumber_String)
        {

            if (accountNumber_String.length() != 10)
                return 1;

            return 0;
        
        }

        private static int CardNumberValidation_Method(String cardNumber_String)
        {

            if (cardNumber_String.length() != 16)
                return 1;

            if (!String.format("%1$c%2$c%3$c%4$c",
                cardNumber_String.charAt(0),
                cardNumber_String.charAt(1),
                cardNumber_String.charAt(2),
                cardNumber_String.charAt(3)).equals("5051"))
                return 1;

            return 0;

        }

        private static int CardDateValidation_Method(LocalDate tempCardDate_LocalDate)
        {

            Period CardDate_Period;

            if ((Period.of(5, 0, 0).minus(CardDate_Period = Period.between(                
                LocalDate.now()
                ,tempCardDate_LocalDate))).isNegative() |
                CardDate_Period.isNegative())
                return 1;

            return 0;
            
        }

        private static int Cvv2Validation_Method(String cvv2_String)
        {

            if (cvv2_String.length() != 3 & cvv2_String.length() != 4)
                return 1;
            
            return 0;
        
        }

        private abstract static class BankDefined
        {

            private final static int AccountNumberValidation_Method(char[] accountNumber_ArrayChar,char[][]definedAccountNumber_2DChar)
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
    
            private final static int CardNumberValidation_Method(char[] cardNumber_String,char[]definedCardNumber_ArrayChar)
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
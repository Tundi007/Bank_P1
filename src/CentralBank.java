
import java.time.LocalDate;
import java.time.Period;

abstract class CentralBank
{

    private final char[][] definedAccountID_2DChar;

    private final char[] definedCardID_ArrayChar;

    private final String[] accountTypes_ArrayString;

    private final double[] accountInterest_ArrayInt;

    private int accountType_Int = -1;

    private String accountID_String = "";

    private String cardID_String = "";

    private LocalDate cardDate_LocalDate;

    private String cvv2_String = "";

    protected CentralBank(String[] accountTypes_ArrayString, char[][] definedAccountID_2DChar, char[] definedCardID_ArrayChar,double[]accountInterest_ArrayInt)
    {

        this.accountInterest_ArrayInt = accountInterest_ArrayInt;

        this.definedAccountID_2DChar = definedAccountID_2DChar;

        this.definedCardID_ArrayChar = definedCardID_ArrayChar;

        this.accountTypes_ArrayString = accountTypes_ArrayString;

    }

    public final String GetAccountTypes_ArrayString()
    {

        if(accountType_Int == -1)
            return "";

        return accountTypes_ArrayString[accountType_Int];

    }

    public final double GetAccountInterest_ArrayString()
    {

        if(accountType_Int == -1)
            return -1;

        return accountInterest_ArrayInt[accountType_Int];

    }

    public final String GetAccountID_Method()
    {

        if (accountID_String.isBlank())
            return "";

        return accountID_String;

    }

    public final String GetCardID_Method()
    {

        if (cardID_String.isBlank())        
            return "";

        return cardID_String;

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

    public int SetAccountID_Method(String accountID_String)
    {

        accountID_String = accountID_String.trim();

        if (Checkpoint.AccountIDValidation_Method(accountID_String) == 1)
            return 1;

        if ((accountType_Int = Checkpoint.BankDefined.AccountIDValidation_Method(accountID_String.toCharArray(),definedAccountID_2DChar)) == 0)
            return 2;

        this.accountID_String = accountID_String;

        return accountType_Int;

    }

    public int SetCardID_Method(String cardID_String)
    {

        cardID_String = cardID_String.trim();

        if (Checkpoint.CardIDValidation_Method(cardID_String) == 1)
            return 1;

        if (Checkpoint.BankDefined.CardIDValidation_Method(cardID_String.toCharArray(),definedCardID_ArrayChar) == 1)
            return 2;

        this.cardID_String = cardID_String;

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

        private static int AccountIDValidation_Method(String accountID_String)
        {

            if (accountID_String.length() != 10)
                return 1;

            return 0;
        
        }

        private static int CardIDValidation_Method(String cardID_String)
        {

            if (cardID_String.length() != 16)
                return 1;

            if (!String.format("%1$c%2$c%3$c%4$c",
                cardID_String.charAt(0),
                cardID_String.charAt(1),
                cardID_String.charAt(2),
                cardID_String.charAt(3)).equals("5051"))
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

            private final static int AccountIDValidation_Method(char[] accountID_ArrayChar,char[][]definedAccountID_2DChar)
            {

                for(int definedNumber_Int = 0; definedNumber_Int < definedAccountID_2DChar.length; definedNumber_Int++)
                {

                    switch (definedAccountID_2DChar[definedNumber_Int].length)
                    {

                        case 3 ->
                        {

                            if (String.format("%1$c%2$c%3$c",
                                    accountID_ArrayChar[4],
                                    accountID_ArrayChar[5],
                                    accountID_ArrayChar[6]
                                ).equals(
                                    String.format("%1$c%2$c%3$c",
                                        definedAccountID_2DChar[definedNumber_Int][0],
                                        definedAccountID_2DChar[definedNumber_Int][1],
                                        definedAccountID_2DChar[definedNumber_Int][2]
                                    )
                                )
                            )
                                return definedNumber_Int+1;
                            
                        }

                        case 4 ->
                        {

                            if (String.format("%1$c%2$c%3$c%4$c",
                                    accountID_ArrayChar[4],
                                    accountID_ArrayChar[5],
                                    accountID_ArrayChar[6],
                                    accountID_ArrayChar[7]
                                ).equals(
                                    String.format("%1$c%2$c%3$c%4$c",
                                        definedAccountID_2DChar[definedNumber_Int][0],
                                        definedAccountID_2DChar[definedNumber_Int][1],
                                        definedAccountID_2DChar[definedNumber_Int][2],
                                        definedAccountID_2DChar[definedNumber_Int][3]
                                    )
                                )
                            )
                                return definedNumber_Int+1;
                            
                        }

                    }

                }
            
                return 0;
            
            }
    
            private final static int CardIDValidation_Method(char[] cardID_String,char[]definedCardID_ArrayChar)
            {

                if (!String.format("%1$c%2$c%3$c%4$c",
                                cardID_String[4],
                                cardID_String[5],
                                cardID_String[6],
                                cardID_String[7]
                                ).equals(
                                    String.format("%1$c%2$c%3$c%4$c",
                                        definedCardID_ArrayChar[0],
                                        definedCardID_ArrayChar[1],
                                        definedCardID_ArrayChar[2],
                                        definedCardID_ArrayChar[3]
                                    )
                                )
                            )
                    return 1;
                
                return 0;
            
            }
        
        }

    }
    
}
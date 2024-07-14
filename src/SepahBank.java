public class SepahBank extends CentralBank
{

    private int userSession_Int;

    private static final char[][] definedAccountNumber_2Dchar = {"200".toCharArray(),"018".toCharArray()};

    private static final String definedCardNumber_String = "6219";

    public SepahBank(int userSession_Int)
    {

        this.userSession_Int = userSession_Int;

    }

    protected static class Checkpoint extends CentralBank.Checkpoint
    {
        public static class BankDefined extends CentralBank.Checkpoint.BankDefined
        {
        }
    }
    
}

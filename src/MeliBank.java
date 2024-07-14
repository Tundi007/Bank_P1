public class MeliBank extends CentralBank
{

    private final int userSession_Int;

    private static final char[][] definedAccountNumber_2Dchar = {"0200".toCharArray(),"110".toCharArray()};

    private static final String definedCardNumber_String = "4891";

    public MeliBank(int userSession_Int)
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

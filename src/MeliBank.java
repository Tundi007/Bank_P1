public class MeliBank extends CentralBank
{

    private int userSession_Int;

    public MeliBank(int userSession_Int)
    {

        this.userSession_Int = userSession_Int;

        bankDefinedAccountNumber_String[0] = "0200".toCharArray();

        bankDefinedAccountNumber_String[1] = "110".toCharArray();

        bankDefinedCardNumber_String = "4891";

    }

    protected static class Checkpoint extends CentralBank.Checkpoint
    {
        public static class BankDefined extends CentralBank.Checkpoint.BankDefined
        {

        }

    }


}

public class SepahBank extends CentralBank
{

    public int userSession_Int;

    public SepahBank(int userSession_Int)
    {

        this.userSession_Int = userSession_Int;

        bankDefinedAccountNumber_String[0] = "200".toCharArray();

        bankDefinedAccountNumber_String[1] = "018".toCharArray();

        bankDefinedCardNumber_String = "6219";

    }
    
}

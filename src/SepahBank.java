public class SepahBank extends CentralBank
{

    private final int userSession_Int;

    public SepahBank(int userSession_Int)
    {

        super(new String[]{"GoodWill Depost","Default Deposit"},new char[][]{"200".toCharArray(),"018".toCharArray()},"6219".toCharArray(),new double[]{0.20,0.15});

        this.userSession_Int = userSession_Int;

    }
    
}

public class MelliBank extends CentralBank
{

    private final int userSession_Int;

    public MelliBank(int userSession_Int)
    {

        super(new String[]{"Long Term","Short Term"},new char[][]{"0200".toCharArray(),"110".toCharArray()},"4891".toCharArray(),new double[]{0.10,0.08});

        this.userSession_Int = userSession_Int;

    }

}

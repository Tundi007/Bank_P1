class App
{

    public static void main(String[] args) throws Exception
    {

        String error_String = "";

        int option_Int;

        while((option_Int = UI.KeyToString_Method("Welcome, Select Your Bank", new String[]{"Meli Bank","Sepah Bank"},error_String)) != -1)
        {

            error_String = "";

            switch (option_Int)
            {
             
                case 0 ->
                    Exit();
                
                case 1 ->
                {


                    
                }

                case 2 ->
                {
                    
                }

                default ->
                    error_String = "Input Not Defined";
            }

        }

    }

    private static void MelliBank_Method()
    {

    }

    private static void SepahBank_Method()
    {

    }

    private static void Exit()
    {

        System.out.println("Thanks For Using Our Service!");

        Sleep_Method(1000);

        System.exit(0);
    }

    private static void Sleep_Method(int milisecnods_Int)
    {  

        try
        {

            Thread.sleep(milisecnods_Int);            
            
        } catch (InterruptedException e)
        {

            System.out.println(e.getMessage());

        }
        
    }

}

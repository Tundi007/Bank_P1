class App
{

    public static void main(String[] args) throws Exception
    {

        String error_String = "";

        while(true)
        {            

            switch (UI.Menu_Method("Welcome, Select Your Bank:", new String[]{"Meli Bank","Sepah Bank"},error_String))
            {
             
                case 0 ->
                    Exit();
                
                case 1 ->
                {

                    error_String = "";

                    
                    
                }

                case 2 ->
                {

                    error_String = "";


                    
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

import java.time.LocalTime;

public class Interest {
    
    public static void Interest_Method()
    {

        while(true)
        {

            try
            {            

                int hour_Int = LocalTime.now().getHour();
                
                int minute_Int = LocalTime.now().getMinute()+1;

                minute_Int /= 10;

                minute_Int *= 10;

                int millisecnods_Int = Math.abs((hour_Int*60 + minute_Int)*60000 - (12*60+30)*60000);

                Thread.sleep(millisecnods_Int);

                //do interest
                
            }catch (InterruptedException e)
            {

                System.out.println(e.getMessage());
                
            }
    
        }

    }
    
}

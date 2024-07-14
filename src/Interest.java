import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

class Interest{
    
    protected static void Interest_Method()
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

                try
                {

                    Apply_Method();
                    
                }catch (ClassNotFoundException | SQLException e)
                {

                    System.out.println(e.getMessage());

                }
                
            }catch (InterruptedException e)
            {

                System.out.println(e.getMessage());
                
            }
    
        }   

    }

    private static void Apply_Method() throws ClassNotFoundException, SQLException
    {

        Class.forName("oracle.jdbc.driver.OracleDriver"); 

        try(Connection dataBase_Connection = DriverManager.getConnection("url","user","password");
            Statement query_Statement = dataBase_Connection.createStatement();
            ResultSet return_ResultSet = query_Statement.executeQuery("select * from emp"))
        {   
            
            while(return_ResultSet.next())
            {
                
                System.out.println(return_ResultSet.getInt(1)+" "+return_ResultSet.getString(2));
                
            }
        
        }

    }
    
}

import java.util.Scanner;

public final class UI
{

    public static int Menu_Method(String menuTitle_String,String[] menuItems_ArrayString, String error_String) throws NegativeArraySizeException, ClassNotFoundException
    {

        ClearScreen_Method();

        String userInput_String;

        System.out.println("Enter The Number Of The Option You Wish To Choose, Enter \"x\" To Close");

        System.out.println(menuTitle_String);

        for (int items_Int = 0; items_Int < menuItems_ArrayString.length; items_Int++)
        {

            System.out.print(items_Int+1);

            System.out.print(". ");

            System.out.println(menuItems_ArrayString[items_Int]);
            
        }

        System.out.println(error_String);
        
        try (Scanner myUI_Scanner = new Scanner(System.in))
        {

            userInput_String = myUI_Scanner.nextLine();

        }

        userInput_String = userInput_String.trim().toLowerCase();

        if(userInput_String.equals("x"))
            return 0;

        for (int items_Int = 0; items_Int < menuItems_ArrayString.length; items_Int++)
        {

            if(userInput_String.equals(String.format("%d", items_Int)))
            {

                return (1 + items_Int);

            }
            
        }

        return menuItems_ArrayString.length+1;

    }
      
    public static String Insert_Method(String menuTitle_String,String[] menuItems_ArrayString, String error_String) throws NegativeArraySizeException, ClassNotFoundException
    {

        return "";

    }

    private static void ClearScreen_Method()
    {  
        
        System.out.print("\033[H\033[2J"); 

        System.out.flush();  

    }
    
}

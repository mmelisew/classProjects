import java.util.Scanner; 
import java.sql.*;

public class Section
{

   public static String insert()
   {
      Scanner kbd = new Scanner(System.in);
     
      
      System.out.println("Please enter values to INSERT into the Section database:");
      

      System.out.print("Please Enter CourseID: ");
      String CourseID = kbd.next();
      System.out.print("Please Enter Section number: ");
      int Section = kbd.nextInt();
      System.out.print("Please Enter Start date using mm/dd/yyyy Format: ");
      String StartDate = kbd.next();
      System.out.print("Please Enter End date using mm/dd/yyyy Format: ");
      String EndDate = kbd.next();
      System.out.print("Please Enter Capacity of the section: ");
      int Capacity = kbd.nextInt();
      
      System.out.println();
      String sql = "INSERT into Section " +
                   "VALUES('"+CourseID+"',"+Section+",'"+StartDate+"','"+EndDate +"'," + Capacity+")";
      
      return sql;     
   }
   public static void retrieve()
   {
     Scanner kbd = new Scanner(System.in);
     Connection conn = null;
     try
      {
        conn = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_mmmengsi?serverTimezone=UTC&" +
                                            "user=db_Spr19_mmmengsi&password=mmmengsi");  
                                                                                  
           Statement stmt = conn.createStatement(); 

           String sql = "SELECT * FROM Section";
           ResultSet file = stmt.executeQuery(sql);
      
            System.out.println("===========================================================================================================================================");
            System.out.printf("%20s %20s %20s %20s %20s", "CourseID", "Section", "StartDate", "EndDate", "Capacity");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
           
            while(file.next())
            {
               String CourseID = file.getString("CourseID");
               int Section = file.getInt("Section");
               String StartDate = file.getString("StartDate");
               String EndDate = file.getString("EndDate");
               int Capacity = file.getInt("Capacity");
               
         
               System.out.format("%20s %20s %20s %20s %20s", CourseID, Section, StartDate, EndDate, Capacity);
               System.out.println();             
            }
            System.out.println("===========================================================================================================================================");
            file.close();
            System.out.println();
         }         
         catch(SQLException ex)
         {
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState: "+ex.getSQLState());
            System.out.println("VendorError: "+ex.getErrorCode());
         }         
   }
   
   public static String delete()
   {
      Scanner kbd = new Scanner(System.in); 
      
      System.out.print("Please Enter CourseID: ");
      String CourseID = kbd.next();
      System.out.print("Please Enter Section Number: ");
      int Section = kbd.nextInt();   
      System.out.println();
        
      String delValue = "('"+CourseID+"',"+Section+")";
      return delValue;   
   }

}
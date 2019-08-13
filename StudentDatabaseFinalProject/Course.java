import java.util.Scanner; 
import java.sql.*;

public class Course
{

   public static String insert()
   {
      Scanner kbd = new Scanner(System.in);
     
      
      System.out.println("Please enter values to INSERT into the Course database:");
      
      System.out.print("Please Enter CourseID: ");
      String CourseID = kbd.next();
      System.out.print("Please Enter Course name: ");
      String courseName = kbd.next();
      System.out.print("Please Enter The Course cost: ");
      double Cost = kbd.nextDouble();
      
      System.out.println();
      String sql = "INSERT into Course " +
                   "VALUES('"+CourseID+"','"+courseName+"','"+Cost+"'" +")";
      
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

           String sql = "SELECT * FROM Course";
           ResultSet file = stmt.executeQuery(sql);
      
            System.out.println("===========================================================================================================================================");
            System.out.printf("%20s %20s %20s", "CourseID", "courseName", "Cost");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
           
            while(file.next())
            {
               String CourseID = file.getString("CourseID");
               String courseName = file.getString("courseName");
               double Cost = file.getDouble("Cost");
         
               System.out.format("%20s %20s %20s", CourseID, courseName, Cost);
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
      System.out.println();
        
      return CourseID;   
   }

}
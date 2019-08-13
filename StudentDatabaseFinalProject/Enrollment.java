import java.util.Scanner; 
import java.sql.*;

public class Enrollment
{

   public static String insert()
   {
      Scanner kbd = new Scanner(System.in);
     
      
      System.out.println("Please enter values to INSERT into the Enrollment database:");
      
      System.out.print("Please Enter StudentID: ");
      int StudentID = kbd.nextInt();
      System.out.print("Please Enter CourseID: ");
      String CourseID = kbd.next();
      System.out.print("Please Enter Section number: ");
      int Section = kbd.nextInt();
      System.out.print("Please Enter Semester: ");
      String Semester = kbd.next();
      
      System.out.println();
      String sql = "INSERT into Enrollment " +
                   "VALUES("+StudentID+", '"+CourseID+"',"+Section+",'"+Semester+"'" +")";
      
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

           String sql = "SELECT * FROM Enrollment";
           ResultSet file = stmt.executeQuery(sql);
      
            System.out.println("===========================================================================================================================================");
            System.out.printf("%20s %20s %20s %20s", "StudentID", "CourseID", "Section", "Semester");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
           
            while(file.next())
            {
               int StudentID = file.getInt("StudentID");
               String CourseID = file.getString("CourseID");
               int Section = file.getInt("Section");
               String Semester = file.getString("Semester");
               
         
               System.out.format("%20d %20s %20s %20s", StudentID, CourseID, Section, Semester);
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
      
      System.out.print("Please Enter StudentID: ");
      int StudentID = kbd.nextInt();
      System.out.print("Please Enter CourseID: ");
      String CourseID = kbd.next();
      System.out.print("Please Enter Section Number: ");
      int Section = kbd.nextInt();   
      System.out.println();
        
      String delValue = "("+StudentID+", '"+CourseID+"',"+Section+")";
      return delValue;   
   }

}
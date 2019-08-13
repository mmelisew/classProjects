import java.util.Scanner; 
import java.sql.*;

public class Grades
{

   public static String insert()
   {
      Scanner kbd = new Scanner(System.in);
     
      
      System.out.println("Please enter values to INSERT into the Grades database:");
      
      System.out.print("Please Enter StudentID: ");
      int StudentID = kbd.nextInt();
      System.out.print("Please Enter CourseID: ");
      String CourseID = kbd.next();
      System.out.print("Please Enter Semester: ");
      String Semester = kbd.next();
      System.out.print("Please Enter the Grade: ");
      String Grade = kbd.next();
      
      System.out.println();
      String sql = "INSERT into Grades " +
                   "VALUES("+StudentID+", '"+CourseID+"','"+Semester+"','"+Grade+"'" +")";
      
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
           
           System.out.println("Do you want to see the JOIN of Student's info and thier Grades? \nPLEASE ENTER 1 FOR YES! \nOR ENTER ANY NUMBER JUST TO SEE THE GRADES DATABASE ONLY:");
           int choice = kbd.nextInt();
           //SELECT  firstName, lastName, CourseID, Grade FROM Student s RIGHT JOIN Grades g ON s.StudentID=g.StudentID;
           if(choice == 1)
           {
              String sql = "SELECT  firstName, lastName, CourseID, Grade FROM Student s RIGHT JOIN Grades g ON s.StudentID=g.StudentID";
              ResultSet file = stmt.executeQuery(sql);
              
              System.out.println("Here is the JOIN!");
         
               System.out.println("===========================================================================================================================================");
               System.out.printf("%20s %20s %20s %20s ", "firstName","lastName", "CourseID", "Grade");
               System.out.println();
               System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
              
               while(file.next())
               {
                  String firstName = file.getString("firstName");
                  String lastName = file.getString("lastName");
                  String CourseID = file.getString("CourseID");
                  String Grade = file.getString("Grade");
            
                  System.out.format("%20s %20s %20s %20s ", firstName, lastName, CourseID, Grade);
                  System.out.println();             
               }
               System.out.println("===========================================================================================================================================");
               file.close();
               System.out.println();
           }
           else
           {
              String sql = "SELECT * FROM Grades";
              ResultSet file = stmt.executeQuery(sql);
              System.out.println("Here is the Grades database");
         
               System.out.println("===========================================================================================================================================");
               System.out.printf("%20s %20s %20s %20s ", "StudentID", "CourseID", "Semester", "Grade");
               System.out.println();
               System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
              
               while(file.next())
               {
                  int StudentID = file.getInt("StudentID");
                  String CourseID = file.getString("CourseID");
                  String Semester = file.getString("Semester");
                  String Grade = file.getString("Grade");
            
                  System.out.format("%20d %20s %20s %20s ", StudentID, CourseID, Semester, Grade);
                  System.out.println();             
               }
               System.out.println("===========================================================================================================================================");
               file.close();
               System.out.println();
            }
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
        
      System.out.println();
        
      String delValue = "("+StudentID+", '"+CourseID+"'"+")";
      return delValue;   
   }

}
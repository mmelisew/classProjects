import java.util.Scanner; 
import java.sql.*;

public class Student
{

   public static String insert()
   {
      Scanner kbd = new Scanner(System.in);
      
      
      System.out.println("Please enter values to INSERT into the Student database:");
      
      System.out.print("Please Enter StudentID: ");
      int StudentID = kbd.nextInt();
      System.out.print("Please Enter Student's First name: ");
      String firstName = kbd.next();
      System.out.print("Please Enter Student's Last name: ");
      String lastName = kbd.next();
      System.out.print("Please Enter Student's Seniority Level: ");
      String Seniority = kbd.next();
      System.out.print("Please Enter Student's Field of Study: ");
      String FieldOfStudy = kbd.next();
      
      System.out.println();
      String sql = "INSERT into Student " +
                   "VALUES("+StudentID+", '"+firstName+"','"+lastName+"','"+Seniority+"','"+FieldOfStudy+"'" +")";
      
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
           System.out.println("Do you want to VIEW SENIOR STUDENTS ONLY? \nPLEASE ENTER 1 FOR YES! \nOR ENTER ANY NUMBER JUST TO SEE ALL THE STUDENT DATABASE: ");
           int choice = kbd.nextInt();
           
           if(choice == 1)
           {
               String sql = "SELECT * FROM V_Senior_Students";
               ResultSet file = stmt.executeQuery(sql);
               
               System.out.println("Here is the VIEW for Senior Students Only!");
         
               System.out.println("===========================================================================================================================================");
               System.out.printf("%20s %20s %20s", "firstName", "lastName", "FieldOfStudy");
               System.out.println();
               System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
              
               while(file.next())
               {
                  String firstName = file.getString("firstName");
                  String lastName = file.getString("lastName");
                  String FieldOfStudy = file.getString("FieldOfStudy");
            
                  System.out.format("%20s %20s %20s", firstName, lastName, FieldOfStudy);
                  System.out.println();             
               }
               System.out.println("===========================================================================================================================================");
               file.close();
               System.out.println();

           }
           else
           {
              String sql = "SELECT * FROM Student";
              ResultSet file = stmt.executeQuery(sql);
              
              System.out.println("Here is the Student Table info!");
         
               System.out.println("===========================================================================================================================================");
               System.out.printf("%20s %20s %20s %20s %20s", "StudentID", "firstName", "lastName", "Seniority", "FieldOfStudy");
               System.out.println();
               System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
              
               while(file.next())
               {
                  int StudentID = file.getInt("StudentID");
                  String firstName = file.getString("firstName");
                  String lastName = file.getString("lastName");
                  String Seniority = file.getString("Seniority");
                  String FieldOfStudy = file.getString("FieldOfStudy");
            
                  System.out.format("%20d %20s %20s %20s %20s", StudentID, firstName, lastName, Seniority, FieldOfStudy);
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
   public static int delete()
   {
      Scanner kbd = new Scanner(System.in); 
      
      System.out.print("Please Enter StudentID: ");
      int StudentID = kbd.nextInt();   
      System.out.println();
        
      return StudentID;   
   }

}
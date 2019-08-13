//Melisew Mengsitie
import java.sql.*;
import java.util.Scanner;

public class StudentDatabase {

  /* public static String getName()
   {
       Scanner kbd = new Scanner(System.in);
       System.out.print("Enter your name: ");
       String user = kbd.nextLine();
       
       return user;
   }
   public static String getUserName()
   {
       Scanner kbd = new Scanner(System.in);
       System.out.print("Enter your Username: ");
       String userName = kbd.nextLine();
       
       return userName;
   }
   public static String getPassword()
   {
       Scanner kbd = new Scanner(System.in);
       System.out.print("Enter your Password: ");
       String password = kbd.nextLine();
       
       return password;
   }*/
   
   public static void main(String[]args)
   {
   	
   	Connection conn = null;
      Statement stmt = null;
      
       int choice = 0;
       int tableNum = 0;
       int isCont = 1;
      
       Scanner kbd = new Scanner(System.in);
       System.out.print("Enter your name: ");
       String user = kbd.nextLine();
       
       System.out.println("Hello " + user + "! Please enter your Username and Password to connect to the database!");
   	 System.out.print("User name: ");
       String userName = kbd.nextLine();
       System.out.print("Password: ");
       String password = kbd.nextLine();
   	
   	try {
        // conn = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_mmmengsi?serverTimezone=UTC&"+
         //"user=db_Spr19_mmmengsi&password=mmmengsi");
   
       // Do something with the Connection 
       
       conn = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/"+userName+"?serverTimezone=UTC&" +
        "user=" + userName +"&password=" + password);
        
       System.out.println("Connected!");
       System.out.println("===========================================================================================================================================");
       System.out.println();
       
       stmt = conn.createStatement();
      while(isCont != 0)
      {
       do{
         System.out.println("Menu choices: ");
         System.out.println("1. For Student database \n2. For Enrollment database \n3. For Section database  \n4. For Course database \n5. For Grades database \n0. To QUIT! ");
         System.out.println();
         System.out.println(user +", Please enter your choice: ");
         tableNum = kbd.nextInt();
         System.out.println();
         
         if(tableNum == 0)
         {
            System.out.println("Bye " + user+"!");
            return;
         }
          
          if(tableNum == 1) //Student Table
          {
             System.out.println("Hi " + user + ", You selected Student database!");
             do{
                System.out.println("Please enter \n1 to INSERT into the database: \n2 to RETRIEVE: \n3 to DELETE :");
                choice = kbd.nextInt();
                System.out.println();
             }while(!(choice >= 1 && choice <= 3));
             
              if(choice == 1) // to insert values
              {
                    System.out.println("Inserting into the Student database ...");
                    String sql = Student.insert();
                    stmt.executeUpdate(sql);
                    System.out.println("Inserted!");
               }     
               else if(choice == 2) // to retrieve
               {     
                    System.out.println("Retrieving the Student database ...");
                    System.out.println();
                    Student.retrieve();
                    System.out.println("Done!");
              }
              else if(choice == 3) // to delete
              {
                     System.out.println("Deleting records from Student table...");
                     String sql = "DELETE FROM Student WHERE StudentID = '"+Student.delete()+"'";
                     stmt.executeUpdate(sql);
                     System.out.println("Deleted!");
                     System.out.println();
              }
           }  
           else if(tableNum == 2) //Enrollment Table
           {
                System.out.println("Hi " + user + ", You selected Enrollment database!");
                do{
                   System.out.println("Please enter \n1 to INSERT into the database: \n2 to RETRIEVE: \n3 to DELETE :");
                   choice = kbd.nextInt();
                   System.out.println();
                }while(!(choice >= 1 && choice <= 3));
                
                 if(choice == 1) // to insert values
                 {
                       System.out.println("Inserting into the Enrollment database ...");
                       String sql = Enrollment.insert();
                       stmt.executeUpdate(sql);
                       System.out.println("Inserted!");
                  }     
                  else if(choice == 2) // to retrieve
                  {     
                       System.out.println("Retrieving the Enrollment database ...");
                       System.out.println();
                       Enrollment.retrieve();
                       System.out.println("Done!");
                 }
                 else if(choice == 3) // to delete
                 {
                        System.out.println("Deleting records from Student table...");
                        String sql = "DELETE FROM Enrollment WHERE (StudentID, CourseID, Section) = " + Enrollment.delete();
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted!");
                 }

           }
           
           else if(tableNum == 3) //Section Table
           {

                System.out.println("Hi " + user + ", You selected the Section database!");
                do{
                   System.out.println("Please enter \n1 to INSERT into the database: \n2 to RETRIEVE: \n3 to DELETE :");
                   choice = kbd.nextInt();
                   System.out.println();
                }while(!(choice >= 1 && choice <= 3));
                
                 if(choice == 1) // to insert values
                 {
                       System.out.println("Inserting into the Section database ...");
                       String sql = Section.insert();
                       stmt.executeUpdate(sql);
                       System.out.println("Inserted!");
                  }     
                  else if(choice == 2) // to retrieve
                  {     
                       System.out.println("Retrieving the Section database ...");
                       System.out.println();
                       Section.retrieve();
                       System.out.println("Done!");
                 }
                 else if(choice == 3) // to delete
                 {
                        System.out.println("Deleting records from Section table...");
                        String sql = "DELETE FROM Section WHERE (CourseID, Section) = " + Section.delete();
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted!");
                 }
           }
           
           else if(tableNum == 4) //Course Table
           {
                  System.out.println("Hi " + user + ", You selected Course database!");
                do{
                   System.out.println("Please enter \n1 to INSERT into the database: \n2 to RETRIEVE: \n3 to DELETE :");
                   choice = kbd.nextInt();
                   System.out.println();
                }while(!(choice >= 1 && choice <= 3));
                
                 if(choice == 1) // to insert values
                 {
                       System.out.println("Inserting into the Course database ...");
                       String sql = Course.insert();
                       stmt.executeUpdate(sql);
                       System.out.println("Inserted!");
                  }     
                  else if(choice == 2) // to retrieve
                  {     
                       System.out.println("Retrieving the Course database ...");
                       System.out.println();
                       Course.retrieve();
                       System.out.println("Done!");
                 }
                 else if(choice == 3) // to delete
                 {
                        System.out.println("Deleting records from Course table...");
                        String sql = "DELETE FROM Course WHERE CourseID = '"+Course.delete()+"'";
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted!");
                 }

           }
           
           else if(tableNum == 5) // Grades Table
           {
                System.out.println("Hi " + user + ", You selected Grades database!");
                do{
                   System.out.println("Please enter \n1 to INSERT into the database: \n2 to RETRIEVE: \n3 to DELETE :");
                   choice = kbd.nextInt();
                   System.out.println();
                }while(!(choice >= 1 && choice <= 3));
                
                 if(choice == 1) // to insert values
                 {
                       System.out.println("Inserting into the Grades database ...");
                       String sql = Grades.insert();
                       stmt.executeUpdate(sql);
                       System.out.println("Inserted!");
                  }     
                  else if(choice == 2) // to retrieve
                  {     
                       System.out.println("Retrieving the Grades database ...");
                       System.out.println();
                       Grades.retrieve();
                       System.out.println("Done!");
                 }
                 else if(choice == 3) // to delete
                 {
                        System.out.println("Deleting records from Grades table...");
                        String sql = "DELETE FROM Grades WHERE (StudentID, CourseID) = " + Grades.delete();
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted!");
                 }
           }
           
           System.out.println();

           
          }while(!(tableNum >= 1 && tableNum <= 5));
          
             System.out.println("Please Enter 1 to CONTINUE or Enter 0 to QUIT!");
             isCont = kbd.nextInt();
          }   
      	} // try close
         catch (SQLException ex) 
         {
          // handle any errors
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      	}
      
      System.out.println("Goodbye " + user + "!");
    }// main method close
}
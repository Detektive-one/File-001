import java.util.Scanner;
import java.io.*;
import Projectexp.*;
class UserTest{ 

public static void main(String[] args) {

    System.out.println("Enter details    ");

    Scanner inp = new Scanner(System.in);
    System.out.println("Username : ");
    String user_name = inp.nextLine();
   
    System.out.println("Password : ");
    String pass = inp.nextLine();

    try{ 
    Login u = new Login();

    boolean check = u.login(user_name,pass);

    if(check == false){

      System.out.println("You are not a registered user of the app, please proceed to enter your details:");

      System.out.println("Username : ");
      user_name = inp.nextLine();
   
      System.out.println("Password : ");
      pass = inp.nextLine();
      try{
      Login nu = new Login(user_name,pass);
      nu.newUser();

      nu.menu();
    }
    catch(AmountNegativeException e){
      System.out.println(e);
    }

   }
    else{

      try{
          System.out.println("Welcome registered user. Now you may proceed to the main Menu.");
          Login nw = new Login(user_name,pass);
          nw.login(user_name,pass);
          nw.menu();
  }
      catch(AmountNegativeException e){
          System.out.println(e);
    }
  }

}
catch(IOException e){

  System.out.println(e);
}

 
  
   


}

}

  
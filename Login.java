import java.io.*;
import java.util.Scanner;
import Projectexp.*;
class Login{
	
	String username;
	String password;
	
	Login(){

	this.username = username;
	this.password = password;
}

	Login(String username,String password){
	this.username = username;
	this.password = password;
	

}
	public String getusername(){
		return this.username;
	}
	void newUser()throws IOException{

  	

  		File loginf = new File("LoginData\\User.txt");
        FileWriter fw = new FileWriter(loginf,true);
        BufferedWriter bw = new BufferedWriter(fw);
        String s = this.username + "," + this.password;
        System.out.println(s);
        bw.write(s);
        bw.newLine();
        System.out.println("Login file updated successfully");
        String ufilename = "UserExpenseFiles\\"+username+".txt" ;
        File f = new File(ufilename);
        f.createNewFile();
        System.out.println("Expense file for user "+this.username+" created successfully!");
        bw.close();
        

   
    }

	boolean login(String username,String password)throws IOException{

		

		File f = new File("LoginData\\User.txt");
		FileReader fr= new FileReader(f);
		BufferedReader bin =new BufferedReader(fr);
		String sr = null;
			while((sr=bin.readLine())!=null){
				String tokens[] = sr.split(",");
				// System.out.println(tokens[0]);
				// System.out.println(tokens[1]);
					if(tokens[0].equals(username) && tokens[1].equals(password))
		return true;
		}bin.close();

		return false;
}

	void menu()throws IOException,AmountNegativeException{
		System.out.println("  ");
		System.out.println("1. Input your expense: \n2. Total Expenses: \n3. View Expenses \n4. Exit: ");
		
		System.out.println("Choose the option that you would like use:");

		Scanner sn = new Scanner(System.in);
		int opt = sn.nextInt();

		Expense en = new Expense();

		switch(opt) {

			case 1: en.inputExpense(this);
			break;
			case 2: en.addExpense(this);
			break;
			case 3: en.viewExpenses(this);
			break;
			case 4: 
			break;
			
			default: menu();
			
		}
	}

	





}






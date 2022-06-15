import java.io.*;
import java.util.Scanner;
import Projectexp.*;

class Expense{

	float sum = 0;
	String item;
	float price;
	int n=1;

	
	void inputExpense(Login u)throws IOException,AmountNegativeException{

		
		String ufile = "UserExpenseFiles\\"+u.getusername()+".txt";
		File in = new File(ufile);
		
		FileWriter wr = new FileWriter(in,true);
		BufferedWriter bwr = new BufferedWriter(wr);
		Scanner scn = new Scanner(System.in);
		
		while(true){		
		
		System.out.println("Type the Item name:");
		item = scn.next();
		
		
		System.out.println("Type the Item price:");
		price = scn.nextFloat();
		
		String ie = this.n+ "." +this.item+ "," +this.price;	
		n++;
		System.out.println(ie);
		bwr.write(ie);
    bwr.newLine();		

        System.out.println("Do you want to make another entry? Yes = 1 | N0 = 0: ");
        int dec = scn.nextInt();

        if(dec == 1){
        	continue;
        }
        else{
        	break;

        }
    }

		
		bwr.close();
		u.menu();
	
	}

	float addExpense(Login u)throws IOException,AmountNegativeException{

	  String ufilename = "UserExpenseFiles\\"+u.getusername()+".txt";
		File fn = new File(ufilename);	
		FileReader frd= new FileReader(fn);
		BufferedReader bn =new BufferedReader(frd);
		String sr=null;
			while((sr=bn.readLine())!=null){
				String tokens[] = sr.split(",");
				// System.out.println(tokens[1]);

					float p = Float.parseFloat(tokens[1]);						
					sum = sum + p;

					
				
			}System.out.println("The current total expense is :"+sum);
			bn.close();
			u.menu();
			return this.sum;


		

	}

	
	
	void viewExpenses(Login u)throws IOException,AmountNegativeException{

		String ufilenam = "UserExpenseFiles\\"+u.getusername()+".txt";
		File f = new File(ufilenam);
		FileReader frd= new FileReader(f);

		BufferedReader br = new BufferedReader(frd);
 String line=null;
 
 while ((line = br.readLine()) != null) {
 			
   System.out.println(line);
   
 
   
 }u.menu();


	}

	void updateExpense(Login u)throws IOException,AmountNegativeException{




	}



}
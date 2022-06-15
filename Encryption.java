import java.io.*;
import java.util.Scanner;
import java.util.*;


public class Encryption {
	public static void main(String[] args)
		throws FileNotFoundException, IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Note : Encryption Key act as Password to Decrypt the same Image,otherwise it will corrupt the Image.");
	
		System.out.print("Enter key for Encryption : ");
		int key = sc.nextInt();
							
		
		System.out.print("Enter image path for Encryption : ");
		String path = sc.next();
		
		// System.out.print("Enter path to save encrytped file : ");
		// String new_path = sc.next();

		Change f = new Change();
		path = f.format(path);
		new_path = f.format(new_path);

		// System.out.print(path);

		FileInputStream fis = new FileInputStream(path);
							
							
		byte data[] = new byte[fis.available()];
							
		// Read the array
		fis.read(data);
		int i = 0;
							
		for (byte b : data) {
			data[i] = (byte)(b ^ key);
			i++;
		}
							
		// Opening a file for writing purpose
		FileOutputStream fos = new FileOutputStream(path);
							
								
		fos.write(data);
							
		// Closing file
		fos.close();
		fis.close();
		System.out.println("Encryption Done...");

	}

	public static class Change{

		String format(String path){
			StringBuffer sb = new StringBuffer(path);
			
			if(sb.charAt(0) == '\"'){

			sb.deleteCharAt(0);
			sb.deleteCharAt(sb.length()-1);
		}
			return sb.toString();
		}
	}
}

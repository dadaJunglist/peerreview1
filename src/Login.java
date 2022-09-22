import java.util.Scanner;

public class Login {

	public static String GenerateEmail(String name, String surname, String domain)
	{
		String email = name+surname+"@"+domain;
		return (email.toLowerCase());
	}	
	
	public static String GenerateUsername(String name, String surname)
	{
		String username;
		
		if(surname.length()>4 && name.length()>4)
		{
			username=name.substring(0,4)+surname.substring(surname.length()-4,surname.length());
		}
		else if(name.length()>4)
		{
			username=name.substring(0,4)+surname;
		}
		else
		{
			username=name+surname;
		}
		return (username.toLowerCase());
		//Username can include numbers, but otherwise this won't work for Elon Musk's son 
	}
	
	public static void main(String[] args) {
	
		String name;
		String surname;
		String domain;
		Scanner in = new Scanner(System.in);
		
		do
		{
			System.out.println("Please, enter name:");
			name = in.nextLine();
			System.out.println("Please, enter surname:");
			surname = in.nextLine();
			
			do //Checking that domain name consists at least of 3 characters and includes ".", can be done better
			{
				System.out.println("Please, provide domain:");
				domain = in.nextLine();
				if(!domain.contains(".") || domain.length()<3)
				{
					System.out.println("Incorrect domain name!");
				}
			}
			while(!domain.contains(".") || domain.length()<3);
			
			if(name=="" || surname=="")
			{
				System.out.println("Error! First and/or last name is missing");
			}
		}
		while(name=="" || surname=="");
		
		System.out.println("");
		System.out.println("Your e-mail is: ");
		System.out.println(GenerateEmail(name, surname, domain));
		System.out.println("");
		System.out.println("Your username is: ");
		System.out.println(GenerateUsername(name, surname));
		
	}

}

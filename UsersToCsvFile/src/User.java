
public class User
{
	private String firstName;
	private String lastName;
	private String username;
	private static String password;
	private static String email;
	
	
	public User(String firstName, String lastName, String username, String password, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		password = "123";
		email = "email@email.com";
		
		
	}
	
}

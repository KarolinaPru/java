
@SuppressWarnings("SameParameterValue")
public class User
{
	private final String firstName;
	private final String lastName;
	private final String username;
	private final String password;
	private final String email;
	
	
	@SuppressWarnings("SameParameterValue")
	public User(String firstName, @SuppressWarnings("SameParameterValue") String lastName, String username, @SuppressWarnings("SameParameterValue") String password, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	@Override
	public String toString()
	{
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}

}

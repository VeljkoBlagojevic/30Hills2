package person;

public class Person {

	private long id;
	private String firstName;
	private String surname;
	private long age;
	private String gender;
	private long[] friends = new long[50];
	
	public Person() {
	}
	
	public Person(long id, String firstName, String surname, long age, String gender, long[] friends) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.friends = friends;
	}

	public Person(long id, String firstName, String surname, long age, String gender) {		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long[] getFriends() {
		return friends;
	}
	public void setFriends(long[] friends) {
		this.friends = friends;
	}

	public String printFriends() {
		String string = "";
		for (int i = 0; i < friends.length; i++) {
			if(friends[i]==0)
				break;
			string += friends[i] + ",";
		}
		return string;
	}

	public void print() {
		System.out.println(
				"ID: " + this.getId() + " " +
				" Name: " + this.getFirstName() + " " + this.getSurname() + " " + 
				" Age: " + this.getAge() + " " +
				" Gender: " + this.getGender() + 
				" Friends with: " + this.printFriends());
		
		
		}	
}

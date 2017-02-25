package prime.com.primeclient.models;

import java.util.ArrayList;

public class CompanyModel {
	String companyName;
	private UserModel owner;
	private ArrayList<UserModel> users;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public UserModel getOwner() {
		return owner;
	}

	public void setOwner(UserModel owner) {
		this.owner = owner;
	}

	public ArrayList<UserModel> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserModel> users) {
		this.users = users;
	}
	
	
}

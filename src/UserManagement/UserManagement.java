package UserManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import common.DBUtil;

public class UserManagement {

	public void usermanagement() throws SQLException {
		System.out.println("******Welcome To User Management*******");
		Scanner scanner=new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println();
			System.out.println("What would you like to do Today?");
			System.out.println("     1.Add User");
			System.out.println("     2.Update User");
			System.out.println("     3.Search User");
			System.out.println("     4.Delete User");
			System.out.println("     5.Print User");
			System.out.println("     9.Exit");
			System.out.println("Enter your Choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("----Add User----");
				scanner.nextLine();
				System.out.println("Enter User first Name: ");
				String fname = scanner.nextLine();
				System.out.println("Enter User Last Name: ");
				String lname = scanner.nextLine();
				System.out.println("Enter gender: ");
				String gender = scanner.nextLine();
				System.out.println("Enter User Age: ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter User Email: ");
				String email = scanner.nextLine();
				System.out.println("Enter password");
				String password = scanner.nextLine();
				System.out.println("Reenter Password: ");
				String reenterpass=scanner.nextLine();
				if(password.contains(reenterpass)) {
					String query = "insert into user(first_name, last_name, gender, age, email, password) values('"+fname+"', '"+lname+"', '"+gender+"', '"+age+"', '"+email+"', '"+password+"')";
					DBUtil.executeQuery(query);
					System.out.println("User Added Successfully!!");

				}else {
					System.out.println("Password does not match");
				}
				
				break;
			case 2:
				System.out.println("----Update Product----");
				scanner.nextLine();
				System.out.println("Enter  user name that you want to update: ");
				String updateUserename = scanner.nextLine();
				String updateQuery="select * from user where first_name='"+updateUserename+"'";
				ResultSet resultset=DBUtil.executeSelectQuery(updateQuery);
				
				if(resultset.next()) {
					System.out.println("Enter Updated User Details");
					
					System.out.println("Enter User first Name: ");
					String updatefname = scanner.nextLine();
					System.out.println("Enter User Last Name: ");
					String updatelname = scanner.nextLine();
					System.out.println("Enter gender: ");
					String updategender = scanner.nextLine();
					System.out.println("Enter User Age: ");
					int updateage = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter User Email: ");
					String updateemail = scanner.nextLine();
					System.out.println("Enter password");
					String updatepassword = scanner.nextLine();
					String UpdateQuery="update user set first_name='"+updatefname+"', last_name='"+updatelname+"' ,gender='"+updategender+"' ,age='"+updateage+"' ,email='"+updateemail+"' , password='"+updatepassword+"' where first_name='"+updateUserename+"'";
					DBUtil.executeQuery(UpdateQuery);
					System.out.println("User Update Successfully!!");
					
				}
				else {
					System.out.println("User Not Found");
				}
				
				

				break;
			case 3:
				System.out.println("----Search User-----");
				scanner.nextLine();
				System.out.println("Enter User Name That You Want To Search: ");
				String userSearchename = scanner.nextLine();
				String searchquery = "select * from user where first_name='"+userSearchename+"'";
				ResultSet resultsets =DBUtil.executeSelectQuery(searchquery);
				if (resultsets.next()) {
					System.out.println(resultsets.getString(1)+", "+resultsets.getString(2)+", "+resultsets.getString(3)+", "+resultsets.getInt(4)+", "+resultsets.getString(5)+", "+resultsets.getString(6));

				} else {
					System.out.println("User Details Cannot Found");
				}

				break;
			case 4:
				System.out.println("----Delete User----");
				scanner.nextLine();
				System.out.println("Enter User  name That you want to delete: ");
				String deleteUsername = scanner.nextLine();
				String deletequery = "delete from user where email='"+deleteUsername+"'";
				DBUtil.executeQuery(deletequery);
				System.out.println("User Deleted Successfully!! ");

				break;
			case 5:
				System.out.println("-----Print User------");
				System.out.println();
				String printquery = "select * from user";
				ResultSet resultssets=DBUtil.executeSelectQuery(printquery);
				while(resultssets.next()) {
					System.out.println(resultssets.getString(1)+", "+resultssets.getString(2)+", "+resultssets.getString(3)+", "+resultssets.getInt(4)+", "+resultssets.getString(5)+", "+resultssets.getString(6));
				}

				break;
			case 9:
				System.out.println("Exit User Management Successfully!!!!");
				run = false;
				break;
			default:
				System.out.println("Invalid Input");
				break;

			}
		}
	}

}

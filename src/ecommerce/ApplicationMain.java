package ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import ProductManagement.ProductManagement;
import UserManagement.UserManagement;

public class ApplicationMain {
	

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("*******Welcome To Ecommerce_01*********");
		Scanner scanner = new Scanner(System.in);
		ProductManagement product = new ProductManagement();
		UserManagement user = new UserManagement();
		boolean run = true;
		while (run) {
			System.out.println();
			System.out.println("What you would like you to do Today?");
			System.out.println("       1.User Management");
			System.out.println("       2.Product Management");
			System.out.println("       9.Exit");
			System.out.println("Enter Your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				user.usermanagement();
				break;
			case 2:
				product.productmanagement();
				break;
			case 9:
				System.out.println("Exit Application Successfully!!!");
				run = false;
				break;
			default:
				System.out.println("Invalid Input");
				break;

			}
		}
	}

}

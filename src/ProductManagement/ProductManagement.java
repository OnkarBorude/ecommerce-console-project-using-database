package ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import common.DBUtil;

public class ProductManagement {

	public void productmanagement() throws SQLException {
		System.out.println("*********Welcome To Product Management********");
		Scanner scanner=new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println();
			System.out.println("What would you like to do Today?");
			System.out.println("      1.Add Product");
			System.out.println("      2.Update product");
			System.out.println("      3.Search Product");
			System.out.println("      4.Delete Product");
			System.out.println("      5.Print Product");
			System.out.println("      9.Exit");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("-----Add Product-----");
				System.out.println();
				System.out.println("Enter product details");
				scanner.nextLine();
				System.out.println("enter product name: ");
				String productname = scanner.nextLine();

				System.out.println("enter product quantity: ");
				int quantity = scanner.nextInt();

				System.out.println("enter product price: ");
				int price = scanner.nextInt();

				String query = "insert into product(product_name, product_quantity, product_price) values('"+productname+"', '"+quantity+"', '"+price+"')";
				DBUtil.executeQuery(query);
				System.out.println("Product Added Successfully!!");
				break;
			case 2:
				System.out.println("-----Update Product-----");
				scanner.nextLine();
				System.out.println("Enter Product Name that you want to Update");
				String productNameToUpdate = scanner.next();
				
				String update_query = "select * from product where product_name='"+productNameToUpdate+"'";
				ResultSet resultsets=DBUtil.executeSelectQuery(update_query);
				
				
				if(resultsets.next()) {
					System.out.println("Enter update details: ");
					scanner.nextLine();
					System.out.println("Enter product name: ");
					String updateproductname = scanner.nextLine();
                    
					System.out.println("enter product quantity: ");
					int updatequatity = scanner.nextInt();
                    scanner.nextLine();
					System.out.println("Enter product price: ");
					int updateprice = scanner.nextInt();
					String productUpdateQuery = "update product set product_name='" +updateproductname+ "', product_quantity="
							+ updatequatity+ ", product_price='" + updateprice + "' where product_name='" + productNameToUpdate
							+ "'";
					DBUtil.executeQuery(productUpdateQuery);
					System.out.println("Product Update Successfullt!!");
				}
				else {
					System.out.println("Product Not Found");
				}
				break;
			case 3:
				System.out.println("-----Search Product-----");
				System.out.println();
				System.out.println("Enter Product name that you want to Search: ");
				String productnameToSearch = scanner.next();
				String searchquery = "select * from product where product_name='"+productnameToSearch+"'";
				
				ResultSet resultset = DBUtil.executeSelectQuery(searchquery);
				
				if (resultset.next()) {
					System.out.println(resultset.getString(1)+", "+resultset.getInt(2)+", "+resultset.getInt(3));
				} else {
					System.out.println("Product Details Not Found");
				}

				break;
			case 4:
				System.out.println("-----Delete Product-----");
				System.out.println();
				System.out.println("Enter Product name that you want to Delete: ");
				String productnameToBeDelete = scanner.next();
				String deletequery = "delete from product where product_name='"+productnameToBeDelete+"'";
				DBUtil.executeQuery(deletequery);
				System.out.println("Product Deleted Successfully!!!");
				break;
			case 5:
				System.out.println("-----Print Product-----");
				String printquery = "select * from product";
				ResultSet resultsset=DBUtil.executeSelectQuery(printquery);
				while(resultsset.next()) {
					System.out.println(resultsset.getString(1)+", "+resultsset.getInt(2)+", "+resultsset.getInt(3));
				}
				break;
			case 9:
				System.out.println("Exit Product Mangement Successfully!!");

				run = false;
				break;
			default:
				System.out.println("invalid input");
				break;
			}
		}
	}

}

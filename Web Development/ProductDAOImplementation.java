package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import entities.Department;
import entities.Product;

public class ProductDAOImplementation implements ProductDAO {

	Connection conn ; //GLOBAL 
	
	public ProductDAOImplementation() {
		try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ conn);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insertProduct(Product product) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO PRODUCTS VALUES (?,?,?,?,?,?,?,?,?)");
			
			pst.setInt(1,product.getProductId());
			pst.setString(2, product.getProductName());
			pst.setString(3, product.getProductDescription());
			pst.setString(4, product.getProductCategory());
			pst.setDouble(5,product.getProductPrice());
			pst.setInt(6, product.getProductQuantity());
			pst.setString(7, product.getBrand());
			pst.setString(8, product.getProductImage());
			pst.setDouble(9, product.getProductRating());
			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Rows created : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public Product selectProduct(int productNumber) {
		
		Product productObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCT_ID="+productNumber);
			
			//5. process the result if any
			if(result.next()) {
				productObj = new Product(); //blank object
				
				productObj.setProductId(result.getInt(1));
				productObj.setProductName(result.getString(2));
				productObj.setProductDescription(result.getString(3));
				productObj.setProductCategory(result.getString(4));
				productObj.setProductPrice(result.getDouble(5));
				productObj.setProductQuantity(result.getInt(6));
				productObj.setBrand(result.getString(7));	
				productObj.setProductImage(result.getString(8));
				productObj.setProductRating(result.getDouble(9));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productObj;
	}
	
public List<Product> selectProductsOfCategory(String categoryType) {
		
		List<Product> categoryList = new ArrayList<Product>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM PRODUCTS WHERE CATEGORY = "+ categoryType);
			
			//5. process teh result if any
			while(result.next()) {
				Product productObj = new Product(); //blank object
				
				productObj.setProductId(result.getInt(1));
				productObj.setProductName(result.getString(2));
				productObj.setProductDescription(result.getString(3));
				productObj.setProductCategory(result.getString(4));
				productObj.setProductPrice(result.getDouble(5));
				productObj.setProductQuantity(result.getInt(6));
				productObj.setBrand(result.getString(7));	
				productObj.setProductImage(result.getString(8));
				productObj.setProductRating(result.getDouble(9));
				categoryList.add(productObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public List<Product> selectProducts() {
		
		List<Product> deptList = new ArrayList<Product>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM PRODUCTS");
			
			//5. process teh result if any
			while(result.next()) {
				Product productObj = new Product(); //blank object
				
				productObj.setProductId(result.getInt(1));
				productObj.setProductName(result.getString(2));
				productObj.setProductDescription(result.getString(3));
				productObj.setProductCategory(result.getString(4));
				productObj.setProductPrice(result.getDouble(5));
				productObj.setProductQuantity(result.getInt(6));
				productObj.setBrand(result.getString(7));	
				productObj.setProductImage(result.getString(8));
				productObj.setProductRating(result.getDouble(9));
				deptList.add(productObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptList;
	}

	@Override
	public void updateProduct(Product product) {
		//3. make a desired statement (insert/update/delete/select)
		
				try {
					PreparedStatement pst = 
							conn.prepareStatement("UPDATE PRODUCTS SET PRODUCT_NAME=?, PRODUCT_BRAND=?, PRODUCT_PRICE=? WHERE PRODUCT_ID=?"
);
					
					
					pst.setInt(1,product.getProductId());
					pst.setString(2, product.getProductName());
					pst.setString(3, product.getProductDescription());
					pst.setString(4, product.getProductCategory());
					pst.setDouble(5,product.getProductPrice());
					pst.setInt(6, product.getProductQuantity());
					pst.setString(7, product.getBrand());
					pst.setString(8, product.getProductImage());
					pst.setDouble(9, product.getProductRating());

					
					System.out.println("PreparedStatement is created : "+ pst);
					
					//4. execute that statement //  UR TABLENAME IS MYDEPT120
					int rows = pst.executeUpdate();
					
					System.out.println("Row MODIFIED : "+rows);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void deleteProduct(int productID) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_ID=?");
			
			pst.setInt(1, productID); //WHERE deptno=?

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

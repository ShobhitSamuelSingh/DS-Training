package dao;

import java.util.List;


import entities.Product;

//II. POJI
public interface ProductDAO { //POJI as per the POJO
	
	public void insertProduct(Product product); //C
	public Product selectProduct(int productNumber);//R
	public List<Product> selectProducts(); //RA
	public void updateProduct(Product product); //U
	public void deleteProduct(int productNumber); //D
	
	
	public List<Product> selectProductsOfCategory(String categoryType);
}

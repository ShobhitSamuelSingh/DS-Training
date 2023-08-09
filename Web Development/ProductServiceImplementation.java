package service;

import java.util.List;

import dao.ProductDAO;
import dao.ProductDAOImplementation;
import dao.ProductDAO;
import dao.ProductDAOImplementation;
import entities.Product;
import entities.Product;
//In The SERVICE
public class ProductServiceImplementation implements ProductService {
	ProductDAO prodDAO = new ProductDAOImplementation();
	@Override
	public void createProductService(Product product) {
		// TODO Auto-generated method stub
		prodDAO.insertProduct(product);
		
	}
 
	@Override
	public Product findProductService(int productId) {
		// TODO Auto-generated method stub
		return prodDAO.selectProduct(productId) ;
	}

	@Override
	public List<Product> findProductsService() {
		// TODO Auto-generated method stub
		return prodDAO.selectProducts() ;
	}

	@Override
	public void modifyProductService(Product product) {
		// TODO Auto-generated method stub
		 prodDAO.updateProduct(product);
		
	}

	@Override
	public void removeProductService(int productId) {
		// TODO Auto-generated method stub
		prodDAO.deleteProduct(productId);
		
	}

	@Override
	public List<Product> findCategoryProductsService(String categoryType) {
		// TODO Auto-generated method stub
		return prodDAO.selectProductsOfCategory(categoryType) ;
	}


}

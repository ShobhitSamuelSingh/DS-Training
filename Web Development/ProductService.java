package service;

import java.util.List;

//import entities.Department;
import entities.Product;

public interface ProductService {
	
	
//	void createDepartmentService(Department dept);
//	Department findDepartmentService(int deptNumber);
//	List<Department> findDepartmentsService();
//	void modifyDepartmentService(Department dept);
//	void removeDepartmentService(int deptNumber);
	
	
	void createProductService(Product product);
	Product findProductService(int produtId);
	List<Product> findProductsService();
	void modifyProductService(Product product);
	void removeProductService(int productId);
	
	
	List<Product> findCategoryProductsService(String categoryType);

}

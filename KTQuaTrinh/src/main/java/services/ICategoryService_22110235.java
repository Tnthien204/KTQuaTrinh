
package services;

import java.util.List;

import entity.Category;

public interface ICategoryService_22110235 {
	void insert(Category category);

	int count();

	List<Category> findAll(int page, int pagesize);

	List<Category> searchByName(String catname);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	Category findByCategoryname(String name);
}

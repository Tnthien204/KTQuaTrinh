package dao;

import java.util.List;

import entity.Category;

public interface ICategoryDao_22110235 {

	void update(Category category);

	void insert(Category category);

	int count();

	List<Category> findAll(int page, int pagesize);

	List<Category> searchByName(String catname);

	List<Category> findAll();

	Category findByCategoryname(String name) throws Exception;

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

}
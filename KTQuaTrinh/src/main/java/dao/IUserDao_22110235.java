package dao;

import java.util.List;

import entity.User_22110235;

public interface IUserDao_22110235 {

	int count();

	List<User_22110235> findAll(int page, int pagesize);

	List<User_22110235> searchByName(String username);

	List<User_22110235> findAll();

	User_22110235 findByUsername(String name) throws Exception;

	User_22110235 findById(int userid);

	void delete(int userid) throws Exception;

	void update(User_22110235 user_22110235);

	void insert(User_22110235 user_22110235);

	User_22110235 findByEmail(String email) throws Exception;

	User_22110235 findByPhone(String phone) throws Exception;

}
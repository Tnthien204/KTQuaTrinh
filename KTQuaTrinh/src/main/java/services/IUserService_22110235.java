package services;

import java.util.List;

import dao.IUserDao_22110235;
import dao.impl.UserDao_22110235;
import entity.User_22110235;

public interface IUserService_22110235 {

	User_22110235 findByUsername(String name);

	void update(User_22110235 user_22110235);

	void delete(int userid) throws Exception;

	User_22110235 findById(int userid);

	List<User_22110235> findAll();
	void insert(User_22110235 user_22110235);

	List<User_22110235> searchByName(String username);

	List<User_22110235> findAll(int page, int pagesize);

	int count();

	User_22110235 findByEmail(String email);

	User_22110235 findByPhone(String phone);

	User_22110235 register(User_22110235 user_22110235);

	User_22110235 login(String username, String password);

	IUserDao_22110235 userDao_22110235 = new UserDao_22110235();

}
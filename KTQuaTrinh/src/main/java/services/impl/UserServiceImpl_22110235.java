
package services.impl;

import java.util.List;

import entity.User_22110235;
import services.IUserService_22110235;

public class UserServiceImpl_22110235 implements IUserService_22110235{
	@Override
	public void insert(User_22110235 user_22110235) {
		User_22110235 u = this.findByUsername(user_22110235.getUsername());
		if (u == null) {
			userDao_22110235.insert(user_22110235);
		}

	}

	public User_22110235 login(String username, String password) {
		User_22110235 user_22110235 = this.findByUsername(username);
		if (user_22110235 != null && password.equals(user_22110235.getPassword())) {
			return user_22110235;
		}
		return null;

	}
	@Override
	public User_22110235 register(User_22110235 user_22110235) {
		userDao_22110235.insert(user_22110235);
		return user_22110235;
	}
	
	
	@Override
	public int count() {
		return userDao_22110235.count();
	}

	
	@Override
	public List<User_22110235> findAll(int page, int pagesize) {
		return userDao_22110235.findAll(page, pagesize);
	}

	
	@Override
	public List<User_22110235> searchByName(String username) {
		return userDao_22110235.searchByName(username);
	}

	
	@Override
	public List<User_22110235> findAll() {
		return userDao_22110235.findAll();
	}

	
	@Override
	public User_22110235 findById(int userid) {
		return userDao_22110235.findById(userid);
	}

	
	@Override
	public void delete(int userid) throws Exception {
		try {
			userDao_22110235.delete(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void update(User_22110235 user_22110235) {
		User_22110235 u = this.findById(user_22110235.getUserid());
		if (u != null) {
			userDao_22110235.update(user_22110235);
		}

	}

	
	@Override
	public User_22110235 findByUsername(String name) {
		try {
			return userDao_22110235.findByUsername(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public User_22110235 findByPhone(String phone) {
	    try {
	        return userDao_22110235.findByPhone(phone);
	    } catch (Exception e) {
	        // Ghi log hoặc thông báo lỗi cụ thể
	        e.printStackTrace();  // Hoặc sử dụng hệ thống log tốt hơn
	        return null;  // Trả về null nếu có lỗi
	    }
	}
	public static void main(String[] args) {
	    UserServiceImpl_22110235 a = new UserServiceImpl_22110235();
	    User_22110235 b = a.findByEmail("phuong@123");
	    if (b != null) {
	        System.out.print(b.getFullname());
	    } else {
	        System.out.println("Không tìm thấy người dùng với số điện thoại này.");
	    }
	}


	@Override
	public User_22110235 findByEmail(String email) {
		try {
			return userDao_22110235.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}

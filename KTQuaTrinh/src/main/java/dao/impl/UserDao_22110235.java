package dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import configs.JPAConfig_22110235;
import dao.IUserDao_22110235;
import entity.User_22110235;

public class UserDao_22110235 implements IUserDao_22110235 {
	
	@Override
	public void insert(User_22110235 user_22110235) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user_22110235);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public void update(User_22110235 user_22110235) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user_22110235);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public void delete(int userid) throws Exception {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User_22110235 user_22110235 = enma.find(User_22110235.class, userid);
			if (user_22110235 != null) {
				enma.remove(user_22110235);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public User_22110235 findById(int userid) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		User_22110235 user_22110235 = enma.find(User_22110235.class, userid);
		return user_22110235;
	}

	
	@Override
	public User_22110235 findByUsername(String name) throws Exception {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT u FROM NhanVien u WHERE u.username =:name";
		try {
			TypedQuery<User_22110235> query = enma.createQuery(jpql, User_22110235.class);
			query.setParameter("name", name);
			return query.getSingleResult();  // Nếu không có kết quả, sẽ ném NoResultException
	    } catch (NoResultException e) {
	        // Không tìm thấy người dùng
	        return null;
	    } finally {
	        enma.close();
	    }
	}
	
	@Override
	public User_22110235 findByPhone(String phone) throws Exception {
	    EntityManager enma = JPAConfig_22110235.getEntityManager();
	    String jpql = "SELECT u FROM NhanVien u WHERE u.phone =:phone";
	    try {
	        TypedQuery<User_22110235> query = enma.createQuery(jpql, User_22110235.class);
	        query.setParameter("phone", phone);
	        return query.getSingleResult();  // Nếu không có kết quả, sẽ ném NoResultException
	    } catch (NoResultException e) {
	        // Không tìm thấy người dùng
	        return null;
	    } finally {
	        enma.close();
	    }
	}

	
	@Override
	public User_22110235 findByEmail(String email) throws Exception {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT u FROM NhanVien u WHERE u.email =:email";
		try {
			TypedQuery<User_22110235> query = enma.createQuery(jpql, User_22110235.class);
			query.setParameter("email", email);
			return query.getSingleResult();  // Nếu không có kết quả, sẽ ném NoResultException
	    } catch (NoResultException e) {
	        // Không tìm thấy người dùng
	        return null;
	    } finally {
	        enma.close();
	    }
	}

	
	@Override
	public List<User_22110235> findAll() {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		TypedQuery<User_22110235> query = enma.createNamedQuery("NhanVien.findAll", User_22110235.class);
		return query.getResultList();
	}

	
	@Override
	public List<User_22110235> searchByName(String username) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT u FROM NhanVien u WHERE u.username like :catname";
		TypedQuery<User_22110235> query = enma.createQuery(jpql, User_22110235.class);
		query.setParameter("catname", "%" + username + "%");
		return query.getResultList();
	}

	
	@Override
	public List<User_22110235> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		TypedQuery<User_22110235> query = enma.createNamedQuery("NhanVien.findAll", User_22110235.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	
	@Override
	public int count() {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT count(u) FROM NhanVien u";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}
}
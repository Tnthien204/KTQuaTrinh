
package dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import configs.JPAConfig_22110235;
import dao.IVideoDao_22110235;
import entity.Video;

public class VideoDao_22110235 implements IVideoDao_22110235{
	@Override
	public void insert(Video video) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(video);
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
	public void update(Video video) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(video);
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
	public void delete(String videoid) throws Exception {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Video video = enma.find(Video.class, videoid);
			if (video != null) {
				enma.remove(video);
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
	public Video findById(String videoid) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		Video video = enma.find(Video.class, videoid);
		return video;
	}

	
	@Override
	public Video findByTitle(String title) throws Exception {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT v FROM Video v WHERE v.title =:title";
		try {
			TypedQuery<Video> query = enma.createQuery(jpql, Video.class);
			query.setParameter("title", title);
			Video video = query.getSingleResult();
			if (video == null) {
				throw new Exception("Video đã tồn tại");
			}
			return video;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public List<Video> findAll() {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
		return query.getResultList();
	}

	
	@Override
	public List<Video> searchByTitle(String title) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT v FROM Video v WHERE v.title like :title";
		TypedQuery<Video> query = enma.createQuery(jpql, Video.class);
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}

	
	@Override
	public List<Video> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	
	@Override
	public int count() {
		EntityManager enma = JPAConfig_22110235.getEntityManager();
		String jpql = "SELECT count(v) FROM Video v";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}
}

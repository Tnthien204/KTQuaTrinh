package dao;

import java.util.List;

import entity.Video;

public interface IVideoDao_22110235 {

	int count();

	List<Video> findAll(int page, int pagesize);

	List<Video> searchByTitle(String title);

	List<Video> findAll();

	Video findByTitle(String title) throws Exception;

	Video findById(String videoid);

	void delete(String videoid) throws Exception;

	void update(Video video);

	void insert(Video video);

}
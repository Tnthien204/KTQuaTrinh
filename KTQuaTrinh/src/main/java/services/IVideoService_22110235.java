package services;

import java.util.List;

import dao.IVideoDao_22110235;
import dao.impl.VideoDao_22110235;
import entity.Video;

public interface IVideoService_22110235 {

	Video findByTitle(String title);

	void update(Video video);

	void delete(String vidid) throws Exception;

	Video findById(String vidid);

	List<Video> findAll();

	List<Video> searchByTitle(String title);

	List<Video> findAll(int page, int pagesize);

	int count();

	void insert(Video video);

	IVideoDao_22110235 viddao = new VideoDao_22110235();

}
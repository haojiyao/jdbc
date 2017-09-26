package dao;

import java.util.List;

import entity.News;

public interface NewDao {
	public List<News> getNewsByTop5();
	public List<News> getNews(String pageNo,String pageSize);

}

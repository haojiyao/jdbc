package service;

import java.util.List;

import entity.News;

public interface NewService {
	public List<News> getNewsByTop5();
	public List<News> getNews(String pageNo,String pageSize);
	
}

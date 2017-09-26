package service.impl;

import java.util.List;

import dao.NewDao;
import dao.impl.NewDaoImpl;

import entity.News;
import service.NewService;

public class NewServiceImpl implements NewService{

	NewDao dao=new NewDaoImpl();	
	@Override
	public List<News> getNewsByTop5() {
		// TODO Auto-generated method stub
		return dao.getNewsByTop5();
	}
	@Override
	public List<News> getNews(String pageNo,String pageSize) {
		// TODO Auto-generated method stub
		return dao.getNews(pageNo, pageSize);
	}

}

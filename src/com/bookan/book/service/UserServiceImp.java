package com.bookan.book.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookan.book.DAO.UserDAO;
import com.bookan.book.domain.User;

@Service
public class UserServiceImp implements UserService{

	

	@Autowired
	UserDAO userDAO;
	private HttpSession httpSession;
	
	private User userOne;
	
	
	
	
	@Override
	@Transactional
	public String userAuthenticate(User user) {
		userOne = userDAO.readUniqueObject(user);
		if(userOne!=null){
			httpSession.setAttribute("userpass", userOne.getName()+":"+userOne.getPassword());
			System.out.println("user name:"+userOne.getName()+"password: "+userOne.getPassword());
			return "success";
		}else{
			return "failed";
		}
		
	}

}

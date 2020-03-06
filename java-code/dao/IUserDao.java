package com.app.dao;

import java.util.List;

import com.app.pojos.Doctor;
import com.app.pojos.QualificationType;
import com.app.pojos.User;
import com.app.pojos.UserType;

public interface IUserDao {
	public Integer registerUser(User user);
	public User login(User user);
	
	public User findByEmail(User user);
	public User findByEmail(String email);
	public int generateOtp();
	public int resetpassword(String email,String pass);
	public void updateOtp(User user);
	public List<UserType> listUserRoles();

}

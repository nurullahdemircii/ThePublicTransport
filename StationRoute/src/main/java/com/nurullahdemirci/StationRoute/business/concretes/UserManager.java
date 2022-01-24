package com.nurullahdemirci.StationRoute.business.concretes;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.StationRoute.business.abstracts.UserService;
import com.nurullahdemirci.StationRoute.core.dataAccess.UserDao;
import com.nurullahdemirci.StationRoute.core.entities.User;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessResult;
import com.nurullahdemirci.StationRoute.entities.dtos.UpdateUserDetailsDto;
import com.nurullahdemirci.StationRoute.entities.dtos.UpdateUserPasswordDto;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result create(User user) {
		this.userDao.save(user);
		return new SuccessResult("Yönetici Eklendi.");
	}

	@Override
	public Result updateUserDetails(Integer id, UpdateUserDetailsDto updateUserDetailsDto) {
		User user = this.userDao.findById(id).orElseThrow(EntityNotFoundException::new);
		user.setFirstName(updateUserDetailsDto.getFirstName());
		user.setLastName(updateUserDetailsDto.getLastName());
		user.setEmail(updateUserDetailsDto.getEmail());
		//user.setPassword(user.getPassword());
		//user.setPasswordRepeat(user.getPasswordRepeat());
		this.userDao.save(user);
		return new SuccessResult("Yönetici Bilgileri Güncellendi!");
	}
	
	public Result updateUserPassword(Integer id, UpdateUserPasswordDto updateUserPasswordDto) {
		User user = this.userDao.findById(id).orElseThrow(EntityNotFoundException::new);
		user.setPassword(updateUserPasswordDto.getPassword());
		user.setPasswordRepeat(updateUserPasswordDto.getPasswordRepeat());
		this.userDao.save(user);
		return new SuccessResult("Yönetici Þifresi Güncellendi!");
	}

	@Override
	public Result delete(Integer id) {
		this.userDao.deleteById(id);
		return new SuccessResult("Yönetici Silindi.");
	}

	@Override
	public DataResult<User> getById(Integer id) {
		return new SuccessDataResult<User>(this.userDao.getById(id), "Yönetici Listelendi.");
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Yöneticiler Listelendi.");
	}
	
}

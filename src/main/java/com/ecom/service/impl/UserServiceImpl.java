package com.ecom.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;
import com.ecom.util.AppConstant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDtls saveUser(UserDtls user) {
		
		user.setRole("ROLE_USER");
		user.setIsEnable(true);
		user.setAccountNonLocked(true);
		user.setFaillAtempt(0);
		
		String encodepassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodepassword);
		UserDtls saveUser = userRepository.save(user);
		
		return saveUser;
	}

	@Override
	public UserDtls getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDtls> getAllUsers(String role) {
		
		return 	userRepository.findByRole(role);
		
	}

	@Override
	public Boolean updateAccountStatus(Integer id, Boolean status) {
		
		Optional<UserDtls> findByUser = userRepository.findById(id);
		
		if(findByUser.isPresent())
		{
			UserDtls userDtls = findByUser.get();
			userDtls.setIsEnable(status);
			userRepository.save(userDtls);
			return true;
		}
		
		return false;
	}

	@Override
	public void increaseFailedAttempt(UserDtls user) {
		int attempt =user.getFailledAtempt() + 1;
		user.setFaillAtempt(attempt);
		userRepository.save(user);
		
	}

	@Override
	public void userAccountLock(UserDtls user) {
		user.setAccountNonLocked(false);
		user.setLockTime(new Date());
		userRepository.save(user);
		
	}

	@Override
	public boolean unlockAccountTimeExpired(UserDtls user) {
		
		long lockTime = user.getLockTime().getTime();
		long unLockTime = lockTime + AppConstant.UNLOCK_DURATION_TIME;
		
		long currentTime = System.currentTimeMillis();
		
		if(unLockTime < currentTime)
		{
			user.setAccountNonLocked(true);
			user.setFaillAtempt(0);
			user.setLockTime(null);
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public void resetAttempt(int userId) {
		
		
	}

	@Override
	public void updateUserResetToken(String email, String resetToken) {
		UserDtls findByEmail = userRepository.findByEmail(email);
		findByEmail.setResetToken(resetToken);
		userRepository.save(findByEmail);
	}

	@Override
	public UserDtls getUserByToken(String token) {
		return	userRepository.findByResetToken(token);
		
	}

	@Override
	public UserDtls updateUser(UserDtls user) {
		return userRepository.save(user);
		 
	}

	@Override
	public UserDtls updateUserProfile(UserDtls user, MultipartFile img)  {

		UserDtls userDtls = userRepository.findById(user.getId()).get();

		if(!img.isEmpty())
		{
			userDtls.setProfileImage(img.getOriginalFilename());
		}
		
		if (!ObjectUtils.isEmpty(userDtls)) {
			userDtls.setName(user.getName());
			userDtls.setMobileNumber(user.getMobileNumber());
			userDtls.setAddress(user.getAddress());
			userDtls.setCity(user.getCity());
			userDtls.setState(user.getState());
			userDtls.setPinCode(user.getPinCode());
			userRepository.save(userDtls);
		}
		
		try {
		if(!img.isEmpty())
		{
			File saveFile = new ClassPathResource("static/img").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "profile_img" + File.separator
					+ img.getOriginalFilename());

//		System.out.println(path);
			Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		}
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		
			return userDtls;
	}
	
	@Override
	public UserDtls saveAdmin(UserDtls user) {

		user.setRole("ROLE_ADMIN");
		user.setIsEnable(true);
		user.setAccountNonLocked(true);
		user.setFaillAtempt(0);

		String encodepassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodepassword);
		UserDtls saveUser = userRepository.save(user);

		return saveUser;
	}

	@Override
	public Boolean existsEmail(String email) {

		return userRepository.existsByEmail(email);
	}
	
	
}

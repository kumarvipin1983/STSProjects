package com.photoapp.api.users.service;

import java.util.Random;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoapp.api.users.data.UserEntity;
import com.photoapp.api.users.data.UserRepository;
import com.photoapp.api.users.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword(getRandomNumberString8char());
		userRepository.save(userEntity);
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		return returnValue;
	}

	public String getRandomNumberString8char() {
		// It will generate 8 digit random Number.
		// from 0 to 99999999
		Random rnd = new Random();
		int number = rnd.nextInt(99999999);

		// this will convert any number sequence into 6 character.
		return String.format("%08d", number);
	}
}
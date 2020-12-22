package com.springbootproject.service.impl;

import com.springbootproject.dto.UserDTO;
import com.springbootproject.exception.ServiceException;
import com.springbootproject.mapper.UserToUserDTOMapper;
import com.springbootproject.repository.UserRepository;
import com.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToUserDTOMapper userMapper;


    @Override
    public UserDTO getUserById(final Long id) {
        return userMapper.toDTO(userRepository.getUserById(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(final UserDTO userDTO) {
        if(userDTO.getId() != null) {
            throw new ServiceException(400, "User shouldn't have an id ");
        }

        return userMapper.toDTO(userRepository.createUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {
        if(userDTO.getId() == null) {
            throw new ServiceException(400, "User should have an id ");
        }

        return userMapper.toDTO(userRepository.updateUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteUserById(id);
    }
}

package com.springbootproject.repository;

import com.springbootproject.entity.User;
import com.springbootproject.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    @PostConstruct
    public void init() {
        savedUsers = new ArrayList<>();
    }

    private static Long lastId = 0L;
    private List<User> savedUsers;


    public User getUserById(final Long id) {
        return savedUsers.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User with id: " + id + " not found "));
    }

    public List<User> getAllUsers() {
        return savedUsers;
    }

    public User createUser(final User user) {
        if (user.getId() != null) {
            throw new ServiceException(400, "User shouldn't have an id ");
        }

        ++lastId;
        user.setId(lastId);
        savedUsers.add(user);
        return user;
    }

    public User updateUser(final User user) {
        if (user.getId() == null) {
            throw new ServiceException(400, "User should have an id ");
        }

        final User savedUser = getUserById(user.getId());

        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setBirth(user.getBirth());
        savedUser.setTickets(user.getTickets());

        return savedUser;
    }

    public void deleteUserById(final Long id) {
        if(id == null) {
            throw new ServiceException(400, "Id isn't specified");
        }

        savedUsers.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User with id: " + id + " not found "));

        savedUsers = savedUsers.stream()
                .filter(user -> !user.getId().equals(id))
                .collect(Collectors.toList());
    }
}

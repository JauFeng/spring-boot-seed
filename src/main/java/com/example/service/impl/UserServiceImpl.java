package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Service impl.
 * <p>
 * Created by freecloud on 13/03/2017.
 */
@Service(value = "userService")
@Transactional(rollbackFor = {Throwable.class})
public class UserServiceImpl implements UserService {

//    private final UserMapper userMapper;
//
//
//    public UserServiceImpl(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int createUser(User user) {
        return this.userDao.insert(user);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int removeUserById(long id) {
        return this.userDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int modifyUser(User user) {
        return this.userDao.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(User user) {
        return this.userDao.selectByName(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll(int offset, int limit) {
        return this.userDao.selectAll(offset, limit);
    }
}
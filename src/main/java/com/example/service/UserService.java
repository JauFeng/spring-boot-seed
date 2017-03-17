package com.example.service;

import com.example.domain.User;

import java.util.List;

/**
 * User service.
 * <p>
 * Created by freecloud on 13/03/2017.
 */
public interface UserService {

    /**
     * Create user.
     *
     * @param user
     */
    int createUser(User user);

    /**
     * Delete user.
     *
     * @param id
     * @return
     */
    int removeUserById(long id);

    /**
     * Modify user.
     *
     * @param user
     * @return
     */
    int modifyUser(User user);

    /**
     * Find user.
     *
     * @param user
     * @return
     */
    User findUser(User user);

    /**
     * Find all user.
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> findAll(int offset, int limit);
}

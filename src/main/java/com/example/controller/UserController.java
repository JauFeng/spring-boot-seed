package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * User controller.
 * <p>
 * Created by freecloud on 14/03/2017.
 */
@RestController
@RequestMapping(
        value = {"/user"},
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create user.
     *
     * @param username
     * @param password
     */
    @PostMapping(value = {"/create"})
    public int createUser(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password) {

        logger.info("Username: %s", username + ", " + "Password: %s" + password);

        User user = new User(username, password, new Date());

        return userService.createUser(user);
    }

    /**
     * Modify user.
     *
     * @param username
     * @param password
     * @return
     */
    @PutMapping(value = {"/modify"})
    public int modifyUser(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password) {
        User user = new User(username, password, new Date());
        return userService.modifyUser(user);
    }

    /**
     * Remove user by Id.
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = {"/delete/{id}"})
    public int deleteUserById(@PathVariable(value = "id") long id) {
        return userService.removeUserById(id);
    }

    /**
     * Get user.
     *
     * @param id
     * @param username
     * @return
     */
    @GetMapping(value = {"/get"})
    public User getUser(@RequestParam(value = "id", required = false, defaultValue = "0") Long id,
                        @RequestParam(value = "username", required = false, defaultValue = "null") String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return userService.findUser(user);
    }

    /**
     * Get users.
     *
     * @return
     */
    @GetMapping(value = {"/all"})
    public List<User> getUsers(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                               @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit) {
        logger.info("find all users.");
        return userService.findAll(offset, limit);
    }
}

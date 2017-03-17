package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User dao interface.
 * <p>
 * Created by freecloud on 13/03/2017.
 */
@Component
public class UserDao {

    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * Insert user.
     *
     * @param user
     */
    public int insert(User user) {

        return this.sqlSession.insert("com.example.dao.UserDao.insert", user);
    }

    /**
     * Update user.
     *
     * @param user
     * @return
     */
    public int update(User user) {
        return this.sqlSession.update("com.example.dao.UserDao.update", user);
    }

    /**
     * Delete user by id.
     *
     * @param id
     * @return
     */
    public int deleteById(long id) {
        return this.sqlSession.delete("com.example.dao.UserDao.deleteById", id);
    }

    /**
     * Select all user (limit 100).
     *
     * @return
     */
    public List<User> selectAll(int offset, int limit) {
        return this.sqlSession.selectList("com.example.dao.UserDao.selectAll", null, new RowBounds(offset, limit));
    }
    
    /**
     * Select user.
     *
     * @param user
     * @return
     */
    public User selectByName(User user) {
        return this.sqlSession.selectOne("com.example.dao.UserDao.selectByParameter", user);
    }
}

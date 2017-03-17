package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * User mapper.
 * <p>
 * Created by freecloud on 13/03/2017.
 */
@Mapper
public interface UserMapper {

    /**
     * Select all.
     *
     * @return
     */
    @Select("select * from t_user")
    @Results(value = {
            @Result(id = true, column = "id", jdbcType = JdbcType.BIGINT, property = "id", javaType = Long.class),
            @Result(column = "username", jdbcType = JdbcType.VARCHAR, property = "username", javaType = String.class),
            @Result(column = "password", jdbcType = JdbcType.VARCHAR, property = "password", javaType = String.class),
            @Result(column = "created_date", jdbcType = JdbcType.DATE, property = "createdDate", javaType = Date.class)
    })
    List<User> selectAll();

    /**
     * Select user by id.
     *
     * @param id
     * @return
     */
    @Select("select * from t_user where id=#{id}")
    @Results(value = {
            @Result(id = true, column = "id", jdbcType = JdbcType.BIGINT, property = "id", javaType = Long.class),
            @Result(column = "username", jdbcType = JdbcType.VARCHAR, property = "username", javaType = String.class),
            @Result(column = "password", jdbcType = JdbcType.VARCHAR, property = "password", javaType = String.class),
            @Result(column = "created_date", jdbcType = JdbcType.DATE, property = "createdDate", javaType = Date.class)
    })
    User selectById(long id);

    /**
     * Select user by username.
     *
     * @param username
     * @return
     */
    @Select("select * from t_user where username=#{username}")
    User selectByName(String username);

    /**
     * Insert user.
     *
     * @param user
     */
    @Insert("insert into t_user (username, password, created_date) values (#{username}, #{password}, #{createdDate}）")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    /**
     * Update user by id.
     *
     * @param user
     * @return
     */
    @Update("update t_user set username = #{username}, password = #{password} where id=#{id}")
    int update(User user);

    /**
     * Delete user by id.
     *
     * @param user
     * @return
     */
    @Delete("delete from t_user where id = #{id}")
    int delete(User user);
}

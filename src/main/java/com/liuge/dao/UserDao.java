package com.liuge.dao;

import com.liuge.domain.Post;
import com.liuge.domain.Repost;
import com.liuge.domain.User;
import javafx.geometry.Pos;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  18:44
 */
public interface UserDao {
    /**
     * 登录,返回id
     * @param user
     * @return
     */
    Integer login(User user);

    /**
     * 根据用户id找到帖子
     * @param userId
     * @return
     */
    List<Post> findPostById(Integer userId);

    /**
     * 根据用户id查询回帖
     * @param userId
     * @return
     */
    List<Repost> findRepostById(Integer userId);

    /**
     * 注册
     * @param user 用户名
     * @return
     */
    Integer register(User user);

    /**
     * 检查用户名是否重复
     * @param user
     * @return
     */
    User checkUser(User user);

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    Integer updateUser(User user);
}

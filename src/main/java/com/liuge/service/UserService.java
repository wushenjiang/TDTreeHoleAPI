package com.liuge.service;

import com.liuge.domain.Post;
import com.liuge.domain.Repost;
import com.liuge.domain.User;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  18:42
 */
public interface UserService {
    /**
     * 登录,返回id
     * @param user
     * @return
     */
    Integer login(User user);

    /**
     * 根据id查看发帖
     * @param userId
     * @return
     */
    List<Post> findPostById(Integer userId);

    /**
     * 根据id查询回帖
     * @param userId
     * @return
     */
    List<Repost> findRepostById(Integer userId);

    /**
     * 注册
     * @param user
     * @return
     */
    Integer register(User user);

    /**
     * 修改用户的密码
     * @param user
     * @return
     */
    Integer updateUser(User user);
}

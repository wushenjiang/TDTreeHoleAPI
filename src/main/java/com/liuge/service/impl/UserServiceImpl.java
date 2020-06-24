package com.liuge.service.impl;

import com.liuge.dao.UserDao;
import com.liuge.domain.Post;
import com.liuge.domain.Repost;
import com.liuge.domain.User;
import com.liuge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

import java.util.List;

/**
 * @ClassName: UserImpl
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  18:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Integer login(User user) {
        Integer result = userDao.login(user);
        return result;
    }

    @Override
    public List<Post> findPostById(Integer userId) {
        List<Post> posts = userDao.findPostById(userId);
        return posts;
    }

    @Override
    public List<Repost> findRepostById(Integer userId) {
        List<Repost> reposts = userDao.findRepostById(userId);
        return reposts;
    }

    @Override
    public Integer register(User user) {
        Integer result = 0;
        User user_temp = userDao.checkUser(user);
        if (user_temp != null) {
            result = -1;
            return result;
        }
        result = userDao.register(user);
        return result;
    }

    @Override
    public Integer updateUser(User user) {
        Integer result = userDao.updateUser(user);
        if(result==1){
            return result;
        }
        return 0;
    }
}

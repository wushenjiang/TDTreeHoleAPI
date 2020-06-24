package com.liuge.service.impl;

import com.liuge.dao.RepostDao;
import com.liuge.domain.Repost;
import com.liuge.service.RepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RepostServiceImpl
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  17:44
 */
@Service
public class RepostServiceImpl implements RepostService {
    @Autowired
    RepostDao repostDao;
    @Override
    public List<Repost> findAll(int postId) {
        List<Repost> reposts = repostDao.findAll(postId);
        return reposts;
    }

    @Override
    public int addRepost(Repost repost) {
        int result = repostDao.addRepost(repost);
        return result;
    }
}

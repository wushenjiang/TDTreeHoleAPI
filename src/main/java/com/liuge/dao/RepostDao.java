package com.liuge.dao;

import com.liuge.domain.Repost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: RepostDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  17:44
 */
@Repository
public interface RepostDao {
    /**
     * 根据id读取所有回帖
     * @param postId
     * @return
     */
    List<Repost> findAll(int postId);

    /**
     * 添加回帖
     * @param repost
     * @return
     */
    int addRepost(Repost repost);
}

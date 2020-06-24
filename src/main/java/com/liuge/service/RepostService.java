package com.liuge.service;

import com.liuge.domain.Repost;

import java.util.List;

/**
 * @ClassName: RepostService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  17:44
 */
public interface RepostService {

    /**
     * 根据帖子id获取回帖
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

package com.cwll.dao;

import com.cwll.model.Post;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface PostMapper {
    List<Post> findPostByDeptId(int deptId);

    void addPost(Post post);

    void deleteDeptById(int postId);

    Post selectPostById(int postId);

    void updatePostById(Post post);
}

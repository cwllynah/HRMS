package com.cwll.service;

import com.cwll.model.Post;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface PostService {
    List<Post> listPostByDeptId(int deptId);

    boolean addPost(Post post);

    boolean deletePostById(int deptId);

    Post selectPostById(int postId);

    boolean updatePostById(Post post);
}

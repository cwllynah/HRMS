package com.cwll.service.impl;

import com.cwll.dao.PostMapper;
import com.cwll.model.Post;
import com.cwll.service.PostService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
@Transactional
@Component
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;

    @Override
    public List<Post> listPostByDeptId(int deptId) {
        return postMapper.findPostByDeptId(deptId);
    }

    @Override
    public boolean addPost(Post post) {
        post.setCreatetime(new Date());
        postMapper.addPost(post);
        return true;
    }

    @Override
    public boolean deletePostById(int postId) {
        postMapper.deleteDeptById(postId);
        return true;
    }

    @Override
    public Post selectPostById(int postId) {

        return postMapper.selectPostById(postId);
    }

    @Override
    public boolean updatePostById(Post post) {
        postMapper.updatePostById(post);
        return true;
    }
}

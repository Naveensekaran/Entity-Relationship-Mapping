package com.example.onetomany.controller;

import com.example.onetomany.model.Comment;
import com.example.onetomany.model.Post;
import com.example.onetomany.repository.CommentRepo;
import com.example.onetomany.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private CommentRepo cmrepo;
    @Autowired
    private PostRepo pstrepo;

    @PostMapping("/demo")
    public String demo(){
        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setDescription("Description of Post1");

        List<Comment> cmd = new ArrayList();
        Comment comment1 = new Comment();
        comment1.setText("comment 1 for post 1");
        comment1.setPost(post1);

        Comment comment2 = new Comment();
        comment2.setText("comment 2 for post 1");
        comment2.setPost(post1);

        cmd.add(comment1);
        cmd.add(comment2);
        post1.setComments(cmd);

        pstrepo.save(post1);
        cmrepo.save(comment1);
        cmrepo.save(comment2);
        return "naveen";
    }
}

package com.riwi.querertourapi.infrastructure.services;

import com.riwi.querertourapi.api.dto.request.CommentRequest;
import com.riwi.querertourapi.api.dto.response.CommentResponse;
import com.riwi.querertourapi.api.dto.response.UserResponse;
import com.riwi.querertourapi.domain.entities.Comment;
import com.riwi.querertourapi.domain.entities.User;
import com.riwi.querertourapi.domain.repositories.CommentRepository;
import com.riwi.querertourapi.domain.repositories.UserRepository;
import com.riwi.querertourapi.infrastructure.abstract_services.ICommentService;
import com.riwi.querertourapi.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CommentResponse create(CommentRequest request) {
        User user = this.userRepository.findById(request.getUser_id()).orElseThrow(() -> new IdNotFoundException("User"));

        Comment comment = this.requestToComment(request, new Comment());
        comment.setUser(user);

        return this.entityToResponse(this.commentRepository.save(comment));
    }

    @Override
    public CommentResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public CommentResponse update(Long id, CommentRequest request) {
        Comment comment = this.find(id);
        User user = this.userRepository.findById(request.getUser_id()).orElseThrow(() -> new IdNotFoundException("User"));
        comment = this.requestToComment(request, comment);
        comment.setUser(user);

        return this.entityToResponse(this.commentRepository.save(comment));
    }

    @Override
    public void delete(Long id) {
        Comment comment = this.find(id);
        this.commentRepository.delete(comment);

    }

    @Override
    public Page<CommentResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page,size);

        return this.commentRepository.findAll(pagination).map(comment -> this.entityToResponse(comment));
    }

    private CommentResponse entityToResponse(Comment entity) {
        CommentResponse response = new CommentResponse();
        BeanUtils.copyProperties(entity, response);

        UserResponse user = new UserResponse();
        BeanUtils.copyProperties(entity.getUser(), user);

        response.setUser(user);
        return response;
    }
    private  Comment requestToComment(CommentRequest request, Comment entity) {
        BeanUtils.copyProperties(request, entity);
        return entity;
    }
    private Comment find(Long id) {
        return this.commentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Comment"));
    }
}

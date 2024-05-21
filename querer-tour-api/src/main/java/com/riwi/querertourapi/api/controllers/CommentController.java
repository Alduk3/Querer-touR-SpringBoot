package com.riwi.querertourapi.api.controllers;


import com.riwi.querertourapi.api.dto.request.CommentRequest;
import com.riwi.querertourapi.api.dto.response.CommentResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/comment")
@AllArgsConstructor
public class CommentController {

    @Autowired
    private ICommentService commentService;

    
    @GetMapping
    public ResponseEntity<Page<CommentResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size ) {
        return ResponseEntity.ok(this.commentService.getAll(page -1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.commentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> insert( @Validated @RequestBody CommentRequest commentRequest){
        return ResponseEntity.ok(this.commentService.create(commentRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable Long id ,@Validated @RequestBody CommentRequest commentRequest){
        return ResponseEntity.ok(this.commentService.update(id, commentRequest));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Comment deleted");
        this.commentService.delete(id);
        return ResponseEntity.ok(response);
    }
}

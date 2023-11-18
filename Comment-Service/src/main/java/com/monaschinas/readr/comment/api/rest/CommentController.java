package com.monaschinas.readr.comment.api.rest;

import com.monaschinas.readr.comment.domain.service.CommentService;
import com.monaschinas.readr.comment.mapping.CommentMapper;
import com.monaschinas.readr.comment.resource.CommentResource;
import com.monaschinas.readr.comment.resource.CreateCommentResource;
import com.monaschinas.readr.comment.resource.UpdateCommentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/publishing/comments", produces = "application/json")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper mapper;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper mapper){
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CommentResource> getAllComments(Pageable pageable){
        return mapper.modelListPage(commentService.getAll(), pageable);
    }
    @GetMapping("/by-profile/{profileId}")
    public Page<CommentResource> getCommentsByProfileId(@PathVariable Long profileId, Pageable pageable){
        return mapper.modelListPage(commentService.getByProfileId(profileId), pageable);
    }
    @GetMapping("{commentId}")
    public CommentResource getCommentById(@PathVariable Long commentId){
        return mapper.toResource(commentService.getById(commentId));
    }

    @PostMapping
    public CommentResource createComment(@RequestBody CreateCommentResource resource){
        return mapper.toResource(commentService.create(mapper.toModel(resource)));
    }

    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentResource resource){
        return mapper.toResource(commentService.update(commentId, mapper.toModel(resource)));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId){
        return commentService.delete(commentId);
    }
}
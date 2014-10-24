/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Comment;
import java.util.Date;

public class CommentFactory {
    public Comment getComment(String comm, int projectId, int taslId, int userId){
        Comment comment = new Comment();
        Date d = new Date();
        comment.setComment(comm);
        comment.setProjectId(projectId);
        comment.setCreateDate(d);
        comment.setTaskId(taslId);
        comment.setUserId(userId);
        return comment;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Attachment;
import java.util.Date;

public class AttachmentFactory {
    public Attachment getAttachment(String name, String attach, 
            Integer projectId, Integer taskId, Integer userId){
        Attachment attachment = new Attachment();
        Date d = new Date();
        attachment.setAttachmentName(name);
        attachment.setAttachment(attach);
        attachment.setCreateDate(d);
        attachment.setProjectId(projectId);
        attachment.setTaskId(taskId);
        attachment.setUserId(userId);
        return attachment;
    }
}

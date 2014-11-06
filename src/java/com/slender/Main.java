/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender;

import com.slender.app.factory.AttachmentFactory;
import com.slender.domain.Attachment;
import com.slender.domain.Company;
import com.slender.domain.Users;
import com.slender.service.crud.AttachmentCrud;
import com.slender.service.crud.CompanyCrud;
import com.slender.service.crud.UserCrud;
import com.slender.service.crud.impl.AttachmentCrudImpl;
import com.slender.service.crud.impl.CompanyCrudImpl;
import com.slender.service.crud.impl.UserCrudImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AttachmentCrudImpl attachmentCrud = new AttachmentCrudImpl();
        AttachmentFactory attachmentsFactory = new AttachmentFactory();
        Attachment attachment = attachmentsFactory.getAttachment("Return", "Return", null, 0, 0);
        System.out.println(attachment.getId());
        Attachment attachmen = attachmentsFactory.getAttachment("Return", "Return", null, 0, 0);
        System.out.println(attachmen.getId());
        System.out.println(attachmentCrud.persist(attachment).getAttachmentName());
        
        //List<Users> users = new ArrayList();
        //UserCrud userCrud = new UserCrudImpl();
        //users = userCrud.findAll();
        //List<Company> companies = new ArrayList();
        //CompanyCrud companyCrud = new CompanyCrudImpl();
        //users = userCrud.findAll();
        //for(int i = 0; i < users.size(); i++){
         //   System.out.println(companyCrud.findById(users.get(i).getCompanyId()).getCompanyName());
          //  System.out.println(users.get(i).getEmail());
        //}
    }
}

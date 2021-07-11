/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userCRUD.rest.controller;

import com.example.userCRED.rest.beanspack.MainUserBean;
import com.example.userCRUD.bases.Output_Base;
import com.example.userCRUD.bases.UserInfo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author lpt-2030
 */

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControllerWrapper {
    
    //GET COMPLETE LIST OF USERS
    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public Output_Base getUsers (HttpServletRequest request) {
        
        MainUserBean mainUserBean = new MainUserBean();
        Output_Base users = (Output_Base) mainUserBean.getUsersList();
        users.setMessage("List !!!");
        return users;
        
    }
    
    //GET USER BY ID
    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public UserInfo getUsers (@PathVariable int id, HttpServletRequest request) {
        
        MainUserBean mainUserBean = new MainUserBean();
        Optional<UserInfo> userVal = mainUserBean.getUserById(id);
        if(userVal.isPresent()){
            return userVal.get();
        }else{
            userVal.get().setMessage("User Not Found !!!");
        }
        return userVal.get();
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/adduser")
    public Output_Base postAddUser (@RequestBody UserInfo input, HttpServletRequest request) {
        
        MainUserBean mainUserBean = new MainUserBean();
        Output_Base outMssg = mainUserBean.addUser(input);
        return outMssg;
        
    }
    
    //Update UserInfo
    @RequestMapping(method = RequestMethod.PUT, path = "/updateuser")
    public Output_Base putUpdateUser (@RequestBody UserInfo input, HttpServletRequest request) {
        
        MainUserBean mainUserBean = new MainUserBean();
        Output_Base outMssg = mainUserBean.addUser(input);
        return outMssg;
        
    }
    
    //Delete User
    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteuser/{id}")
    public Output_Base putUpdateUser (@PathVariable int id, HttpServletRequest request) {
        
        MainUserBean mainUserBean = new MainUserBean();
        Output_Base outMssg = mainUserBean.deleteUser(id);
        return outMssg;
        
    }
}

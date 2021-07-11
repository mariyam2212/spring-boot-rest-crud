/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userCRED.rest.beanspack;

import com.example.userCRUD.bases.Output_Base;
import com.example.userCRUD.bases.UserInfo;
import com.example.userCRUD.rest.model.User_Output;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author lpt-2030
 */
public class MainUserBean {

    List<UserInfo> arr_users = new ArrayList<>();
    List<String> cities = new ArrayList<>(List.of("Delhi", "Mumbai", "Bangalore", "Noida", "Pune"));
    List<String> contacts = new ArrayList<>(List.of("9826382917", "9998827362", "9918262909", "8756482976", "8882659037"));
    List<String> emails = new ArrayList<>(List.of("david123@gmail.com", "albertHash@gmail.com", "becky.1299@gmail.com", "mary12rose@gmail.com", "henry_cavil@gmail.com"));

    public MainUserBean() {
    }

    public User_Output getUsersList() {

        User_Output outputUsers = new User_Output();
        initialiseUserList();
        outputUsers.setUsers(arr_users);
        return outputUsers;

    }

    public Optional<UserInfo> getUserById(int id) {

        for (UserInfo uI : arr_users) {
            if (uI.getId() == id) {
                return Optional.of(uI);
            }
        }
        return Optional.ofNullable(null);
    }

    public Output_Base addUser(UserInfo input) {
        Output_Base output = new Output_Base();
        int id = chechIfEmailAlreadyAdded(input);
        String message = "";
        if (id != -1) {
            int max_id = getMaxId()+1;
            input.setId(max_id);
            arr_users.add(input);
            message = "User added successfully ---- ID = " + max_id;
        } else {
            message = "User with same email already added !!!";
        }
        output.setMessage(message);
        return output;
    }

    public Output_Base updateUser(UserInfo input) {
        String message = "";
        Output_Base output = new Output_Base();
        Optional<Integer> isUserPresent = checkAndGetIdPosition(input.getId());
        if (isUserPresent.isPresent()) {
            arr_users.add(isUserPresent.get(),input);
            message = "User info updated successfully ---- ID = " + isUserPresent.get();
        } else {
            message = "No user with specified id present !!!";
        }
        output.setMessage(message);
        return output;
    }
    
    public Output_Base deleteUser(int id) {
        String message = "";
        Output_Base output = new Output_Base();
        Optional<Integer> isUserPresent = checkAndGetIdPosition(id);
        if (isUserPresent.isPresent()) {
            int removepos = isUserPresent.get();
            arr_users.remove(removepos);
            message = "User deleted successfully !!!";
        } else {
            message = "No user with specified id present !!!";
        }
        output.setMessage(message);
        return output;
    }
    
    public void initialiseUserList () {
        for (int i = 0; i < 5; i++) {
            UserInfo objU = new UserInfo(i, "User_" + i, emails.get(i), contacts.get(i), cities.get(i), "SDE_" + i);
            arr_users.add(objU);
        }        
    }
    
    public int chechIfEmailAlreadyAdded(UserInfo input) {

        List<String> email_list = arr_users.stream().map(user -> user.getEmail()).collect(Collectors.toList());
        if (email_list.contains(input.getEmail())) {
            return -1;
        }
        return 0;
        
    }

    public int getMaxId() {
        return arr_users.stream().map(user -> user.getId()).max(Integer::compare).get();
    }

    public Optional<Integer> checkAndGetIdPosition(int id) {
        for (int i = 0; i < arr_users.size(); i++) {
            UserInfo user = arr_users.get(id);
            if (user.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.ofNullable(null);
    }
}

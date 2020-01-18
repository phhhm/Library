package controller;

import model.User;
import service.UserService;

import java.util.List;

public class UserController {

    UserService userService = new UserService();

    public void register(User user){
        userService.register(user);
    }

    public User login(String username, String password) {
        return userService.login(username, password);
    }

    public User search(int id) {
        return userService.search(id);
    }

    public List<User> findAll(){
        return userService.findAll();
    }

    public void update(User user){
        userService.update(user);
    }

    public void deleteById(int id){
        userService.deleteById(id);
    }

    public void deleteByUsername(String username){
        userService.deleteByUsername(username);
    }

}

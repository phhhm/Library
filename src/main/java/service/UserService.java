package service;

import repository.LibraryRepository;
import model.User;
import utility.Encryptor;
import utility.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public void register(User user){
        User u = null;
        try {
            u = LibraryRepository.getInstance().userDao.searchByUsername(user.getUsername());
            if(u != null)
                return;
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        try {
            user.setPassword(Encryptor.getMd5(user.getPassword()));
            LibraryRepository.getInstance().userDao.insert(user);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public User search(int id) {
        try {
            return LibraryRepository.getInstance().userDao.searchById(id);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return new User();
    }

    public User login(String username, String password) {
        User u = null;
        try {
            u = LibraryRepository.getInstance().userDao.searchByUsername(username);
            if(username.equals(u.getUsername()) && Encryptor.getMd5(password).equals(u.getPassword())) {
                if(u.isStatus())
                    return u;
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return new User();
    }

    public List<User> findAll(){
        try {
            return LibraryRepository.getInstance().userDao.findAll();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return null;
    }

    public void update(User user){
        try {
            LibraryRepository.getInstance().userDao.update(user);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public void deleteById(int id){
        try {
            LibraryRepository.getInstance().userDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByUsername(String username){
        try {
            User user = LibraryRepository.getInstance().userDao.searchByUsername(username);
            deleteById(user.getId());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

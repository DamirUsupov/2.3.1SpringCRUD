package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static UserService userService;

    @Autowired
    private UserDAO userDAO;

    public static UserService getInstance() {
        return userService;
    }


    @Transactional
    @Override
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();

    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {

        return userDAO.getUserById(id);

    }
}

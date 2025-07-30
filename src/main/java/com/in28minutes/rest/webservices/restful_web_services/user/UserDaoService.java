package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(24)));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findOne(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void deleteUserById(int id) {
       User deletedUser = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if(deletedUser != null){
            users.remove(deletedUser);
        }else{
            throw new UserNotFoundException("id: "+ id);
        }
    }
}

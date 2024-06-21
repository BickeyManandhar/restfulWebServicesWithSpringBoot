package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static{
        users.add(new User(++usersCount,"Akash", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Prakash", LocalDate.now().minusYears(23)));
        users.add(new User(++usersCount,"Bikash", LocalDate.now().minusYears(40)));
        users.add(new User(++usersCount,"Jhakash", LocalDate.now().minusYears(32)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int user_id) {
        Predicate<? super User> predicate = user -> user.getId().equals(user_id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public boolean deleteUserById(int userId) {
        Predicate<? super User> predicate = user -> user.getId().equals(userId);
        return users.removeIf(predicate);
    }
}

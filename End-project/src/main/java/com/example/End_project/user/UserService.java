package com.example.End_project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        if (user.getFirstName() == null || user.getLastName() == null || user.getAge() == null || user.getEmail() == null || user.getAddress() == null) {
            System.out.println("UserService say: It's impossible to create a new user without all the user details!");
            return null;
        }
        if (userRepository.getByEmailHelper(user.getEmail()) != null){
            System.out.println("UserService say: User with this email already registered!");
            return null;
        }
        return userRepository.create(user);
    }

    public User updateUser(User user){
        User existingUser = userRepository.getByEmailHelper(user.getEmail());

        if (existingUser == null){
            System.out.println("UserService say: User with this email doesn't exist!");
            return null;
        }
        if (user.getFirstName() == null){
            user.setFirstName(existingUser.getFirstName());
        }
        if (user.getLastName() == null){
            user.setLastName(existingUser.getLastName());
        }
        if (user.getAge() == null){
            user.setAge(existingUser.getAge());
        }
        if (user.getAddress() == null){
            user.setAddress(existingUser.getAddress());
        }
        return userRepository.update(user);
    }

    public User getUser(int id){
        if (userRepository.getById(id) == null){
            System.out.println("UserService say: User with this id does not exist!");
            return null;
        }
        return userRepository.getById(id);
    }

    public User getUser(String email){
        if (userRepository.getByEmailHelper(email) == null){
            System.out.println("UserService say: Customer with this email does not exist!");
            return null;
        }
        return userRepository.getByEmailHelper(email);
    }

    public String deleteUser(int id){
        if (userRepository.getById(id) == null){
            //If a user delete himself from your system, all the answers he gave to any
            //question should be deleted as well!!!
            return "UserService say: Customer with this email doesn't exist!";
        }
        return userRepository.deleteById(id);
    }

    public String deleteUser(String email){
        if (userRepository.getByEmailHelper(email) == null){
            //If a user delete himself from your system, all the answers he gave to any
            //question should be deleted as well!!!
            return "UserService say: Customer with this email doesn't exist!";
        }
        return userRepository.deleteByEmail(email);
    }
}

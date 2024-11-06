package com.example.End_project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private static final String USER_TABLE = "users";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, AGE, ADDRESS)
    //VALUES ('Aharon', 'Zardav', 'aharonzardav8@gmail.com', 23, 'Lod, lea goldberg 3');
    public User create(User user){
        try {
            String sql = "INSERT INTO "+USER_TABLE+" (first_name, last_name, email, age, address, joining_date) VALUES(?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate());
            return getByEmailHelper(user.getEmail());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE users SET first_name = 'aharon', last_name = 'zardav', email = 'aharonzardav@gmail.com' , age = 23, address = 'Lod, lea goldberg 3'
    // WHERE id = 1
    public User update(User user){
        try {
            String sql = "UPDATE " +USER_TABLE+ " SET first_name = ?, last_name = ?, email = ?, age = ?, address = ? WHERE id = ?";
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), getIdByEmailHelper(user.getEmail()));
            return getByEmailHelper(user.getEmail());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //SELECT * FROM users WHERE id = 1
    public User getById(Integer id){
        try {
            String sql = "SELECT * FROM "+USER_TABLE+" WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getByEmailHelper(String email){
        try {
            String sql = "SELECT * FROM " + USER_TABLE + " WHERE email = ?";
            return jdbcTemplate.queryForObject(sql, new UserMapper(), email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //DELETE FROM users WHERE id = 1
    public String deleteById(int id) {
        try {
            String sql = "DELETE FROM " + USER_TABLE + " WHERE id = ?";
            jdbcTemplate.update(sql, id);
            return "The user with id " + id + " deleted successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String deleteByEmail(String email) {
        try {
            String sql = "DELETE FROM " + USER_TABLE + " WHERE email = ?";
            jdbcTemplate.update(sql, email);
            return "The user with email " + email + " deleted successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public int getIdByEmailHelper(String email){
        try{
            String sql = "SELECT id FROM " + USER_TABLE + " WHERE email = ?";
            Integer id = jdbcTemplate.queryForObject(sql, Integer.class, email);
            if (id == null) {
                System.out.println("No user found with the provided email.");
                return -1;
            }
            return id;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}

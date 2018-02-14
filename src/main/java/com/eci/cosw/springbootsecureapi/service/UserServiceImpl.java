package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


  
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "test@mail.com", "password", "Andres", "Perez","https://cdn1.iconfinder.com/data/icons/crimes-and-justice/100/14-128.png" ) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( Long id ) {
        User user =null;
        for (User u : users ){
            if(u.getId()==id){
                user=u;
            }
        }
        return user;
    }

    @Override
    public User createUser( User user ) {
        users.add(user);
        return user;
    }

    @Override
    public User findUserByEmail( String email ) {
        User user =null;
        for (User u : users ){
            if(u.getEmail().equals(email)){
                user=u;
            }
        }
        return user;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password ) {
        User user =null;
        for (User u : users ){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                user=u;
            }
        }
        return user;
    }

}

package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;


    @CrossOrigin
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        User user = userService.getUser( 0l );

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET )
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @CrossOrigin
    @RequestMapping( value = "/ById.{id}", method = RequestMethod.GET )
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @CrossOrigin
    @RequestMapping( value = "/ByEmail.{email}", method = RequestMethod.GET )
    public User findUserByEmail(@PathVariable String email) throws ServletException {
        System.out.print(email);
        User user = userService.findUserByEmail(email);
        System.out.print(user.toString());
        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }
        return user;
    }

    @CrossOrigin
    @RequestMapping( value = "/ByEmailAndPassword.{email}.{password}", method = RequestMethod.GET )
    public User findUserByEmailAndPassword(@PathVariable String email,@PathVariable String password) {
        return userService.findUserByEmailAndPassword(email,password);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST )
    public User createUser(@RequestBody User user ) {
        return userService.createUser(user);
    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}

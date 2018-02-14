package com.eci.cosw.springbootsecureapi.model;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class User
{

    private long id;

    private String email;

    private String password;

    private String lastname;

    private String name;

    private String username;

    private String image;


    public User()
    {
    }

    public User( String email, String password, String name, String lastname, String image )
    {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
    }


    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setname( String name )
    {
        this.name = name;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage( String image )
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", image='" + image + '\'' + ", password='" + password + '\'' + ", name='"
            + name + '\'' + '}';
    }
}

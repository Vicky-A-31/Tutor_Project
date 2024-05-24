package com.Web;

// This class for All the details of Tutor
public class Tutor 
{
    private String username;
    private String password;
    private String profilename;
    private int beforehour;
    private int beforeminute;
    private int afterhour;
    private int afterminute;

    public Tutor() 
    {
    }

    // This constructor is used to delete the tutor
    public Tutor(String username)
    {
        this.username = username;
    }
    
    // This constructor is used to login the tutor
    public Tutor(String username, String password) 
    {
        this.username = username;
        this.password = password;
    }

    public Tutor(String username, String password, String profilename, int beforehour, int beforeminute, int afterhour, int afterminute) {
        this.username = username;
        this.password = password;
        this.profilename = profilename;
        this.beforehour = beforehour;
        this.beforeminute = beforeminute;
        this.afterhour = afterhour;
        this.afterminute = afterminute;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilename() {
        return profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public int getBeforehour() {
        return beforehour;
    }

    public void setBeforehour(int beforehour) {
        this.beforehour = beforehour;
    }

    public int getBeforeminute() {
        return beforeminute;
    }

    public void setBeforeminute(int beforeminute) {
        this.beforeminute = beforeminute;
    }

    public int getAfterhour() {
        return afterhour;
    }

    public void setAfterhour(int afterhour) {
        this.afterhour = afterhour;
    }

    public int getAfterminute() {
        return afterminute;
    }

    public void setAfterminute(int afterminute) {
        this.afterminute = afterminute;
    }
    
    

}
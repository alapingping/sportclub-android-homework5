package com.sports.sportclub.DataModel;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by 16301 on 2018/10/30 0030.
 *
 * the User Model for the app
 * include:
 * String: UserName
 * String: UserEmail
 * String: UserPass
 */

public class User extends BmobUser {

    //this is name of user
    private String UserName;
    //the email of user
    private String UserEmail;
    //the password of User
    private String UserPass;

    public User(String userEmail, String userPass){
        this.UserName = userEmail;
        this.UserPass = userPass;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }
}

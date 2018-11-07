package com.sports.sportclub.DataModel;

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

    public User(String userName, String userPass){
        super();
        super.setUsername(userName);
        super.setPassword(userPass);
    }



}

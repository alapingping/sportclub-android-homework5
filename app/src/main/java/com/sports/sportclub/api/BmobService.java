package com.sports.sportclub.api;

/**
 * Created by 16301 on 2018/10/30 0030.
 */

import com.sports.sportclub.DataModel.User;

import retrofit2.Call;
import retrofit2.http.*;

public interface BmobService {

    @Headers("apikey:918a3c131997a216e99fd565230832f5")



    Call<User> getSessionByUsername(@Query("Email") String email, @Query("password") String password);
}

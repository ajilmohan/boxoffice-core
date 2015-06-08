package com.href.biz.tiz.proxy;

import com.href.biz.tiz.domain.User;

public interface UserProxy extends BaseProxy<User> {

	 User getUserByCredentials(String name , String pass);
}

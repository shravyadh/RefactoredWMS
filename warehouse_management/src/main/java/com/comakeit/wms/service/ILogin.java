package com.comakeit.wms.service;

import com.comakeit.wms.bean.Login;

public interface ILogin {
	Login validate(Login login) throws Exception;
}

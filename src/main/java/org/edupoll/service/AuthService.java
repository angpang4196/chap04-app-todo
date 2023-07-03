package org.edupoll.service;

import org.springframework.stereotype.Service;

@Service // 데이터를 처리하는 코드가 있는 곳
public class AuthService {

	public boolean isValidate(String id, String pass) {

		if ((id.equals("master") || id.equals("test") || id.equals("user")) && pass.equals("1q2w3e4r")) {
			return true;
		} else {
			return false;
		}

	}

}

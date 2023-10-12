package com.assingment.RestaurentManagement.Service;

import com.assingment.RestaurentManagement.Model.AuthenticationToken;
import com.assingment.RestaurentManagement.Repo.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    @Autowired
    IAuthTokenRepo iAuthTokenRepo;

    public void saveAuthToken(AuthenticationToken auth) {

        iAuthTokenRepo.save(auth);
    }

    public boolean authenticate(String email, String token) {
        AuthenticationToken authToken = iAuthTokenRepo.findFirstByTokenValue(token);
        if(authToken == null) {
            return false;
        }
        String tokenConnectedEmail = authToken.getUser().getUserEmail();
        return tokenConnectedEmail.equals(email);
    }
}

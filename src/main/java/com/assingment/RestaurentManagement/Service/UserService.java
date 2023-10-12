package com.assingment.RestaurentManagement.Service;

import com.assingment.RestaurentManagement.Model.AuthenticationToken;
import com.assingment.RestaurentManagement.Model.User;
import com.assingment.RestaurentManagement.Model.dto.SignInInput;
import com.assingment.RestaurentManagement.Model.dto.SignUpOutput;
import com.assingment.RestaurentManagement.Repo.IUserRepo;
import com.assingment.RestaurentManagement.Service.HashingUtility.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthTokenService authTokenService;

    public SignUpOutput signUpUser(User user) {
        boolean signUpStatus = true;
        String signUpStatusMessage = "";

        String newEmail = user.getUserEmail();

        if(newEmail == null) {
            signUpStatus = false;
            signUpStatusMessage = "Please enter a Valid email";

            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
        User existingUser = iUserRepo.findFirstByUserEmail(newEmail);

        try {
            String encryptedPassword = PasswordEncryptor.encryptPassword(user.getUserPassword());
            user.setUserPassword(encryptedPassword);
            iUserRepo.save(user);

            signUpStatusMessage = "Please enter a Valid email";
            return new SignUpOutput(signUpStatus,signUpStatusMessage);

        } catch (NoSuchAlgorithmException e) {
            signUpStatus = false;
            signUpStatusMessage = "Unauthorized Credential";

            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

    }

    public String signInUser(SignInInput signInInput) {
        String email = signInInput.getEmail();

        if(email == null) {
            return "Please enter a valid email";
        }

        User existingUser = iUserRepo.findFirstByUserEmail(signInInput.getEmail());
        if(existingUser == null) {
            return "Email not registered";
        }

        try {
            String encryptedPassword = PasswordEncryptor.encryptPassword(signInInput.getPassword());

            if(existingUser.getUserPassword().equals(encryptedPassword)) {
                AuthenticationToken auth = new AuthenticationToken(existingUser);
                authTokenService.saveAuthToken(auth);
                return "Signed In Successfully";
            }else {
                return "Invalid Credential";
            }

        } catch (NoSuchAlgorithmException e) {
            return "Internal server issue, try again later";
        }

    }
}

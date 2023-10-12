package com.assingment.RestaurentManagement.Service;

import com.assingment.RestaurentManagement.Model.Admin;
import com.assingment.RestaurentManagement.Model.dto.SignInInput;
import com.assingment.RestaurentManagement.Repo.IAdminRepo;
import com.assingment.RestaurentManagement.Service.HashingUtility.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {
    @Autowired
    IAdminRepo iAdminRepo;

    public String adminSingUp(Admin admin) {
        String email = admin.getAdminEmail();

        if(email == null) {
            return "Enter a valid email";
        }
        Admin existingEmail = iAdminRepo.findFirstByAdminEmail(email);
        if(existingEmail != null) {
            return "Email already in use, Please try with different email";
        }
        try {

            String encryptedPassword = PasswordEncryptor.encryptPassword(admin.getAdminPassword());
            admin.setAdminEmail(encryptedPassword);
            iAdminRepo.save(admin);
            return "New admin registered";

        } catch (NoSuchAlgorithmException e) {
            return "UnAuthorised Credential";
        }
    }

    public boolean ifAdminExistOrNot(String adminEmail) {
        Admin existEmail = iAdminRepo.findFirstByAdminEmail(adminEmail);
        return existEmail != null;
    }
}

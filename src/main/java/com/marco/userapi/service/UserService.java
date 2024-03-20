package com.marco.userapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.userapi.model.User;
import com.marco.userapi.repository.UserRepository;

@Service
public class UserService {

        @Autowired
            UserRepository usrRepository;        

      //CREATE 
        public User createUser(User usr) {
         return usrRepository.save(usr);
        }

        //READ
        public List<User> getUsers() {
         return usrRepository.findAll();
        }
        
        //GET SINGLE
        public Optional<User> getUser(Long usrId) {
        	return usrRepository.findById(usrId);
        }

        //DELETE
        public void deleteUser(Long usrId) {
         usrRepository.deleteById(usrId);
        }
        
     // UPDATE
        public User updateUser(Long usrId, User userDetails) {
                User usr = usrRepository.findById(usrId).get();
                usr.setFirstName(userDetails.getFirstName());
                usr.setLastName(userDetails.getLastName());
                usr.setEmailId(userDetails.getEmailId());
                usr.setPassword(userDetails.getPassword());
                
                return usrRepository.save(usr);                                
        }

}


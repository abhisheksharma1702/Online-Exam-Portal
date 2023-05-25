package com.userManager.userManager.services;

import com.userManager.userManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.userManager.userManager.entity.User;

@Service
public class userDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         User user=this.userRepository.findByEmail(s);
         if(user==null)
         {
             System.out.println("User not found exception");
             throw new UsernameNotFoundException("No user found");
         }
         return user;
    }
}

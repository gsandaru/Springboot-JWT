package com.gihan.jwtspringtest;

import com.gihan.jwtspringtest.config.JwtTokenUtil;
import com.gihan.jwtspringtest.model.JwtRequest;
import com.gihan.jwtspringtest.model.JwtResponse;
import com.gihan.jwtspringtest.model.UserDTO;
import com.gihan.jwtspringtest.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class helloworldController{

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

}





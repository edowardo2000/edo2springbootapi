package com.juaracoding.edo2springbootrestapi.controller;

import com.juaracoding.edo2springbootrestapi.configuration.OtherConfiguration;
import com.juaracoding.edo2springbootrestapi.dto.UsrDTO;
import com.juaracoding.edo2springbootrestapi.handler.ResponseHandler;
import com.juaracoding.edo2springbootrestapi.model.Usr;
import com.juaracoding.edo2springbootrestapi.service.UsrService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/op")
public class OpenController {

    private UsrService usrService;
    private ModelMapper modelMapper;
    /*
        Wajib di class controller agar tidak terjadi cycle
     */
    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public OpenController(UsrService usrService, ModelMapper modelMapper, AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usrService = usrService;
        this.modelMapper = modelMapper;
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/v1/gt")
    public ResponseEntity<Object> getToken(@RequestBody UsrDTO usrDTO, HttpServletRequest request) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usrDTO.getUserName(),
                            usrDTO.getPassword()+ OtherConfiguration.getFlagPwdTrap()
                    )
            );
        }catch (BadCredentialsException e)
        {
            return new ResponseHandler().generateResponse(
                    "Otentikasi Gagal",//message
                    HttpStatus.UNAUTHORIZED,//httpstatus
                    null,//object
                    "FE-auth006",
                    request
            );
        }

        return usrService.authManager(usrDTO,request);
    }

    @PostMapping("/v1/regis")
    public ResponseEntity<Object> regis(@RequestBody UsrDTO usrDTO, HttpServletRequest request)
    {

        Usr usr = modelMapper.map(usrDTO, new TypeToken<Usr>() {}.getType());;

        return usrService.registrationUser(usr,request);
    }
}

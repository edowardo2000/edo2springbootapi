package com.juaracoding.edo2springbootrestapi.service;

import com.juaracoding.edo2springbootrestapi.configuration.OtherConfiguration;
import com.juaracoding.edo2springbootrestapi.core.security.JwtUtility;
import com.juaracoding.edo2springbootrestapi.dto.UsrDTO;
import com.juaracoding.edo2springbootrestapi.handler.RequestCapture;
import com.juaracoding.edo2springbootrestapi.handler.ResponseHandler;
import com.juaracoding.edo2springbootrestapi.model.Usr;
import com.juaracoding.edo2springbootrestapi.repo.LogRequestRepo;
import com.juaracoding.edo2springbootrestapi.repo.UsrRepo;
import com.juaracoding.edo2springbootrestapi.util.LogTable;
import com.juaracoding.edo2springbootrestapi.util.LoggingFile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UsrService implements UserDetailsService {

    private UsrRepo usrRepo;
    private JwtUtility jwtUtility;
    private String [] strExceptionArr = new String[2];
    @Autowired
    private LogRequestRepo logRequestRepo;

    @Autowired
    private ModelMapper modelMapper;

    private User user;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsrService(UsrRepo usrRepo, JwtUtility jwtUtility) {
        strExceptionArr[0] = "UsrService";
        this.usrRepo = usrRepo;
        this.jwtUtility = jwtUtility;
    }


//    @Autowired
//    public UsrService(UsrRepo usrRepo, JwtUtility jwtUtility, AuthenticationManager authenticationManager) {
//        this.usrRepo = usrRepo;
//        this.jwtUtility = jwtUtility;
//        this.authenticationManager = authenticationManager;
//    }

    public ResponseEntity<Object> registrationUser(Usr usr, HttpServletRequest request){//RANGE 001-005
        try{
            if(usr==null)
            {
                return new ResponseHandler().generateResponse(
                        "Data tidak Valid",//message
                        HttpStatus.BAD_REQUEST,//httpstatus
                        null,//object
                        "FV-Auth001",
                        request
                );
            }
            usr.setPassword(bCryptPasswordEncoder.encode(usr.getPassword()+OtherConfiguration.getFlagPwdTrap()));//encrypt password sebelum ke database
            usrRepo.save(usr);
        }
        catch (Exception e)
        {
            strExceptionArr[1] = "registrationUser(Usr usr, HttpServletRequest request) --- LINE 69 \n"+ RequestCapture.allRequest(request);
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfiguration.getFlagLoging());
            LogTable.inputLogRequest(logRequestRepo,strExceptionArr,e,OtherConfiguration.getFlagLogTable());
            return new ResponseHandler().generateResponse(
                    "Data Gagal Disimpan",//message
                    HttpStatus.INTERNAL_SERVER_ERROR,//httpstatus
                    null,//object
                    "FE-Auth001",//errorCode Fail Error modul-code 001 sequence 001 range 001 - 010
                    request
            );
        }

        return new ResponseHandler().generateResponse(
                "Registrasi Berhasil",//message
                HttpStatus.CREATED,//httpstatus created
                null,
                null,
                request
        );
    }

    public ResponseEntity<Object> authManager(UsrDTO usrDTO, HttpServletRequest request)//RANGE 006-010
    {
        UserDetails userDetails = loadUserByUsername(usrDTO.getUserName());

        if(usrDTO==null)
        {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid",//message
                    HttpStatus.BAD_REQUEST,//httpstatus
                    null,//object
                    "FV-Auth006",
                    request
            );
        }

        /*
            Isi apapun yang perlu diisi disini !!
         */
        Map<String,Object> mapz = new HashMap<>();
        mapz.put("barang","1-0-1");
        mapz.put("supplier","111");
        mapz.put("kategoribarang","011");


        String token =
                jwtUtility.generateToken(userDetails,mapz);

        return new ResponseHandler().generateResponse(
                "Otentikasi Berhasil",//message
                HttpStatus.OK,//httpstatus created
                token,//object
                null,//errorCode diisi null ketika data berhasil disimpan
                request
        );
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = null;
        Optional<Usr> optionalUsr = usrRepo.findByUserNameOrNoHpOrEmail(userName, userName, userName);

        if (optionalUsr.isEmpty()) {
            return user;
        }
        Usr usr = optionalUsr.get();
//        $2a$11$Owf6JAbkUwLBisLGnmmD8u41FRk/Hs5oEt2byIHz9ENOk00oqU4ii
        return new User(usr.getUserName(), usr.getPassword(), new ArrayList<>());
    }
}
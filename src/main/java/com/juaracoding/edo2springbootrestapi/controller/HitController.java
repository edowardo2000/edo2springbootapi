package com.juaracoding.edo2springbootrestapi.controller;

import com.juaracoding.edo2springbootrestapi.util.ExecuteSMTP;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/op/hit")
public class HitController {


    @GetMapping("/v1/smtpz")
    public String hitSMTP()
    {
        ExecuteSMTP executeSMTP = new ExecuteSMTP();
        String [] strArr =
                {"rezafauzanakbar3@gmail.com",
                        "wahyuramadhani5284@gmail.com",
                        "emirat.millenium@yahoo.co.id",
                        "edowardotan@gmail.com"};
        String [] strArr1 = {"Verifikasi1","Verifikasi2","Verifikasi3"};

        executeSMTP.sendSMTPToken("edowardotan@gmail.com","TEST123",strArr1,"\\data\\ver_regis.html");

        return "OK";
    }
}

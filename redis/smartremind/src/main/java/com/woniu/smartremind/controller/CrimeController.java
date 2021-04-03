package com.woniu.smartremind.controller;

import com.woniu.smartremind.dao.CrimeDao;
import com.woniu.smartremind.mbg.mapper.CrimeMapper;
import com.woniu.smartremind.mbg.model.Crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrimeController {
    @Autowired
    private CrimeDao CrimeDao;
    @GetMapping(value = "/search")
    public List search(String crime){
        System.out.println("crime:"+crime);
        List<Crime> crimes = CrimeDao.searchCrime(crime);
        return crimes;
    }
}

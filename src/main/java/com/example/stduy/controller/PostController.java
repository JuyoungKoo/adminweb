package com.example.stduy.controller;

import com.example.stduy.model.SearchParam;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {


    //HTML <form>
    //ajax  검색
    //http post body -> data
    // json, xml, multipart-form / text-plain


    @PostMapping(value = "/postMethod") 
    public SearchParam PostMethod(@RequestBody SearchParam searchParam){

        return searchParam;

    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/pathMethod")
    public void pathch(){
        
    }
    
}

package com.vgrazi.ecosystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public @Data
class User{
    private final int userID;
    private String name;
    private String address;

    public static void main(String[] args){
        User henry = new User(1, "Henry", "123 Main St.");
        henry.display();
    }

    private void display(){
        log.info(this.toString());
    }
}



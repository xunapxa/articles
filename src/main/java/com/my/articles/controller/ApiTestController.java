package com.my.articles.controller;

import com.my.articles.dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApiTestController {
    @GetMapping("/api")
    public String api_form() {
        return "/test/api";
    }

    @PostMapping("/apiPostTest")
    public ResponseEntity<String> apiPostTest(
            @RequestBody LoginDto loginDto) {
        String info = loginDto.getUserid() + loginDto.getPassword();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(info);
    }

    @RequestMapping(value = "getResponse", method = RequestMethod.POST)
    @ResponseBody
    public LoginDto getResponse() {
        return new LoginDto("xunapxa", "1234");
    }

    @PostMapping("apiPostArrayTest")
    @ResponseBody
    public Map<String, String> apiPostArrayTest(
            @RequestBody List<LoginDto> dtos) {
        System.out.println(dtos.toString());

        Map<String, String> map = new HashMap<>();
        map.put("userid", dtos.get(0).getUserid());
        map.put("password", dtos.get(0).getPassword());

        return null;
    }

//    @DeleteMapping("delete")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete() {
        return "Delete Mapping";
    }
}

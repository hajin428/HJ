package com.sparta.json.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {

    @GetMapping("/json/string")
    //@ResponseBody 에너테이션 사용
    //{"name":"minji", "age":"95"}
    //Content-Type: text/html (json 형태이지만 텍스트로 인식)
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}"; //스트링 타입 안에 JSON 형태
    }


    //Content-Type: application/json
    //Response Body
    // {"name":"Robbie", "age":95}
    @GetMapping("/json/calss")
    @ResponseBody
    public Star helloClassJson() {
        return new Star ("Robbie", 95);
    }

}

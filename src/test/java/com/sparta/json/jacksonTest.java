package com.sparta.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.json.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

public class jacksonTest {

    @Test
    @DisplayName("Object To JSON : get Method 필요")
    void test1() throws JsonProcessingException {


        Star star = new Star("Robbie", 95);

        // ObjectMapper: Jackson 라이브러리에서 제공하는 매퍼
        //object는 star 클래스의 인스턴스 객체 star를 뜻함
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(star);
        //반환하고 싶은 타입= objectMapper.문자열로 변환(변환할 객체)
        //Getter 메서드 필요


        System.out.println("json = " + json);
    }


    @Test
    @DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper

        //readValue : json 형태의 문자열을 java 객체로 변환
        //(변환할 JSON 데이터, 객체의 클래스 타입)
        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
    }
}

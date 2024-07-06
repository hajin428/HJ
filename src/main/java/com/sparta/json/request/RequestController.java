package com.sparta.json.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody

    //경로에 있는 값을 가져올 때 PathVariable 에너테이션을 사용하고
    //받아올 데이터의 타입도 맞춰서 정해준다
    //경호의 중괄호 {name}이 받아와야 할 데이터명
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }



    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    //URL ? 뒤부터 받아온 데이터
    //데이터 간의 구분은 &
    //@RequestParam 변수타입 Key
    //변수명과 일치하는 데이터값을 가져옴
    //@RequestParam(required = false) : 클라이언트에게 전달 받은 값들에서 해당 값이 포함되어 있지 않아도 오류 발생 X

    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam(required = false) String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    // POS 방식으로 @RequestParam을 받아오기
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    // POST 방식으로 가져올 때 body 부분을 가져온다 << @ResponseBody 사용
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
    // POST http://localhost:8080/hello/request/form/model
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);

        //html body에 들어있는 내용을 객체로 처리하기
        //@ModelAttribute 사용 (@ModelAttribute 객체)
        //클래스로 받아온 데이터를 리턴해주기
        //Setter 혹은 overloading 된 데이터가 필요함
    }


    // [Request sample]
    // POST http://localhost:8080/hello/request/form/json
    // Header
    //  Content type: application/json
    // Body
    //  {"name":"Robbie","age":"95"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);

        //JSON To Object일 때는 @RequestBody를 써줘야함
    }


}

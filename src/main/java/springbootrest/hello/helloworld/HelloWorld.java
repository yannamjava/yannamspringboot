package springbootrest.hello.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {


    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    private String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="hello-world-bean")
    private HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("Hello World");
    }
}

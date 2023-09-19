package springbootrest.hello.helloworld;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="hello-world-path-variable/{name}")
    private HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return  new HelloWorldBean("Hello World   " + String.format(name));
    }

    @GetMapping(path="hello-world-path-specific/{EmpName}")
    private HelloWorldBean helloWorldPathSpecific(@PathVariable("EmpName") String name){
        return  new HelloWorldBean("Hello World   " + String.format(name));
    }



}

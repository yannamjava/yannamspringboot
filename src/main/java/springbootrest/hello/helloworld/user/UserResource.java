package springbootrest.hello.helloworld.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springbootrest.hello.helloworld.user.exception.UserNotFoundException;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping(path="/users")
    private List<User> findAllUsers(){
        return service.findAll();
    }

    @GetMapping(path="/users/{id}")
    private User findUser(@PathVariable int id) throws UserNotFoundException {
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id   " + id);
        }
        return user;
    }

    @PostMapping(path="/users")
    private ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        User savedUser = service.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getName())
                .toUri();
        return  ResponseEntity.created(location).build();


    }

    @DeleteMapping(path="/user/remove/{id}")
    private void deleteUser(@PathVariable int id){
        service.deleteUserById(id);

    }

}

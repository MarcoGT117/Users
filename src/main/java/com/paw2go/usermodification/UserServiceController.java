package com.paw2go.usermodification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserServiceController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user")
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") int id, @RequestBody User user) {

        userService.updateUser(id, user);
        return new ResponseEntity<>("El usuario se actualizó satisfactoriamente", HttpStatus.OK);
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        userService.updateUser(id);
        return new ResponseEntity<>("El usuario se borró satisfactoriamente", HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("El usuario se creó satisfactoriamente", HttpStatus.CREATED);
    }
}
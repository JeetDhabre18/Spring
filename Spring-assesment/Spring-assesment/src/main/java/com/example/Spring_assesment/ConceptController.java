package com.example.Spring_assesment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spring-concept")
public class ConceptController {

    @PostMapping("/data")
    public ResponseEntity<String> getPersonFromJson(@RequestBody Person person) {
        String response = "Name: " + person.getName();
        return ResponseEntity.ok(response);
    }
   @GetMapping("/param")
    public ResponseEntity<?> getName(@RequestParam String name) {
        if ("Test".equals(name)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Bad Request: 'Test' is not allowed as a name.");
        }
        return ResponseEntity.ok("Name: " + name);
    }
    @GetMapping("/path/{name}")
    public String getNameFromPath(@PathVariable String name){
        System.out.println("name from the path is :"+name);
        return "Recieved Name: " + name;
    }

}

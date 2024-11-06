package com.example.End_project.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient (name = "${userFeignClient.name}", url = "${userFeignClient.url}")
@FeignClient (name = "user-service", url = "http://localhost:8080/users")

public interface UserFeignClient {

    @GetMapping("/id/{id}")
    User getUser(@PathVariable("id") int id);
}
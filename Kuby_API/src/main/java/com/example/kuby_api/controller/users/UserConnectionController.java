package com.example.kuby_api.controller.users;

import com.example.kuby_api.service.users.UserConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConnectionController {
    @Autowired
    UserConnectionService userConnectionService;
}

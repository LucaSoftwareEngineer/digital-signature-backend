package digital.signature.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import digital.signature.backend.dto.JsonLogin;
import digital.signature.backend.dto.JsonRegister;
import digital.signature.backend.services.AuthService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("api/login")
    public Long login(@RequestBody JsonLogin json) {
        return authService.login(json.getUsername(), json.getPassword());
    }

    @PostMapping("api/register")
    public Boolean register(@RequestBody JsonRegister json) {
        return authService.register(json.getUsername(), json.getPassword());
    }

}

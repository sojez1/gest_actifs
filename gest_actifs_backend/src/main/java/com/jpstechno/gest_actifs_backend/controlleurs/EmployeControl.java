package com.jpstechno.gest_actifs_backend.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.gest_actifs_backend.modeles.Employes;
import com.jpstechno.gest_actifs_backend.securities.JwtService;
import com.jpstechno.gest_actifs_backend.securities.LoginRequest;
import com.jpstechno.gest_actifs_backend.services.EmployeServ;

@RestController
@RequestMapping("/employes")
@CrossOrigin("http://localhost:5173")
public class EmployeControl {

    @Autowired
    private EmployeServ employeServ;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/all_employes")
    public List<Employes> getAllEmploye() {
        return employeServ.listeDesEmployes();

    }

    @PostMapping("/newEmploye")
    public Employes addEmploye(@RequestBody Employes employe) {
        return employeServ.inscrireEmploye(employe);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (auth.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        } else {
            return ("Authentication failed");
        }

    }

}

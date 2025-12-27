package com.example.servicedesk.ui.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.servicedesk.entity.Client;
import java.util.List;

public interface ClientService {

    List<Client> findAll();

    List<Client> findByName(String name);

    Client createClient(String name);
}

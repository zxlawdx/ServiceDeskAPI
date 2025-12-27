package com.example.servicedesk.ui.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.servicedesk.entity.Client;
import com.example.servicedesk.ui.repository.ClientRepository;
import com.example.servicedesk.ui.interfaces.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Client> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Client createClient(String name) {

        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }

        Client client = new Client(name.trim());
        return repository.save(client);
    }
}

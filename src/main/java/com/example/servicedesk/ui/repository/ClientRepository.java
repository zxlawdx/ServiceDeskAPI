package com.example.servicedesk.ui.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servicedesk.entity.Client;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNameContainingIgnoreCase(String name);
}

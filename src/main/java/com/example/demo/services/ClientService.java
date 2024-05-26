package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Client;

public interface ClientService {

    List<Client> getAllClients();
    Client saveClient(Client client);
    Client editClient(Client client);

    Client getClientById(int ID);

    void deleteClient(Client client);
    Long countClient();
}

package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.userDTO.UserDTO;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client saveClient(Client client);
    public Client saveClient(UserDTO client);
    Client editClient(Client client);

    Client getClientById(int ID);

    void deleteClient(Client client);
    Long countClient();
}

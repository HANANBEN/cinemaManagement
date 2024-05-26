package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.repository.ClientRepository;
import com.example.demo.services.ClientService;
import com.example.demo.userDTO.UserDTO;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
	
    public ClientServiceImpl(ClientRepository clientrep) {
		super();
		this.clientrep = clientrep;
	}

	ClientRepository clientrep;
    @Override
    public List<Client> getAllClients() {
        return clientrep.findAll() ;
    }

    @Override
    public Client saveClient(Client client) {
        return clientrep.save(client);
    }
    @Override
    public Client saveClient(UserDTO client) {
        return clientrep.save(new Client( client.getNom(), client.getPrenom(), client.getEmail(),client.getTele()));
    }
    

    @Override
    public Client editClient(Client client) {
        return clientrep.save(client);
    }

    @Override
    public Client getClientById(int ID) {
        return clientrep.findById(ID).get();
    }

    @Override
    public void deleteClient(Client client) {
        clientrep.delete(client);

    }

    @Override
    public Long countClient() {
        return clientrep.count();
    }
}

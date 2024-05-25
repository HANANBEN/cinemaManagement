package web.ServicesImpl;

import web.Entities.Client;
import web.Repositories.ClientRepository;
import web.Services.ClientService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
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

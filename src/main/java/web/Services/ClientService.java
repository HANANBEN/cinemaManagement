package web.Services;

import java.util.List;

import web.Entities.Client;

public interface ClientService {

    List<Client> getAllClients();
    Client saveClient(Client client);
    Client editClient(Client client);

    Client getClientById(int ID);

    void deleteClient(Client client);
    Long countClient();
}

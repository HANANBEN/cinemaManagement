package Services;

import Entities.Client;


import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client saveClient(Client client);
    Client editClient(Client client);

    Client getClientById(int ID);

    void deleteClient(Client client);
    Long countClient();
}

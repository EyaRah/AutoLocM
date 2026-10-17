package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Client;

import java.util.List;
import java.util.Set;

public interface IClient {
    Client ajouterClient(Client client);
    void supprimerClient(Long id);
    Client modifierClient(Client client);
    List<Client> recupererClients();
    Set<Client> findClients();
    Client recupererClientById(Long id);

}

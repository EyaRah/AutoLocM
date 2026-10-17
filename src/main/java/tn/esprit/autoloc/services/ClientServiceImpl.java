package tn.esprit.autoloc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.repositories.ClientRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient {
    private final ClientRepository clientRepository;
    @Override
    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client modifierClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> recupererClients() {
        return clientRepository.findAll();
    }

    @Override
    public Set<Client> findClients() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client recupererClientById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }
}

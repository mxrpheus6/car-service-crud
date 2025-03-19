package com.mxrpheus.service.service;

import com.mxrpheus.service.dto.ClientDTO;
import com.mxrpheus.service.exception.NoSuchEntityException;
import com.mxrpheus.service.mapper.ClientMapper;
import com.mxrpheus.service.model.Client;
import com.mxrpheus.service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDTO> getAllClients() {
        return clientMapper.toDtoList(clientRepository.findAll());
    }

    public ClientDTO getClientById(Long id) {
        return clientMapper.toDto(clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Client with id=" + id + " not found")));
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        clientDTO.setId(null);
        clientDTO.setRegistrationDate(LocalDate.now());
        Client client = clientMapper.toEntity(clientDTO);
        return clientMapper.toDto(clientRepository.save(client));
    }

    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Client with id=" + id + " not found"));

        clientDTO.setId(null);
        clientMapper.updateClient(clientDTO, client);

        return clientMapper.toDto(clientRepository.save(client));
    }

    public void deleteClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Client with id=" + id + " not found"));

        clientRepository.delete(client);
    }

}

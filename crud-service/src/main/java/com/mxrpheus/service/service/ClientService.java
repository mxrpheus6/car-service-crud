package com.mxrpheus.service.service;

import com.mxrpheus.service.dto.ClientDTO;
import com.mxrpheus.service.exception.NoSuchEntityException;
import com.mxrpheus.service.model.Client;

import java.time.LocalDate;
import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClientById(Long id);
}

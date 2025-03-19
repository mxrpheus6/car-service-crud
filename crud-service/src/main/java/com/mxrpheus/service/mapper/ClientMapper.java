package com.mxrpheus.service.mapper;

import com.mxrpheus.service.dto.ClientDTO;
import com.mxrpheus.service.model.Client;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDto(Client client);
    List<ClientDTO> toDtoList(List<Client> clients);

    Client toEntity(ClientDTO clientDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClient(ClientDTO clientDTO, @MappingTarget Client client);
}

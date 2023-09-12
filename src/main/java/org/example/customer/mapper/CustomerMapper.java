package org.example.customer.mapper;

import org.example.customer.dto.outgoing.CustomerDto;
import org.example.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
}

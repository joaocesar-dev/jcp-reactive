package br.dev.jcp.training.jcpreactive.mapper;

import br.dev.jcp.training.jcpreactive.domain.Customer;
import br.dev.jcp.training.jcpreactive.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}

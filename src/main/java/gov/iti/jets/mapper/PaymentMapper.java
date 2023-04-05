package gov.iti.jets.mapper;

import gov.iti.jets.dto.PaymentDto;
import gov.iti.jets.entity.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface PaymentMapper {
    Payment toEntity(PaymentDto paymentDto);

    PaymentDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentDto paymentDto, @MappingTarget Payment payment);
}
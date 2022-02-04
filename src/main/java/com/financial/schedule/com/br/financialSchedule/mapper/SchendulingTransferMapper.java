package com.financial.schedule.com.br.financialSchedule.mapper;

import com.financial.schedule.com.br.financialSchedule.entity.TransferScheduller;
import com.financial.schedule.com.br.financialSchedule.dto.SchendulingTransferDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SchendulingTransferMapper {
    @Mapping(target="sourceAccount", source="schendulingTransferTO.sourceAccount")
    public TransferScheduller getSchendulingTrasnferMapper(SchendulingTransferDTO schendulingTransferTO)throws Exception;
}
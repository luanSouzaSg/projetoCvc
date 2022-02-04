package com.financial.schedule.com.br.financialSchedule.mapper.impl;

import com.financial.schedule.com.br.financialSchedule.entity.TransferScheduller;
import com.financial.schedule.com.br.financialSchedule.mapper.SchendulingTransferMapper;
import com.financial.schedule.com.br.financialSchedule.dto.SchendulingTransferDTO;
import org.mapstruct.factory.Mappers;

public class SchendulleTransferResourceMapper {

    public TransferScheduller parseGetPhysicalReserveResource(SchendulingTransferDTO schendulingTransferTO) throws Exception {

        SchendulingTransferMapper mapper = Mappers.getMapper(SchendulingTransferMapper.class);

        TransferScheduller transferEntity = mapper.getSchendulingTrasnferMapper(schendulingTransferTO);

        return transferEntity;
    }
}

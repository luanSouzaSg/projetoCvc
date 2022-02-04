package com.financial.schedule.com.br.financialSchedule.api;

import com.financial.schedule.com.br.financialSchedule.controller.SchendulingTrasnferController;
import com.financial.schedule.com.br.financialSchedule.mapper.impl.SchendulleTransferResourceMapper;
import com.financial.schedule.com.br.financialSchedule.dto.SchendulingTransferDTO;

import java.io.Serializable;
import java.time.Period;
import java.util.Optional;

public class SchedulingFinancial implements Serializable {
    private static final long serialVersionUID = -1008629764974608075L;
    public static final String CAMPO_DATA_NULO = "campo data nulo";
    public static final String data_meor_compromisso = " getDateTransfer eh menor que o getDateAppointmen";
    public static final String GET_VALUE_TRANSFER_EH_NULO = " getValueTransfer eh nulo";
    public static final String EH_NULO = " eh nulo";

    public SchendulingTrasnferController controller = new SchendulingTrasnferController();

    private SchendulleTransferResourceMapper mapper = new SchendulleTransferResourceMapper();

    public void schedulingTrasnfer(SchendulingTransferDTO SchendulingTransferTO) throws Exception {
        validate(SchendulingTransferTO);
        controller.calculatesSchedulingTransfer(SchendulingTransferTO);
    }

     public void validate(SchendulingTransferDTO entity) throws Exception {
        Optional<SchendulingTransferDTO> schendulingTO = Optional.ofNullable(entity);

        if(!schendulingTO.isPresent())
            throw new Exception(EH_NULO);

        if(!schendulingTO.map(SchendulingTransferDTO::getValueTransfer).isPresent())
            throw new Exception(GET_VALUE_TRANSFER_EH_NULO);

        if(!schendulingTO.map(SchendulingTransferDTO::getDateTransfer).isPresent())
            throw new Exception( CAMPO_DATA_NULO);

        Period period = Period.between(entity.getDateAppointment(), entity.getDateTransfer());
        if(period.isNegative())
            throw new Exception(data_meor_compromisso);
    }
    public SchendulingTrasnferController getController() {
        return controller;
    }
    public void setController(SchendulingTrasnferController controller) {
        this.controller = controller;
    }
}
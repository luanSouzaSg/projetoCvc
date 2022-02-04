package com.financial.schedule.com.br.financialSchedule.controller;

import com.financial.schedule.com.br.financialSchedule.dao.SchendullerTransferDao;
import com.financial.schedule.com.br.financialSchedule.dto.SchendulingTransferDTO;
import com.financial.schedule.com.br.financialSchedule.util.Validate;


import java.util.List;

public class SchendulingTrasnferController extends Validate{

    private SchendullerTransferDao dao = new SchendullerTransferDao();

    public void calculatesSchedulingTransfer(SchendulingTransferDTO entity) throws Exception {

        if(transferValueMoreThousand(entity)){
            if(transferDay(entity)){
                entity.setRate(String.valueOf(transferToday(entity)));

            }
        }else if(transferValueTwoThousand(entity)){
            if(validateTransferUpToDays(entity)){
                entity.setRate(String.valueOf(transferUpToDays(entity)));

            }
        }else if (transferValueMoreTwoThousand(entity)) {
            if(validateTackwardAX(entity)){
                entity.setRate(String.valueOf(tackwardAX(entity)));
            }

        }
        addSchendulingTranfer(entity);
    }

    private void addSchendulingTranfer(SchendulingTransferDTO entity){
        dao.addSchendulingTransfer(entity);

    }
    public SchendulingTransferDTO findSchendulingTranfer(String sourceCode) throws Exception{
        return dao.findSchendulingTransfer(sourceCode);
    }
}


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
                //Regra: Tranferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido
                entity.setRate(String.valueOf(transferToday(entity)));

            }
        }else if(transferValueTwoThousand(entity)){
            if(validateTransferUpToDays(entity)){
                //Regra: Tranferências até 10 dias da data de agendamento possuem uma taxa de $12
                entity.setRate(String.valueOf(transferUpToDays(entity)));

            }
        }else if (transferValueMoreTwoThousand(entity)) {
            if(validateTackwardAX(entity)){
                //Regra: Operações do tipo C tem uma taxa regressiva conforme a data de transferência:
                entity.setRate(String.valueOf(tackwardAX(entity)));
            }

        }
//
//        if(null == entity.getRate()){
//            throw new Exception("Não existe TAXA aplicavel", "ERROR-CVC-001", "taxa nao se aplica");
//        }

        addSchendulingTranfer(entity);
    }

    private void addSchendulingTranfer(SchendulingTransferDTO entity){
        dao.addSchendulingTransfer(entity);

    }
    public SchendulingTransferDTO findSchendulingTranfer(String sourceCode) throws Exception{

        return dao.findSchendulingTransfer(sourceCode);
    }

    public List<SchendulingTransferDTO> findAllSchendulingTranfer() throws Exception{

        return dao.findAllSchendulingTransfer();
    }

}


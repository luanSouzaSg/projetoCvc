package com.financial.schedule.com.br.financialSchedule.dao;

import com.financial.schedule.com.br.financialSchedule.dto.SchendulingTransferDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchendullerTransferDao {


    public static final String NÃO_ECONTRADO = "Não Econtrado";
    private Map<String, SchendulingTransferDTO> mapSchendulingTrasnfer = new HashMap<String, SchendulingTransferDTO>();

    public void addSchendulingTransfer(SchendulingTransferDTO schendulingTransferTO){
        mapSchendulingTrasnfer.put(schendulingTransferTO.getSourceAccount(), schendulingTransferTO);
    }

    public SchendulingTransferDTO findSchendulingTransfer(String sourceCount) throws Exception{
        SchendulingTransferDTO schendulingTransferTO = null;

        if ( mapSchendulingTrasnfer.containsKey(sourceCount) ) {
            schendulingTransferTO = mapSchendulingTrasnfer.get(sourceCount);
        }

        if(null == schendulingTransferTO){
            try {
                throw new Exception(NÃO_ECONTRADO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return schendulingTransferTO;
    }

    public List<SchendulingTransferDTO> findAllSchendulingTransfer() throws Exception{

        List<SchendulingTransferDTO> list = new ArrayList<>();
        for (String key : mapSchendulingTrasnfer.keySet()) {

            SchendulingTransferDTO schendulingTransferTO = mapSchendulingTrasnfer.get(key);
            list.add(schendulingTransferTO);
        }
        return list;
    }
}

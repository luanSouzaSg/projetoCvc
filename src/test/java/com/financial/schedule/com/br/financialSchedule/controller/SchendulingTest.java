package com.financial.schedule.com.br.financialSchedule.controller;

import com.financial.schedule.com.br.financialSchedule.dao.SchendullerTransferDao;
import com.financial.schedule.com.br.financialSchedule.dto.SchendulingTransferDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class SchendulingTest {


    @InjectMocks
    private  SchendulingTrasnferController schendulingTrasnferController;

    private SchendulingTransferDTO schendulingTransferTO;

    @Before
    public void before() {
        schendulingTransferTO = new SchendulingTransferDTO();

        LocalDate today = LocalDate.now();
        schendulingTransferTO.setDateAppointment(today);
        schendulingTransferTO.setDestinationAccount("INICIO");
        schendulingTransferTO.setSourceAccount("INICIO");

    }

    @Test
    public void testDoExecutionCalculateByvalue() throws Exception {
        LocalDate schedule = LocalDate.now();
        schendulingTransferTO.setDateTransfer(schedule);

        schendulingTransferTO.setValueTransfer(1000);
        schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);

        assertNotNull(schendulingTransferTO.getRate());
    }

    @Test
    public void testDoExecutionCalculateByTwo() throws Exception {
        LocalDate schedule = LocalDate.of(2022, Month.FEBRUARY, 04);
        schendulingTransferTO.setDateTransfer(schedule);
        schendulingTransferTO.setValueTransfer(45000);
        schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);

        assertNotNull(schendulingTransferTO.getRate());
    }

    @Test
    public void testDoExecutionCalculateByDay() throws Exception {
        LocalDate schedule = LocalDate.of(2022, Month.FEBRUARY, 04);
        schendulingTransferTO.setDateTransfer(schedule);

        schendulingTransferTO.setValueTransfer(1230);
        schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);

        assertNotNull(schendulingTransferTO.getRate());
    }

    @Test
    public void testDoExecutionFindByAccount() throws Exception {
        SchendulingTransferDTO findSchenduling = schendulingTrasnferController.findSchendulingTranfer(schendulingTransferTO.getSourceAccount());

        assertNotNull(findSchenduling);
    }

    @Test
    public void testDoExecutionNoRateException(){
        LocalDate schedule = LocalDate.of(2017, Month.SEPTEMBER, 20);
        schendulingTransferTO.setDateTransfer(schedule);
        schendulingTransferTO.setValueTransfer(500);

        try {
            schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);
        } catch (Exception e) {
            assertTrue("Erro ao calcular ", "Não existe TAXA aplicavel".equalsIgnoreCase(e.getMessage()));
        }

    }

    @Test(expected=NullPointerException.class)
    public void testDoExecutionNull() throws Exception {

        schendulingTransferTO = null;
        schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);

    }
}

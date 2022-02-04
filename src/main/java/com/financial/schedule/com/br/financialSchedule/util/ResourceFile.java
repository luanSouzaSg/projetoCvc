package com.financial.schedule.com.br.financialSchedule.util;

import com.financial.schedule.com.br.financialSchedule.entity.TransferScheduller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResourceFile {


    private String path ;

    public void writeFiles(TransferScheduller transferEntity) throws IOException {

        path = transferEntity.getSourceAccount()+"_"+transferEntity.getDateConfirm()+".txt";
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(builder(transferEntity) +"Data e hs da gravação: "+ new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
        writer.newLine();
        //Criando o conteúdo do arquivo
        writer.flush();
        //Fechando conexão e escrita do arquivo.
        writer.close();
    }

    public void readFiles(File file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String data = null;
        while((data = reader.readLine()) != null){
            System.out.println(data);
        }
        fileReader.close();
        reader.close();
    }


    private String builder(TransferScheduller transferEntity){
        StringBuilder builder = new StringBuilder();
        return 	builder.append("Data Agendamento: "+transferEntity.getDateConfirm()).
                append("\n").
                append("Data Trasnferencia: "+transferEntity.getDateTransfer()).
                append("\n").
                append("Conta Destino: "+transferEntity.getDestinationAccount()).
                append("\n").
                append("Conta Origem: "+transferEntity.getSourceAccount()).
                append("\n").
                append("Taxa: "+transferEntity.getRate()).
                append("\n").
                append("Valor transferencia: "+transferEntity.getValueTransfer()).
                append("\n").toString();

    }
}

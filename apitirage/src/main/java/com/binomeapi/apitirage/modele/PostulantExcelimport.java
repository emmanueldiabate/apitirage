package com.binomeapi.apitirage.modele;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostulantExcelimport {
    public List<Postulant> excelImport() {
        List <Postulant> postulantList = new ArrayList<>();


        String nom="";
        String prenom="";
        long numero=0;
        String mail="";

        String excelFilePath = "C:\\Users\\kssamake\\Desktop\\Monapi\\apitirage\\listePostulant.xlsx";

        long start = System.currentTimeMillis();//l'heure de debut d'importation

        try {
            FileInputStream inputStrean = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStrean);
            Sheet firstSheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator=firstSheet.iterator();
            rowIterator.next();

            while (rowIterator.hasNext()){
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator=nextRow.cellIterator();
                while (cellIterator.hasNext()){
                    Cell nextCell=cellIterator.next();
                    int columnIndex=nextCell.getColumnIndex();
                    switch (columnIndex){
                        case 0:
                            nom=nextCell.getStringCellValue();
                            System.out.println(nom);
                            break;
                        case 1:
                            prenom=nextCell.getStringCellValue();
                            System.out.println(prenom);
                            break;
                        case 2:
                            numero=(long)nextCell.getNumericCellValue();
                            System.out.println(numero);
                            break;
                        case 3:
                            mail=nextCell.getStringCellValue();
                            System.out.println(mail);
                            break;
                    }
                    //postulantList.add(new Postulant(nom_postulant, prenom_postulant, numero_postulant, email_postulant));
                }
                postulantList.add(new Postulant(nom,prenom,numero,mail));
            }
            workbook.close();
            long end = System.currentTimeMillis();//l'heure de fin
            System.out.printf("Import done in %d ms\n", (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  postulantList;
    }
}

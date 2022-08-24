package com.binomeapi.apitirage.modele;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostulantExcelimport{

    public List<Postulant> excelImport(MultipartFile fichier) {
        List <Postulant> postulantList = new ArrayList<>();

        String mail="";
        String nom="";
        String prenom="";
        String numero="";

        long start = System.currentTimeMillis();//l'heure de debut d'importation

        try {
            Workbook workbook = new XSSFWorkbook(fichier.getInputStream());
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
                            mail=nextCell.getStringCellValue();
                            System.out.println(mail);
                            break;
                        case 1:
                            nom=nextCell.getStringCellValue();
                            System.out.println(nom);
                            break;
                        case 2:
                            numero=nextCell.getStringCellValue();
                            System.out.println(numero);

                            break;
                        case 3:
                            prenom=nextCell.getStringCellValue();
                            System.out.println(prenom);
                            break;

                    }
                }
                postulantList.add(new Postulant(mail,nom,numero,prenom));
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

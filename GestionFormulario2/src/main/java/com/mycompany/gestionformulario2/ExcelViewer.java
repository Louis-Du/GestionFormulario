package com.mycompany.gestionformulario2;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.util.Iterator;


public class ExcelViewer {
    public static JTable cargarExcelEnTabla(InputStream inputStream) {
        try {
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);

            return convertirHojaATabla(sheet);

        } catch (Exception e) {
            System.err.println("Error cargando Excel: " + e.getMessage());
            return null;
        }
    }

    private static JTable convertirHojaATabla(Sheet sheet) {
        DefaultTableModel modelo = new DefaultTableModel();

        Iterator<Row> rowIterator = sheet.iterator();

        boolean primeraFila = true;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Object[] datosFila = new Object[row.getLastCellNum()];

            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                datosFila[i] = obtenerValor(cell);
            }

            // encabezados
            if (primeraFila) {
                for (int i = 0; i < datosFila.length; i++) {
                    modelo.addColumn(datosFila[i]);
                }
                primeraFila = false;
            } else {
                modelo.addRow(datosFila);
            }
        }

        return new JTable(modelo);
    }

    private static Object obtenerValor(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return cell.getNumericCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            case FORMULA: return cell.getCellFormula();
            default: return "";
        }
    }
}

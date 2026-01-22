package com.mycompany.gestionformulario2.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Clase utilitaria para cargar y visualizar archivos Excel en componentes
 * JTable de Swing.
 * Utiliza la librería Apache POI para leer archivos Excel (.xlsx).
 */
public class ExcelViewer {
  /**
   * Método estático que carga un archivo Excel desde un InputStream y lo
   * convierte en una JTable.
   * 
   * @param inputStream Flujo de entrada con los datos del archivo Excel
   * @return JTable con los datos del Excel, o null si ocurre un error
   */
  public static JTable cargarExcelEnTabla(InputStream inputStream) {
    try {
      // Crea un objeto Workbook a partir del InputStream usando Apache POI
      Workbook wb = WorkbookFactory.create(inputStream);
      // Obtiene la primera hoja del libro de Excel (índice 0)
      Sheet sheet = wb.getSheetAt(0);

      // Convierte la hoja de Excel en una JTable
      return convertirHojaATabla(sheet);

    } catch (Exception e) {
      // Manejo de errores: imprime el mensaje de error en la consola
      System.err.println("Error cargando Excel: " + e.getMessage());
      return null;
    }
  }

  /**
   * Método privado que convierte una hoja de Excel (Sheet) en una JTable.
   * La primera fila se utiliza como encabezados de las columnas.
   * 
   * @param sheet Hoja de Excel a convertir
   * @return JTable con los datos de la hoja
   */
  private static JTable convertirHojaATabla(Sheet sheet) {
    // Crea un modelo de tabla vacío para almacenar los datos
    DefaultTableModel modelo = new DefaultTableModel();

    // Obtiene un iterador para recorrer todas las filas de la hoja
    Iterator<Row> rowIterator = sheet.iterator();

    // Bandera para identificar la primera fila (encabezados)
    boolean primeraFila = true;

    // Itera sobre cada fila de la hoja de Excel
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      // Crea un array para almacenar los valores de todas las celdas de la fila
      Object[] datosFila = new Object[row.getLastCellNum()];

      // Itera sobre cada celda de la fila actual
      for (int i = 0; i < row.getLastCellNum(); i++) {
        Cell cell = row.getCell(i);
        // Extrae el valor de la celda y lo almacena en el array
        datosFila[i] = obtenerValor(cell);
      }

      // Si es la primera fila, los valores se usan como encabezados de columna
      if (primeraFila) {
        for (int i = 0; i < datosFila.length; i++) {
          modelo.addColumn(datosFila[i]);
        }
        primeraFila = false;
      } else {
        // Para las demás filas, se agregan como datos al modelo
        modelo.addRow(datosFila);
      }
    }

    // Retorna una nueva JTable con el modelo de datos creado
    return new JTable(modelo);
  }

  /**
   * Método privado que extrae el valor de una celda de Excel según su tipo.
   * Maneja diferentes tipos de datos: texto, numérico, booleano y fórmulas.
   * 
   * @param cell Celda de Excel de la cual extraer el valor
   * @return Objeto con el valor de la celda, o cadena vacía si la celda es nula
   */
  private static Object obtenerValor(Cell cell) {
    // Si la celda es nula, retorna una cadena vacía
    if (cell == null)
      return "";

    // Evalúa el tipo de dato de la celda y extrae su valor correspondiente
    switch (cell.getCellType()) {
      case STRING:
        return cell.getStringCellValue(); // Texto
      case NUMERIC:
        return cell.getNumericCellValue(); // Números (enteros o decimales)
      case BOOLEAN:
        return cell.getBooleanCellValue(); // Valores booleanos (true/false)
      case FORMULA:
        return cell.getCellFormula(); // Fórmulas de Excel
      default:
        return ""; // Cualquier otro tipo retorna cadena vacía
    }
  }
}

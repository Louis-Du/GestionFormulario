package com.mycompany.gestionformulario2.service;

// Importaciones para manejo de archivos y fechas
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.mycompany.gestionformulario2.model.Registro;
import com.mycompany.gestionformulario2.model.Evento;

/**
 * Clase utilitaria para exportar registros de asistentes a formato Excel
 * (.xlsx).
 * 
 * Esta clase proporciona funcionalidades para:
 * - Generar archivos Excel con formato profesional
 * - Exportar datos de registros de eventos a hojas de cálculo
 * - Incluir información del evento en las primeras filas
 * - Aplicar estilos personalizados (colores, bordes, fuentes)
 * - Auto-ajustar el ancho de las columnas
 * 
 * Estructura del archivo Excel generado:
 * - Fila 0: Evento: [nombre]
 * - Fila 1: Lugar: [lugar]
 * - Fila 2: Fecha y hora: [fecha/hora]
 * - Fila 3: (en blanco)
 * - Fila 4: Encabezados de columnas
 * - Fila 5+: Datos de registros
 * 
 * Utiliza la biblioteca Apache POI (versión 5.5.1) para la manipulación de
 * archivos Excel.
 * Los archivos generados son compatibles con Microsoft Excel 2007 y versiones
 * posteriores.
 * 
 * @author Sistema de Gestión de Formularios
 * @version 2.0
 */
public class ExportadorExcel {

  /**
   * Exporta una lista de registros de asistentes a un archivo Excel (.xlsx).
   * 
   * @param registros Lista de objetos Registro con los datos de los asistentes a
   *                  exportar
   * @param evento    Objeto Evento con la información completa del evento
   * @return String con la ruta completa del archivo generado
   * @throws IOException Si ocurre un error al crear o escribir el archivo
   */
  public static String exportarRegistros(List<Registro> registros, Evento evento) throws IOException {
    // Crear el libro de trabajo usando XSSFWorkbook de Apache POI
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Registros");

    // ========== CONFIGURACIÓN DE ESTILOS ==========

    // Estilo para las etiquetas de información del evento (negrita)
    CellStyle labelStyle = workbook.createCellStyle();
    Font labelFont = workbook.createFont();
    labelFont.setBold(true);
    labelFont.setFontHeightInPoints((short) 11);
    labelStyle.setFont(labelFont);

    // Estilo para los valores de información del evento
    CellStyle valueStyle = workbook.createCellStyle();
    Font valueFont = workbook.createFont();
    valueFont.setFontHeightInPoints((short) 11);
    valueStyle.setFont(valueFont);

    // Estilo para los encabezados de columnas (negrita, fondo gris claro, bordes)
    CellStyle headerStyle = workbook.createCellStyle();
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 11);
    headerStyle.setFont(headerFont);
    headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    headerStyle.setBorderBottom(BorderStyle.THIN);
    headerStyle.setBorderTop(BorderStyle.THIN);
    headerStyle.setBorderRight(BorderStyle.THIN);
    headerStyle.setBorderLeft(BorderStyle.THIN);
    headerStyle.setAlignment(HorizontalAlignment.CENTER);
    headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

    // Estilo para las celdas de datos
    CellStyle dataStyle = workbook.createCellStyle();
    dataStyle.setBorderBottom(BorderStyle.THIN);
    dataStyle.setBorderTop(BorderStyle.THIN);
    dataStyle.setBorderRight(BorderStyle.THIN);
    dataStyle.setBorderLeft(BorderStyle.THIN);
    dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);

    // ========== INFORMACIÓN DEL EVENTO (FILAS 0-2) ==========

    // Fila 0: Evento
    Row row0 = sheet.createRow(0);
    Cell cellEvento = row0.createCell(0);
    cellEvento.setCellValue("Evento:");
    cellEvento.setCellStyle(labelStyle);
    Cell cellEventoValor = row0.createCell(1);
    cellEventoValor.setCellValue(evento.getNombre());
    cellEventoValor.setCellStyle(valueStyle);

    // Fila 1: Lugar
    Row row1 = sheet.createRow(1);
    Cell cellLugar = row1.createCell(0);
    cellLugar.setCellValue("Lugar:");
    cellLugar.setCellStyle(labelStyle);
    Cell cellLugarValor = row1.createCell(1);
    cellLugarValor.setCellValue(evento.getLugar());
    cellLugarValor.setCellStyle(valueStyle);

    // Fila 2: Fecha y hora
    Row row2 = sheet.createRow(2);
    Cell cellFecha = row2.createCell(0);
    cellFecha.setCellValue("Fecha y hora:");
    cellFecha.setCellStyle(labelStyle);
    Cell cellFechaValor = row2.createCell(1);
    cellFechaValor.setCellValue(evento.getFechaHora());
    cellFechaValor.setCellStyle(valueStyle);

    // Fila 3: En blanco (separador visual)
    sheet.createRow(3);

    // ========== FILA 4: ENCABEZADOS DE COLUMNAS ==========

    Row headerRow = sheet.createRow(4);
    String[] columnas = {
        "Tipo de invitado",
        "Nombre",
        "Apellidos",
        "Tipo de documento",
        "Número de documento",
        "Programa de formación",
        "Ficha",
        "Centro",
        "Celular",
        "Correo electrónico",
        "Fecha y hora de registro",
        "Estado",
        "Asistencia"
    };

    for (int i = 0; i < columnas.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columnas[i]);
      cell.setCellStyle(headerStyle);
    }

    // ========== FILA 5 EN ADELANTE: DATOS DE LOS REGISTROS ==========

    int rowNum = 5;
    for (Registro registro : registros) {
      Row row = sheet.createRow(rowNum++);
      crearCelda(row, 0, registro.getTipoVisitante(), dataStyle);
      crearCelda(row, 1, registro.getNombre(), dataStyle);
      crearCelda(row, 2, registro.getApellidos(), dataStyle);
      crearCelda(row, 3, registro.getTipoDocumento(), dataStyle);
      crearCelda(row, 4, registro.getNumeroDocumento(), dataStyle);
      crearCelda(row, 5, registro.getPrograma(), dataStyle);
      crearCelda(row, 6, registro.getFicha(), dataStyle);
      crearCelda(row, 7, registro.getCentro(), dataStyle);
      crearCelda(row, 8, registro.getCelular(), dataStyle);
      crearCelda(row, 9, registro.getCorreo(), dataStyle);
      crearCelda(row, 10, registro.getFechaHoraRegistro(), dataStyle);
      crearCelda(row, 11, registro.getEstado(), dataStyle);
      crearCelda(row, 12, "Presente".equals(registro.getEstado()) ? "Sí" : "No", dataStyle);
    }

    // ========== AJUSTE AUTOMÁTICO DEL ANCHO DE COLUMNAS ==========

    // Ajustar columnas de información del evento
    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.setColumnWidth(0, sheet.getColumnWidth(0) + 500);
    sheet.setColumnWidth(1, sheet.getColumnWidth(1) + 2000);

    // Ajustar columnas de datos
    for (int i = 0; i < columnas.length; i++) {
      sheet.autoSizeColumn(i);
      sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000);
    }

    // ========== GENERACIÓN DEL NOMBRE DE ARCHIVO ==========

    String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    String nombreEventoLimpio = evento.getNombre().replaceAll("[^a-zA-Z0-9]", "_");
    String nombreArchivo = "Evento_" + nombreEventoLimpio + "_" + fechaActual + ".xlsx";
    String rutaCompleta = System.getProperty("user.home") + File.separator + nombreArchivo;

    // ========== ESCRITURA DEL ARCHIVO ==========

    try (FileOutputStream fileOut = new FileOutputStream(rutaCompleta)) {
      workbook.write(fileOut);
    }

    workbook.close();
    return rutaCompleta;
  }

  /**
   * Método auxiliar para crear una celda con valor y estilo.
   * 
   * @param row    Fila donde se creará la celda
   * @param column Índice de la columna
   * @param value  Valor de texto (puede ser null)
   * @param style  Estilo a aplicar
   */
  private static void crearCelda(Row row, int column, String value, CellStyle style) {
    Cell cell = row.createCell(column);
    cell.setCellValue(value != null ? value : "");
    cell.setCellStyle(style);
  }
}

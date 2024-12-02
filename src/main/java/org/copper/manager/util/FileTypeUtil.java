package org.copper.manager.util;

import org.copper.manager.common.ResourceCode;

public class FileTypeUtil {

    public static ResourceCode determineFileType(String driveUrl) {
        if (driveUrl == null || driveUrl.isEmpty()) {
            throw new IllegalArgumentException("El URL de Google Drive no puede estar vacío.");
        }

        if (driveUrl.contains("/video") || driveUrl.contains("/vimeo")
                || driveUrl.contains("/youtube") || driveUrl.contains("youtu.be")) {
            return ResourceCode.VIDEO;
        } else if (driveUrl.contains("/presentation")) {
            return ResourceCode.PPTX;
        } else if (driveUrl.contains("/document")) {
            return ResourceCode.DOCX;
        } else if (driveUrl.contains("/spreadsheets")) {
            return ResourceCode.XLSX;
        } else if (driveUrl.contains("file")) {
            return ResourceCode.PDF;
        } else if (driveUrl.endsWith(".zip")) {
            return ResourceCode.ZIP;
        } else if (driveUrl.endsWith(".jpg") || driveUrl.endsWith(".jpeg") || driveUrl.endsWith(".png") || driveUrl.endsWith(".gif")) {
            return ResourceCode.IMAGE;
        } else {
            throw new IllegalArgumentException("El formato de archivo no es válido.");
        }
    }
}


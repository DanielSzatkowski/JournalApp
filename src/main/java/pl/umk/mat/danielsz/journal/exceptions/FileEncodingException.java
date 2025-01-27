package pl.umk.mat.danielsz.journal.exceptions;

import java.util.Date;

public class FileEncodingException extends RuntimeException {

    private Date date;

    public FileEncodingException(String message) {
        super(message);

        this.date = new Date();
    }
}

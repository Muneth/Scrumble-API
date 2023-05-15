package com.atempo.internal.scrumble.exception;

public class ProcessingException extends RuntimeException {

  private static final long serialVersionUID = -9114328370472704204L;

  public ProcessingException() {
    super();
  }

  public ProcessingException(String message) {
    super(message);
  }

  public ProcessingException(Throwable cause) {
    super(cause);
  }

  public ProcessingException(String message, Throwable cause) {
    super(message, cause);
  }
}

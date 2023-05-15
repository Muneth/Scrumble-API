package com.atempo.internal.scrumble.exception;

public class InvalidParametersException extends RuntimeException {

  private static final long serialVersionUID = 7844283756962512157L;

  public InvalidParametersException() {
    super();
  }

  public InvalidParametersException(String message) {
    super(message);
  }

  public InvalidParametersException(Throwable cause) {
    super(cause);
  }

  public InvalidParametersException(String message, Throwable cause) {
    super(message, cause);
  }
}

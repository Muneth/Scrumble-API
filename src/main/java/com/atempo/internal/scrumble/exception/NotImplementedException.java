package com.atempo.internal.scrumble.exception;

public class NotImplementedException extends RuntimeException {

  private static final long serialVersionUID = -6488534328507145962L;

  public NotImplementedException() {
    super();
  }

  public NotImplementedException(String message) {
    super(message);
  }

  public NotImplementedException(Throwable cause) {
    super(cause);
  }

  public NotImplementedException(String message, Throwable cause) {
    super(message, cause);
  }
}

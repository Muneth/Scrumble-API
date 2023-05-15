package com.atempo.internal.scrumble.exception;

public class ConflictException extends RuntimeException {

  private static final long serialVersionUID = 7644517275985197472L;

  public ConflictException() {
    super();
  }

  public ConflictException(String message) {
    super(message);
  }

  public ConflictException(Throwable cause) {
    super(cause);
  }

  public ConflictException(String message, Throwable cause) {
    super(message, cause);
  }
}

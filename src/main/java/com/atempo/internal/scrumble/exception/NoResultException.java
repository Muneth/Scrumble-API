package com.atempo.internal.scrumble.exception;

public class NoResultException extends RuntimeException {

  private static final long serialVersionUID = 2986185766431286047L;

  public NoResultException() {
    super();
  }

  public NoResultException(String message) {
    super(message);
  }

  public NoResultException(Throwable cause) {
    super(cause);
  }

  public NoResultException(String message, Throwable cause) {
    super(message, cause);
  }
}

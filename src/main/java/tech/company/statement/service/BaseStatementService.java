package tech.company.statement.service;

import tech.company.statement.model.BaseReviewStatement;

public abstract class BaseStatementService {

  private Object mutex = new Object();

  // todo this class can also be modified in performing further actions

  // todo 1. create 2 implementations of this service: to both statements type

  // todo 2. create methods create createProductStatement and createServiceStatement in appropriate
  // implementations

  public BaseReviewStatement updateStatement(BaseReviewStatement reviewStatement, String comment) {
    synchronized (mutex) {
      reviewStatement.setComment(comment);
      return reviewStatement;
    }
  }
}

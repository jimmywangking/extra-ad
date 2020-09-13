package com.baron.extraad.service;

import com.baron.extraad.exception.CustomException;

/***
 @package com.baron.extraad
 @author Baron
 @create 2020-09-13-12:40 PM
 */
public interface ISpringTransaction {
    //主动捕获异常，事务不回滚
    void CatchExceptionCanNotRollback();
    //不是unchecked异常，事务不回滚
    void NotRuntimeExceptionCanNotRollback() throws CustomException;

    /**
     * <h2>unchecked 异常, 事务可以回滚</h2>
     */
    void RuntimeExceptionCanRollback();

    /**
     * <h2>指定了 rollbackFor, 事务可以回滚</h2>
     */
    void AssignExceptionCanRollback() throws CustomException;

    /**
     * <h2>Rollback Only, 事务可以回滚</h2>
     */
    void RollbackOnlyCanRollback() throws Exception;

    /**
     * <h2>同一个类中, 一个不标注事务的方法去调用 transactional 的方法, 事务会失效</h2>
     */
    void NonTransactionalCanNotRollback();
}

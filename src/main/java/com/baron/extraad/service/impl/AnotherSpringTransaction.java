package com.baron.extraad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 @package com.baron.extraad.service.impl
 @author Baron
 @create 2020-09-13-3:05 PM
 */
@Service
public class AnotherSpringTransaction {

    private final SpringTransactionImpl springTransaction;

    @Autowired
    public AnotherSpringTransaction(SpringTransactionImpl springTransaction) {
        this.springTransaction = springTransaction;
    }

    /**
     * <h2>不同类中, 一个不标注事务的方法去调用 transactional 的方法, 事务不会失效</h2>
     */
    public void TransactionalCanRollback() {

        springTransaction.anotherOneSaveMethod();
    }
}

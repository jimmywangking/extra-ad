package com.baron.extraad.service;

import com.baron.extraad.ExtraadApplicationTests;
import com.baron.extraad.exception.CustomException;
import com.baron.extraad.service.impl.AnotherSpringTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 @package com.baron.extraad
 @author Baron
 @create 2020-09-13-12:50 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExtraadApplicationTests.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TransactionTest {

    @Autowired
    private ISpringTransaction springTransaction;

    @Autowired
    private AnotherSpringTransaction anotherSpringTransaction;

    @Test
    public void testCatchExceptionCanNotRollback() {

        springTransaction.CatchExceptionCanNotRollback();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollback() throws CustomException {

        springTransaction.NotRuntimeExceptionCanNotRollback();
    }

    @Test
    public void testRuntimeExceptionCanRollback() {

        springTransaction.RuntimeExceptionCanRollback();
    }

    @Test
    public void testAssignExceptionCanRollback() throws CustomException {

        springTransaction.AssignExceptionCanRollback();
    }

    @Test
    public void testRollbackOnlyCanRollback() throws Exception {

        springTransaction.RollbackOnlyCanRollback();
    }

    @Test
    public void testNonTransactionalCanNotRollback() {

        springTransaction.NonTransactionalCanNotRollback();
    }

    @Test
    public void testTransactionalCanRollback() {

        anotherSpringTransaction.TransactionalCanRollback();
    }

}

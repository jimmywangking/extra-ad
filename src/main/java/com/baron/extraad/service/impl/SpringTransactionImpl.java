package com.baron.extraad.service.impl;

import com.baron.extraad.dao.ExtraAdDao;
import com.baron.extraad.entity.ExtraAd;
import com.baron.extraad.exception.CustomException;
import com.baron.extraad.service.ISpringTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 @package com.baron.extraad.service.impl
 @author Baron
 @create 2020-09-13-12:43 PM
 */
@Slf4j
@Service
public class SpringTransactionImpl implements ISpringTransaction {

    private final ExtraAdDao extraAdDao;

    @Autowired
    public SpringTransactionImpl(ExtraAdDao extraAdDao) {
        this.extraAdDao = extraAdDao;
    }

    @Override
    public void CatchExceptionCanNotRollback() {
        try {
            extraAdDao.save(new ExtraAd("baron"));
            throw  new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void NotRuntimeExceptionCanNotRollback() throws CustomException {
        try {
            extraAdDao.save(new ExtraAd("Baron"));
            throw new RuntimeException();
        } catch ( Exception e) {
            throw new CustomException(e.getMessage());
        }
    }


    /**
     * <h2>RuntimeException 异常可以回滚</h2>
     */
    @Override
    @Transactional
    public void RuntimeExceptionCanRollback() {

        extraAdDao.save(new ExtraAd("baron"));
        throw new RuntimeException();
    }

    /**
     * <h2>指定异常, 可以回滚</h2>
     */
    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void AssignExceptionCanRollback() throws CustomException {

        try {
            extraAdDao.save(new ExtraAd("aaron"));
            throw new RuntimeException();
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
    }


    /**
     * <h2>在 private 方法上标注 transactional, 事务无效</h2>
     */
    @Transactional
    public void oneSaveMethod() {

        extraAdDao.save(new ExtraAd("baron"));
    }

    /**
     * <h2>Rollback Only</h2>
     * org.springframework.transaction.UnexpectedRollbackException:
     * Transaction silently rolled back because it has been marked as rollback-only
     */
    @Override
    @Transactional
    public void RollbackOnlyCanRollback() throws Exception {

        oneSaveMethod();

        try {
            extraAdDao.save(new ExtraAd());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * <h2>在private方法上标注transactional, 事务无效</h2>
     */
    @Transactional
    public void anotherOneSaveMethod() {

        extraAdDao.save(new ExtraAd("baron"));
        throw new RuntimeException();
    }

    /**
     * <h2>同一个类中, 一个不标注事务的方法去调用 transactional 的方法, 事务会失效</h2>
     */
    @Override
//    @Transactional
    public void NonTransactionalCanNotRollback() {

        anotherOneSaveMethod();
    }

}

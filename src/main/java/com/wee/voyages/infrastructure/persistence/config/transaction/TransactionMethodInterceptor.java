package com.wee.voyages.infrastructure.persistence.config.transaction;

import com.google.inject.Inject;
import com.wee.voyages.infrastructure.persistence.config.EntityManagerBinder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.persistence.EntityTransaction;

/**
 * User: weejulius
 * Date: 2009-7-14
 * Time: 21:27:35
 */
public class TransactionMethodInterceptor implements MethodInterceptor {
    @Inject
    private EntityManagerBinder binder;

    public Object invoke(MethodInvocation invocation) throws Throwable {
      //  EntityTransaction transaction= binder.transaction();
      //  boolean isActive=transaction.isActive();
      //  if(!isActive) transaction.begin();
        Object obj=null;
        try{
         obj= invocation.proceed();
        }catch(RuntimeException e){

            binder.rollback();
            throw new RuntimeException(e);
        }
     //   if(!isActive){
      //      binder.commitTransaction();
     //       binder.beginTransaction();
    //    }
        return obj;
    }


    public static class TransactionStrategy {


    }
}

package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.service.TestService;


//@Transactional
//加上注解@Transactional,就可以指定这个类需要受Spring的事务管理
//注意@Transactional只能针对public属性范围内的方法添加
@Transactional
@Controller("statementController")
public class StatementController {
	@Autowired
	private TestService testService;
	public String test() {
		int i=0;
		String message = "";
		String deleteSql ="delete from user where id = 2";
		String saveSql = "insert into user values(?,?,?)";
		Object param[] = {1222,"chenheng1","男"};
		try{
			i=testService.delete(deleteSql, null);
			i=testService.save(saveSql, param);
			i=testService.save(saveSql, param);
		}catch(Exception e){
			message = "主键重复，事务回滚！"+e.getClass()+" ,i = "+i;
			//e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			 
		}
		return message;
	}
}


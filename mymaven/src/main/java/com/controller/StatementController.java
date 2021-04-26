package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.service.TestService;


//@Transactional
//����ע��@Transactional,�Ϳ���ָ���������Ҫ��Spring���������
//ע��@Transactionalֻ�����public���Է�Χ�ڵķ������
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
		Object param[] = {1222,"chenheng1","��"};
		try{
			i=testService.delete(deleteSql, null);
			i=testService.save(saveSql, param);
			i=testService.save(saveSql, param);
		}catch(Exception e){
			message = "�����ظ�������ع���"+e.getClass()+" ,i = "+i;
			//e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			 
		}
		return message;
	}
}


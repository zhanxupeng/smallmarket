package com.mr.dao.factory;

import com.mr.dao.MoneysDao;
import com.mr.dao.impl.MoneysDaoImpl;

public class MoneysFactory {
	public static MoneysDao getMoneysDao(){
		return new MoneysDaoImpl();
	}
}

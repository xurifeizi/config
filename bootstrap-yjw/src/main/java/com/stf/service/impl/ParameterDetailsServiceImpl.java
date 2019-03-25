/**
 * 
 */
package com.stf.service.impl;

import java.util.List;

import com.stf.condition.ParameterDetailsCondition;
import com.stf.dao.ParameterDetailsDao;
import com.stf.service.ParameterDetailsService;

/**
 * @author 司腾飞
 * 2019年1月10日上午10:18:31
 * 本类功能:
 */
public class ParameterDetailsServiceImpl implements ParameterDetailsService {
	
	private ParameterDetailsDao parameterDetailsDao;

	@Override
	public List<String> list(ParameterDetailsCondition condition) {
		return parameterDetailsDao.list(condition);
	}

}

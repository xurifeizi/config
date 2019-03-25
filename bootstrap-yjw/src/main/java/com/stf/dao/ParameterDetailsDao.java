/**
 * 
 */
package com.stf.dao;

import java.util.List;

import com.stf.condition.ParameterDetailsCondition;

/**
 * @author 司腾飞
 * 2019年1月8日下午2:14:21
 * 本类功能:
 */
public interface ParameterDetailsDao {
	
	/**
	 * 函数功能: 根据ID查询手机详细信息
	 * @param parameterDetailsCondition
	 * @return
	 */
	public List<String> list(ParameterDetailsCondition condition);

}

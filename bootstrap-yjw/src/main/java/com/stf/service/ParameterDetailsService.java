/**
 * 
 */
package com.stf.service;

import java.util.List;

import com.stf.condition.ParameterDetailsCondition;

/**
 * @author 司腾飞
 * 2019年1月10日上午10:16:02
 * 本类功能:
 */
public interface ParameterDetailsService {
	/**
	 * 函数功能: 根据ID查询手机详细信息
	 * @param parameterDetailsCondition
	 * @return
	 */
	public List<String> list(ParameterDetailsCondition condition);
}

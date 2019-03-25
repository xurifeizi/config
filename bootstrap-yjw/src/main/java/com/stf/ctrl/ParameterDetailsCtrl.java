/**
 * 
 */
package com.stf.ctrl;

import java.util.ArrayList;
import java.util.List;

import com.stf.condition.ParameterDetailsCondition;
import com.stf.service.ParameterDetailsService;

/**
 * @author 司腾飞
 * 2019年1月10日上午10:22:33
 * 本类功能:
 */
public class ParameterDetailsCtrl {
	
	private ParameterDetailsService parameterDetailsService;
	
	public List<String> search(ParameterDetailsCondition condition) {
		List<String> result = new ArrayList<String>();
		result = parameterDetailsService.list(condition);
		return result;
	}
}

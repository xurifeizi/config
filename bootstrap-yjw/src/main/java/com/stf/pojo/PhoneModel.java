/**
 * 
 */
package com.stf.pojo;

import java.util.Date;

/**
 * @author 司腾飞
 * 2019年1月8日上午10:50:07
 * 本类功能: 手机型号表
 */
public class PhoneModel {
	private String model_id;  // 品牌ID
	private String model_name; // 品牌名
	private double model_floor_price; // 保底价
	private Date model_production_time; // 生产日期
	
	public String getModel_id() {
		return model_id;
	}
	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public double getModel_floor_price() {
		return model_floor_price;
	}
	public void setModel_floor_price(double model_floor_price) {
		this.model_floor_price = model_floor_price;
	}
	public Date getModel_production_time() {
		return model_production_time;
	}
	public void setModel_production_time(Date model_production_time) {
		this.model_production_time = model_production_time;
	}
	
	
}

package cn.p2p.dao;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Tender_record;

public interface Tender_recordMapper {

	/**
	 * 根据标的id查询投标记录
	 */
	Tender_record findByMidBid(@Param(value = "b_id") Integer b_id);

	/**
	 * 修改投标记录
	 */
	int update(Tender_record tender_record);
}

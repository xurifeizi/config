package cn.p2p.dao;

import cn.p2p.pojo.BorrowmarkDetails;

public interface BorrowmarkDetailsMapper {

	/**
	 * 进行标的详情添加
	 */
	int add(BorrowmarkDetails borrowmarkDetails);

	/**
	 * 更改标的详情
	 */
	int update(BorrowmarkDetails borrowmarkDetails);

	/**
	 * 查询标的详情
	 */
	BorrowmarkDetails findByBID(Integer b_id);

}

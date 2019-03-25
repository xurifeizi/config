package cn.p2p.service;

import java.util.List;

import cn.p2p.pojo.Borrowmark;

public interface BorrowmarkService {

	/**
	 * 查询所有借款
	 */
	List<Borrowmark> findAll(Integer from, Integer pageSize);
	
	/**
	 * 查询所有借款数量
	 */
	Integer findAllCount();

	/**
	 * 分页查询数量
	 */
	Integer findCount(Integer status);

	/**
	 * 分页查询
	 */
	List<Borrowmark> findPage(Integer status, Integer from, Integer pageSize);

	/**
	 * 进行标的审核
	 */
	boolean checkBorrow(Integer id, Integer status);

	/**
	 * 进行放款
	 */
	boolean doMarkLoan(Integer b_id);

	/**
	 * 根据id查询
	 */
	Borrowmark findById(Integer id);

	/**
	 * 删除
	 */
	boolean del(Integer id);
}

package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Borrowmark;

public interface BorrowmarkMapper {

	/**
	 * 查询所有借款
	 */
	List<Borrowmark> findAll(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

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
	List<Borrowmark> findPage(@Param(value = "status") Integer status, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

	/**
	 * 修改
	 */
	Integer update(Borrowmark borrowmark);

	/**
	 * 根据id查询
	 */
	Borrowmark findById(Integer id);

	/**
	 * 删除
	 */
	int del(Integer id);
	
}

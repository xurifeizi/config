package cn.p2p.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.p2p.dao.BorrowmarkDetailsMapper;
import cn.p2p.dao.BorrowmarkMapper;
import cn.p2p.dao.Cash_flowMapper;
import cn.p2p.dao.Fund_accountMapper;
import cn.p2p.dao.Tender_recordMapper;
import cn.p2p.pojo.Borrowmark;
import cn.p2p.pojo.BorrowmarkDetails;
import cn.p2p.pojo.Cash_flow;
import cn.p2p.pojo.Fund_account;
import cn.p2p.pojo.Tender_record;
import cn.p2p.service.BorrowmarkService;

@Service
public class BorrowmarkServiceImpl implements BorrowmarkService {

	@Autowired
	private BorrowmarkMapper borrowmarkMapper;
	
	@Autowired
	private BorrowmarkDetailsMapper borrowmarkDetailsMapper;
	
	@Autowired
	private Tender_recordMapper tender_recordMapper;
	
	@Autowired
	private Cash_flowMapper cash_flowMapper;
	
	@Autowired
	private Fund_accountMapper fund_accountMapper;
	
	public List<Borrowmark> findAll(Integer from, Integer pageSize) {
		
		return borrowmarkMapper.findAll(from, pageSize);
	}

	public Integer findAllCount() {
		
		return borrowmarkMapper.findAllCount();
	}

	public Integer findCount(Integer status) {
		
		return borrowmarkMapper.findCount(status);
	}

	public List<Borrowmark> findPage(Integer status, Integer from, Integer pageSize) {
		
		return borrowmarkMapper.findPage(status, from, pageSize);
	}

	public boolean checkBorrow(Integer id, Integer status) {
		
		boolean falg = true;
		Borrowmark borrowmark = new Borrowmark();
		borrowmark.setId(id);
		borrowmark.setStatus(status);
		if (borrowmarkMapper.update(borrowmark) == 0) {
			falg = false;
			throw new RuntimeException("修改标的失败失败!!!");
		}
		if (status == 2) {
			Borrowmark bm = borrowmarkMapper.findById(id);
			BorrowmarkDetails borrowmarkDetails = new BorrowmarkDetails();
			borrowmarkDetails.setBorrow_id(id);
			borrowmarkDetails.setApprove_date(new Date());
			borrowmarkDetails.setTotal_period(bm.getBorrowterm());
			borrowmarkDetails.setRest_period(bm.getBorrowterm());
			// 计算流标时间
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_YEAR, bm.getActivetime());
			borrowmarkDetails.setLiubiao_date(calendar.getTime());

			if (borrowmarkDetailsMapper.add(borrowmarkDetails) == 0) {
				falg = false;
				throw new RuntimeException("修改标的详情失败!!!");
			}
		}
		return falg;
	}

	public boolean doMarkLoan(Integer b_id) {
		
		boolean falg = true;
		Borrowmark borrowmark = borrowmarkMapper.findById(b_id);
		Double money = borrowmark.getBorrowmoney() * ((100 - borrowmark.getLoanfees()) / 100);// 借款会员所获得的钱

		// 修改标的
		borrowmark.setStatus(5);
		if (borrowmarkMapper.update(borrowmark) == 0) {// 修改标的
			falg = false;
			throw new RuntimeException("修改标的失败!!!");
		}

		// 修改标的详情
		BorrowmarkDetails borrowmarkDetails = borrowmarkDetailsMapper.findByBID(b_id);
		borrowmarkDetails.setLending_date(new Date());
		if (borrowmarkDetailsMapper.update(borrowmarkDetails) == 0) {
			falg = false;
			throw new RuntimeException("修改标的详情失败!!!");
		}

		// 修改会员帐户资金
		Fund_account fund_account = fund_accountMapper.findByMID(borrowmark.getM_id());
		Double newMoney = fund_account.getAmount() + money;
		fund_account.setAmount(newMoney);
		fund_account.setUpdate_date(new Date());
		if (fund_accountMapper.update(fund_account) == 0) {
			falg = false;
			throw new RuntimeException("修改会员帐户资金失败!!!");
		}

		// 修改会员流水
		String str = "放款，现金账户   +" + money;
		Cash_flow cash_flow = new Cash_flow("FK", borrowmark.getM_id(), money, 0.0, newMoney, str, new Date());
		if (cash_flowMapper.add(cash_flow) == 0) {
			falg = false;
			throw new RuntimeException("修改会员流水失败!!!");
		}

		// 修改投标记录
		Tender_record tender_record = tender_recordMapper.findByMidBid(b_id);
		tender_record.setIs_fangkuan("Y");
		if (tender_recordMapper.update(tender_record) == 0) {
			falg = false;
			throw new RuntimeException("修改投标记录失败!!!");
		}
		return falg;
	}

	public Borrowmark findById(Integer id) {
		
		return borrowmarkMapper.findById(id);
	}
	
	public boolean del(Integer id) {
		
		boolean falg = false;
		
		if (borrowmarkMapper.del(id) > 0) {
			falg = true;
		}
		return falg;
	}

}

package com.capgemini.fds.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.Bill;
import com.capgemini.fds.exceptions.DuplicateBillException;
import com.capgemini.fds.exceptions.NoSuchBillException;
import com.capgemini.fds.repositories.IBillRepository;

@Service("billservice")
public class IBillServiceImpl implements IBillService {

	@Autowired
	private IBillRepository repository;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public Bill addBill(Bill bill) throws DuplicateBillException {
			try {
				Bill result = repository.save(bill);
				return (result.getBillId() > 0 ) ? result:null;
			}catch(ConstraintViolationException e) {
				throw new DuplicateBillException("Duplicate Bill found");
			}
	}

	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bill removeBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bill viewBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bill> viewBills() {
		return repository.findAll();
	}
	
	@Override
	public Bill findBillById(int billId) throws NoSuchBillException {
		Optional<Bill> result =  repository.findById(billId);
		Bill bill1 = null;
		if(result.isPresent()) {
			bill1 = result.get();
		}else {
			throw new NoSuchBillException("Bill not found");
		}
		return bill1;

	}

	@Override
	public List<Bill> viewBills(String custId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
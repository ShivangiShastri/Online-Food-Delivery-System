package com.capgemini.fds.services;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.fds.entities.Bill;
import com.capgemini.fds.exceptions.DuplicateBillException;
import com.capgemini.fds.exceptions.NoSuchBillException;

public interface IBillService {

	public Bill addBill(Bill bill) throws DuplicateBillException;
	public Bill updateBill(Bill bill);
	public Bill removeBill(Bill bill);
	public Bill viewBill(Bill bill);
	public List<Bill> viewBills(LocalDate startDate,LocalDate endDate);
	public List<Bill> viewBills(String custId);
	public Bill findBillById(int billId) throws NoSuchBillException;
	public List<Bill> viewBills();
	
}
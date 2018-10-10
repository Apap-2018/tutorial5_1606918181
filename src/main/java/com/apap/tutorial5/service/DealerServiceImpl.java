package com.apap.tutorial5.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;

@Service
@Transactional
public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDb dealerDb;
	
	@Override 
	public Optional<DealerModel> getDealerDetailById(Long id){
		return dealerDb.findById(id);
	}
	
	@Override
	public void addDealer(DealerModel dealer) {
		dealerDb.save(dealer);
	}

	@Override
	public void deleteDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.delete(dealer);
	}

	@Override
	public void updateDealer(long id, Optional<DealerModel> newDealer) {
		// TODO Auto-generated method stub
		DealerModel dealer = dealerDb.getOne(id);
		dealer.setAlamat(newDealer.get().getAlamat());
		dealer.setNoTelp(newDealer.get().getNoTelp());
		dealerDb.save(dealer);
	}

	@Override
	public DealerDb viewAll() {
		// TODO Auto-generated method stub
		return dealerDb;
	}
}

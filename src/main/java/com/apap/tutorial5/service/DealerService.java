package com.apap.tutorial5.service;

import java.util.Optional;

import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;

public interface DealerService {
	
	void addDealer(DealerModel dealer);

	void deleteDealer(DealerModel model);

	void updateDealer(long id, Optional<DealerModel> dealer);

	DealerDb viewAll();

	Optional<DealerModel> getDealerDetailById(Long id);
}


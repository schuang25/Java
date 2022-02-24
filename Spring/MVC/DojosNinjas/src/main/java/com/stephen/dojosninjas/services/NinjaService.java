package com.stephen.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.stephen.dojosninjas.models.Ninja;
import com.stephen.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
}

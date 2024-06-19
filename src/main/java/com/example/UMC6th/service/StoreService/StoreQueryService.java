package com.example.UMC6th.service.StoreService;

import com.example.UMC6th.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}
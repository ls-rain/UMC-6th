package com.example.UMC6th.service.StoreService;

import com.example.UMC6th.domain.Store;
import com.example.UMC6th.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }
}
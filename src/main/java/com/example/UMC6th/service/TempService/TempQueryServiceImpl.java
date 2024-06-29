package com.example.UMC6th.service.TempService;

import com.example.UMC6th.apiPayLoad.code.status.ErrorStatus;
import com.example.UMC6th.apiPayLoad.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    @Override
    public void checkFlag(Integer flag) {
        if(flag == 1){
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}

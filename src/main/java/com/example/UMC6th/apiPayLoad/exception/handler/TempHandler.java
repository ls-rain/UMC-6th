package com.example.UMC6th.apiPayLoad.exception.handler;

import com.example.UMC6th.apiPayLoad.code.BaseErrorCode;
import com.example.UMC6th.apiPayLoad.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}

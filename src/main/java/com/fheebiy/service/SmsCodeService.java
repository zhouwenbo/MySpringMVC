package com.fheebiy.service;

import com.fheebiy.repo.SmsCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cm on 2017/3/27.
 */
@Service
public class SmsCodeService {

    @Autowired
    private SmsCodeRepo repo;



}

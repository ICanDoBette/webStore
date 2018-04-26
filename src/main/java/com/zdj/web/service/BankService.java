package com.zdj.web.service;

import com.zdj.web.model.BankModel;

import java.util.List;

public interface BankService {
    public List<List<BankModel>> getBanks();
}

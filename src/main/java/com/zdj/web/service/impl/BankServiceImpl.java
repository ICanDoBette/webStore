package com.zdj.web.service.impl;

import com.zdj.web.mapper.BanksMapper;
import com.zdj.web.model.BankModel;
import com.zdj.web.pojo.Banks;
import com.zdj.web.pojo.BanksExample;
import com.zdj.web.service.BankService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BanksMapper banksMapper;

    @Override
    public List<List<BankModel>> getBanks() {
        BanksExample banksExample = new BanksExample();
        banksExample.or().andIsDeleteEqualTo(new Byte("0"));
        banksExample.setOrderByClause("level desc");
        List<Banks> banks = banksMapper.selectByExample(banksExample);
        List<List<BankModel>> result = new ArrayList<>();
        for (int i = 0; i <= banks.size() / 4; i++) {
            List<BankModel> smallList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                if (i * 4 + j != banks.size()) {
                    Banks temp = banks.get(i * 4 + j);
                    BankModel tempResult = new BankModel();
                    BeanUtils.copyProperties(temp, tempResult);
                    smallList.add(tempResult);
                } else {
                    break;
                }
            }
            result.add(smallList);
        }
        return result;
    }
}

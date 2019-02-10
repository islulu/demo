package com.alu.scaffold.service.impl;

import com.alu.scaffold.dto.OneDO;
import com.alu.scaffold.mapper.OneMapper;
import com.alu.scaffold.service.OneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OneServiceImpl implements OneService {
    @Resource
    private OneMapper oneMapper;

    @Override
    public List<OneDO> selectAll() {
        List<OneDO> oneDOS = oneMapper.selectAll();
        return oneDOS;
    }
}

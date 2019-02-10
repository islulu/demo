package com.alu.scaffold.mapper;

import com.alu.scaffold.dto.OneDO;
import com.alu.scaffold.common.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OneMapper extends IBaseMapper<OneDO> {

    Integer getOne();

}
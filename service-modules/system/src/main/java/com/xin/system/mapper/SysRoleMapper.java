package com.xin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.system.domain.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:05
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<String> getRoleNameById(@Param("id") Long id);
}

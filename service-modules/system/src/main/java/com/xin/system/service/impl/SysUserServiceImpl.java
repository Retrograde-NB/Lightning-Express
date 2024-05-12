package com.xin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.xin.common.constant.Constants;
import com.xin.common.domain.auth.vo.UserInfoVo;
import com.xin.common.exception.XinException;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.MD5Utils;
import com.xin.common.utils.ReflectionUtils;
import com.xin.common.utils.StringUtils;
import com.xin.system.domain.dto.SysUserAddDTO;
import com.xin.system.domain.dto.SysUserPageDTO;
import com.xin.system.domain.entity.SysUser;
import com.xin.system.domain.vo.SysUserPageVO;
import com.xin.system.domain.vo.SysUserVO;
import com.xin.system.mapper.SysUserMapper;
import com.xin.system.service.SysRoleService;
import com.xin.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    private final SysRoleService sysRoleService;

    public SysUserServiceImpl(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Override
    public ResponseResult<UserInfoVo> getUserInfoByUsername(String username) {
        SysUser sysUser = sysUserMapper.getUserInfoByUsername(username);
        if (Objects.isNull(sysUser)) {
            return ResponseResult.fail("用户不存在");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(sysUser, userInfoVo);
        return ResponseResult.ok(userInfoVo);
    }
    @Override
    public ResponseResult<UserInfoVo> getUserInfoById(Long id) {
        SysUser sysUser = sysUserMapper.getUserInfoById(id);
        if (Objects.isNull(sysUser)) {
            return ResponseResult.fail("获取失败");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(sysUser, userInfoVo);
        return ResponseResult.ok(userInfoVo);
    }

    @Override
    public ResponseResult<SysUserPageVO> page(SysUserPageDTO sysUserPageDTO) {
        List<SysUser> sysUserList = sysUserMapper.page(sysUserPageDTO);
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUserList);
        List<SysUserVO> sysUserVOList = sysUserList.stream().map(sysUser -> {
            SysUserVO sysUserVO = ReflectionUtils.newInstance(SysUserVO.class);
            BeanUtils.copyProperties(sysUser, sysUserVO);
            sysUserVO.setPhoneNumber(StringUtils.desensitizePhoneNumber(sysUser.getPhoneNumber()));
            sysUserVO.setRoleList(sysRoleService.getRoleNameById(sysUser.getId()));
            return sysUserVO;
        }).collect(Collectors.toList());
        // 封装数据
        SysUserPageVO sysUserPageVO = ReflectionUtils.newInstance(SysUserPageVO.class);
        sysUserPageVO.setTotal(sysUserPageInfo.getTotal());
        sysUserPageVO.setSize(sysUserPageInfo.getSize());
        sysUserPageVO.setPages(sysUserPageInfo.getPages());
        sysUserPageVO.setCurrent(sysUserPageInfo.getPageNum());
        sysUserPageVO.setRecords(sysUserVOList);
        return ResponseResult.ok(sysUserPageVO);
    }

    @Override
    public ResponseResult<String> add(SysUserAddDTO sysUserAddDTO) {
        if (StringUtils.isEmpty(sysUserAddDTO.getUserName())){
            throw new XinException(Constants.FAIL, "用户名不能为空");
        }
        if (StringUtils.isEmpty(sysUserAddDTO.getNickName())){
            throw new XinException(Constants.FAIL, "昵称不能为空");
        }
        if (StringUtils.isEmpty(sysUserAddDTO.getPassword())){
            throw new XinException(Constants.FAIL, "密码不能为空");
        }
        SysUser sysUser = sysUserMapper.getUserInfoByUsername(sysUserAddDTO.getUserName());
        if (StringUtils.isNotNull(sysUser)) {
            throw new XinException(Constants.FAIL, "用户已存在");
        }
        if (StringUtils.isNotEmpty(sysUserAddDTO.getPhoneNumber())) {
            sysUser = sysUserMapper.getUserInfoByPhoneNumber(sysUserAddDTO.getPhoneNumber());
            if (StringUtils.isNotNull(sysUser)) {
                throw new XinException(Constants.FAIL, "电话已存在");
            }
        }
        sysUser = ReflectionUtils.newInstance(SysUser.class);
        BeanUtils.copyProperties(sysUserAddDTO, sysUser);
        sysUser.setPassword(MD5Utils.transToMD5(sysUser.getPassword()));

        sysUser.setCreateBy(getTokenId());
        sysUser.setUpdateBy(getTokenId());

        int result = sysUserMapper.add(sysUser);
        return result > 0 ? ResponseResult.ok("添加成功") : ResponseResult.fail();
    }

    public String getTokenId(){
        return JwtUtils.getId().toString();
    }

}

package com.atguigu.gmall.user.service.impl;import com.alibaba.dubbo.config.annotation.Service;import com.atguigu.gmall.bean.UmsMember;import com.atguigu.gmall.service.UmsMemberService;import com.atguigu.gmall.user.mapper.UmsMemberMapper;import org.springframework.beans.factory.annotation.Autowired;import java.util.List;/** * @ClassName UmsMemberServiceImpl * @Author 19680 * @Date 2020/2/12 0:00 * @Version 1.0 * @Description TODO **/@Servicepublic class UmsMemberServiceImpl implements UmsMemberService {    @Autowired    UmsMemberMapper umsMemberMapper;    @Override    public UmsMember saveUmsMember(UmsMember umsMember) {//        UmsMember member = new UmsMember();//        List<UmsMember> umsMemberList = umsMemberMapper.select(umsMember);//        if (umsMemberList == null || !(umsMemberList.size() > 0)){//            int insert = umsMemberMapper.insert(umsMember);//        }else {//            UmsMember selectOne = umsMemberMapper.selectOne(umsMember);//            umsMember.setId(selectOne.getId());//            umsMemberMapper.updateByPrimaryKeySelective(umsMember);//        }//        member = umsMemberMapper.selectOne(umsMember);//        return member;        String sourceUid = umsMember.getSourceUid();        UmsMember umsMemberParam = new UmsMember();        umsMemberParam.setSourceUid(sourceUid);        UmsMember umsMemberDbResult = umsMemberMapper.selectOne(umsMemberParam);        if(umsMemberDbResult==null){            umsMemberMapper.insertSelective(umsMember);            umsMemberDbResult = umsMemberMapper.selectOne(umsMemberParam);        }        return umsMemberDbResult;    }}
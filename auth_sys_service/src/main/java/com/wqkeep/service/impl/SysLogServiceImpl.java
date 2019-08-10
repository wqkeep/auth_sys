package com.wqkeep.service.impl;

import com.wqkeep.dao.ISysLogDao;
import com.wqkeep.domain.SysLog;
import com.wqkeep.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }

    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
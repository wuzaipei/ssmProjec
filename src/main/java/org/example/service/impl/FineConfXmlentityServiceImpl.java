package org.example.service.impl;

import com.github.pagehelper.PageInfo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.example.dao.FineConfXmlentityDao;
import org.example.model.fine_conf_xmlentity;
import org.example.service.FineConfXmlentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// @Transactional /*事务注解*/
public class FineConfXmlentityServiceImpl implements FineConfXmlentityService {

    @Autowired
    private FineConfXmlentityDao fineConfXmlentityDao;

    @Override
    public String findAll() {
        fine_conf_xmlentity f = fineConfXmlentityDao.findAll();
        return f.getId().toString();
    }

    @Override
    public StringBuffer findAllListing() {
        List<fine_conf_xmlentity> allList = fineConfXmlentityDao.findAllList();
        StringBuffer str = new StringBuffer();
        allList.forEach(item ->{
            str.append(item.toString());
        });
        return str;
    }

    public List<fine_conf_xmlentity> queryAll(){
        return fineConfXmlentityDao.findAllList();
    }


}

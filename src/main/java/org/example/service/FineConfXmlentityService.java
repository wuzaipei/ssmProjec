package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.model.fine_conf_xmlentity;

import java.util.List;

public interface FineConfXmlentityService {
    public String findAll();

    public StringBuffer findAllListing();

    public List<fine_conf_xmlentity> queryAll();


}

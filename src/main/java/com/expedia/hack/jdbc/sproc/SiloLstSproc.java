/**
 *
 * SiloLstSproc.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.jdbc.sproc;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.expedia.hack.Silo;
import com.expedia.hack.jdbc.sproc.rowmapper.SiloLstRowMapper;

/**
 * TODO v-dmelnikov Describe SiloLstSproc
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
@Component
public class SiloLstSproc extends StoredProcedure {

    @Autowired
    @Qualifier("dataSourcePOIROT")
    private DataSource dataSource;

    private static final String SPROC_NAME = "SiloLst";
    private SiloLstRowMapper rowMapper;

    @PostConstruct
    public void init() {
        setSql(SPROC_NAME);
        setDataSource(dataSource);
        rowMapper = new SiloLstRowMapper();
        compile();
    }

    public List<Silo> execute() {
        Map<String, Object> result = super.execute();
        return rowMapper.mapSprocResult(result);
    }

}

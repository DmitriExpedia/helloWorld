/**
 *
 * OverflowStatusHistorySearchSproc.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.expedia.hack.jdbc.sproc;

import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.expedia.hack.jdbc.sproc.rowmapper.OverflowStatusHistorySearchRowMapper;
import com.expedia.hack.vm.OverflowHistory;

/**
 * TODO v-dmelnikov Describe OverflowStatusHistorySearchSproc
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 *
 */
@Component
public class OverflowStatusHistorySearchSproc  extends StoredProcedure {
    @Autowired
    @Qualifier("dataSourcePOIROT")
    private DataSource dataSource;

    private static final String SPROC_NAME = "OverflowStatusHistorySearch";
    private OverflowStatusHistorySearchRowMapper rowMapper;
    
    private static final String START_DATE_PARAM = "pStartDate";
    private static final String END_DATE_PARAM = "pEndDate";
    private static final String SILO_LIST_PARAM = "pSiloList";
    private static final String STATUS_CODE_PARAM = "pStatusCodeList";


    @PostConstruct
    public void init() {
        setSql(SPROC_NAME);
        setDataSource(dataSource);
        declareParameter(new SqlParameter(START_DATE_PARAM, Types.TIMESTAMP));
        declareParameter(new SqlParameter(END_DATE_PARAM, Types.TIMESTAMP));
        declareParameter(new SqlParameter(SILO_LIST_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(STATUS_CODE_PARAM, Types.VARCHAR));
        rowMapper = new OverflowStatusHistorySearchRowMapper();
        compile();
    }

    public List<OverflowHistory> execute(Date start, Date end, String siloList, String statusCodeList) {
        Map<String, Object> result = super.execute(start, end, siloList, statusCodeList);
        return rowMapper.mapSprocResult(result);
    }
}

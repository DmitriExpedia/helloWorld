/**
 *
 * AuditEventSearchLstSproc.java
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

import com.expedia.hack.audit.AuditEvent;
import com.expedia.hack.jdbc.sproc.rowmapper.AuditEventSearchLstRowMapper;

/**
 * AuditEventSearchLstSproc
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 *
 */
@Component
public class AuditEventSearchLstSproc  extends StoredProcedure {

    private static final String SPROC_NAME = "AuditEventSearchLst#21";
    
    private static final String START_DATE_PARAM = "pStartDate";
    
    private static final String TYPE_PARAM = "pType";
    private static final String NATURE_PARAM = "pNature";
    private static final String EVENT_PATH_PARAM = "pEventPath";
    private static final String OLD_VALUE_PARAM = "pOldValue";
    private static final String NEW_VALUE_PARAM = "pNewValue";
    private static final String CREATION_USER_PARAM = "pCreationUser";
    private static final String ORIGINATOR_IP_PARAM = "pOriginatorIP";
    private static final String END_DATE_PARAM = "pEndDate";
    
    

    
    
    
    private AuditEventSearchLstRowMapper rowMapper;
    
    
    @Autowired
    @Qualifier("dataSourceTRAN") 
    private DataSource dataSource;
    
    @PostConstruct
    public void init() {
        setSql(SPROC_NAME);
        setDataSource(dataSource);
        declareParameter(new SqlParameter(TYPE_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(NATURE_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(EVENT_PATH_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(OLD_VALUE_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(NEW_VALUE_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(CREATION_USER_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(ORIGINATOR_IP_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(START_DATE_PARAM, Types.TIMESTAMP));
        declareParameter(new SqlParameter(END_DATE_PARAM, Types.TIMESTAMP));
        rowMapper = new AuditEventSearchLstRowMapper();
        compile();
    }

    public List<AuditEvent> execute(Date start, Date end) {
        Map<String, Object> result = super.execute(null, null, null, null, null, null, null, start, end);
        return rowMapper.mapSprocResult(result);
    }
}

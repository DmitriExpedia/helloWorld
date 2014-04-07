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

import com.expedia.hack.jdbc.sproc.rowmapper.NackedPartnerSearchRowMapper;
import com.expedia.hack.vm.NackedPartnerHistory;

/**
 * @author v-sdalzhanok
 *
 */
@Component
public class NackedPartnerSearchSproc extends StoredProcedure {
	@Autowired
	@Qualifier("dataSourcePOIROT")
	private DataSource dataSource;
	 
	private static final String SPROC_NAME = "VolumeManagementHistorySearch#01";
	private  NackedPartnerSearchRowMapper rowMapper;
	    
	private static final String START_DATE_PARAM = "pStartDate";
	private static final String END_DATE_PARAM = "pEndDate";
	private static final String SILO_LIST_PARAM = "pSiloList";
	private static final String PARTNER_ID_LIST = "pPartnerIDList";
	private static final String IS_ACTIVE = "pIsActive";
	private static final String IS_NACKED = "pIsNacked";
 
	@PostConstruct
    public void init() {
        setSql(SPROC_NAME);
        setDataSource(dataSource);
        declareParameter(new SqlParameter(START_DATE_PARAM, Types.TIMESTAMP));
        declareParameter(new SqlParameter(END_DATE_PARAM, Types.TIMESTAMP));
        declareParameter(new SqlParameter(SILO_LIST_PARAM, Types.VARCHAR));
        declareParameter(new SqlParameter(PARTNER_ID_LIST, Types.VARCHAR));
        declareParameter(new SqlParameter(IS_ACTIVE, Types.BIT));
        declareParameter(new SqlParameter(IS_NACKED, Types.BIT));
        
        rowMapper = new  NackedPartnerSearchRowMapper();
        compile();
    }

    public List< NackedPartnerHistory> execute(Date start, Date end, String siloList, String partnerIdList, int isActive, int isNacked) {
        Map<String, Object> result = super.execute(start, end, siloList, partnerIdList, isActive, isNacked);
        return rowMapper.mapSprocResult(result);
    }
}

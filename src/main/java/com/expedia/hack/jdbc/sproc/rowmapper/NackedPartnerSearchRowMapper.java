package com.expedia.hack.jdbc.sproc.rowmapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.expedia.hack.vm.NackedPartnerHistory;

/**
 * @author v-sdalzhanok
 *
 */
public class NackedPartnerSearchRowMapper {
	private final static String CREATION_DATE = "CreationDate";
	private final static String COVERED_PERIOD = "CoveredPeriod";
	private final static String SILO_ID = "SiloID";
    private final static String IP_ADDRESS = "IPAddress";
    private final static String PARTNER_ID = "PartnerID";
    private final static String BUSINESS_NAME = "BusinessName";
    private final static String IS_ACTIVE = "IsActive";
    private final static String IS_NACKED = "IsNacked";
    private final static String PCT_MESSAGE_IN = "PctMessageIn";
    private final static String PCT_UPDATE = "PctUpdate";
    private final static String PCT_OUT_FAIL = "PctOutFail";
    private final static String PCT_OUT_RESPONSE_TIME = "PctOutResponseTime";
    private final static String PCT_CAPACITY_ALLOWED = "PctCapacityAllowed";

    private final static String INET_DRIVER_RESULT_SET_1_RESULT_NAME = "#result-set-1";

    public List<NackedPartnerHistory> mapSprocResult(Map<String, Object> rawResponse) {
        List<NackedPartnerHistory> historyRecords = null;

        if (rawResponse != null && !rawResponse.isEmpty()) {
            List<Map<String, Object>> resultSet = (List<Map<String, Object>>) rawResponse
                    .get(INET_DRIVER_RESULT_SET_1_RESULT_NAME);

            if (resultSet != null) {
                historyRecords = new ArrayList<NackedPartnerHistory>(resultSet.size());

                for (Map<String, Object> row : resultSet) {
                	NackedPartnerHistory history = new NackedPartnerHistory();
                	history.setSiloID((Integer) row.get(SILO_ID));
                	history.setIpAddress((String) row.get(IP_ADDRESS));
                	history.setCreationDate((Date) row.get(CREATION_DATE));
                	history.setPartnerID((String) row.get(PARTNER_ID));
                	history.setBusinessName((String) row.get(BUSINESS_NAME));
                	history.setCoveredPeriod((Integer) row.get(COVERED_PERIOD));
                	history.setIsActive((Boolean) row.get(IS_ACTIVE));
                	history.setIsNacked((Boolean) row.get(IS_NACKED));
                	history.setPctCapacityAllowed((BigDecimal) row.get(PCT_CAPACITY_ALLOWED));
                	history.setPctMessageIn((BigDecimal) row.get(PCT_MESSAGE_IN));
                	history.setPctOutFail((BigDecimal) row.get(PCT_OUT_FAIL));
                	history.setPctOutResponseTime((BigDecimal) row.get(PCT_OUT_RESPONSE_TIME));
                	history.setPctUpdate((BigDecimal) row.get(PCT_UPDATE));
                	
                    historyRecords.add(history);
                }

            }
        }

        return historyRecords;
    }
}

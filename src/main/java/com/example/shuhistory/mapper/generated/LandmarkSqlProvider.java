package com.example.shuhistory.mapper.generated;

import com.example.shuhistory.entity.LandmarkExample;
import com.example.shuhistory.entity.LandmarkExample.Criteria;
import com.example.shuhistory.entity.LandmarkExample.Criterion;
import com.example.shuhistory.entity.LandmarkWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class LandmarkSqlProvider {

    public String countByExample(LandmarkExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("landmark");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(LandmarkExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("landmark");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(LandmarkWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("landmark");
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=VARCHAR}");
        }
        
        if (record.getPlaceName() != null) {
            sql.VALUES("place_name", "#{placeName,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitudeLatitude() != null) {
            sql.VALUES("longitude_latitude", "#{longitudeLatitude,jdbcType=VARCHAR}");
        }
        
        if (record.getEventTitle() != null) {
            sql.VALUES("event_title", "#{eventTitle,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getEventContent() != null) {
            sql.VALUES("event_content", "#{eventContent,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.VALUES("picture", "#{picture,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(LandmarkExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("time");
        sql.SELECT("place_name");
        sql.SELECT("longitude_latitude");
        sql.SELECT("event_title");
        sql.SELECT("event_content");
        sql.SELECT("picture");
        sql.FROM("landmark");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(LandmarkExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("time");
        sql.SELECT("place_name");
        sql.SELECT("longitude_latitude");
        sql.FROM("landmark");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        LandmarkWithBLOBs record = (LandmarkWithBLOBs) parameter.get("record");
        LandmarkExample example = (LandmarkExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("landmark");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{record.time,jdbcType=VARCHAR}");
        }
        
        if (record.getPlaceName() != null) {
            sql.SET("place_name = #{record.placeName,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitudeLatitude() != null) {
            sql.SET("longitude_latitude = #{record.longitudeLatitude,jdbcType=VARCHAR}");
        }
        
        if (record.getEventTitle() != null) {
            sql.SET("event_title = #{record.eventTitle,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getEventContent() != null) {
            sql.SET("event_content = #{record.eventContent,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.SET("picture = #{record.picture,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("landmark");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("time = #{record.time,jdbcType=VARCHAR}");
        sql.SET("place_name = #{record.placeName,jdbcType=VARCHAR}");
        sql.SET("longitude_latitude = #{record.longitudeLatitude,jdbcType=VARCHAR}");
        sql.SET("event_title = #{record.eventTitle,jdbcType=LONGVARCHAR}");
        sql.SET("event_content = #{record.eventContent,jdbcType=LONGVARCHAR}");
        sql.SET("picture = #{record.picture,jdbcType=LONGVARCHAR}");
        
        LandmarkExample example = (LandmarkExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("landmark");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("time = #{record.time,jdbcType=VARCHAR}");
        sql.SET("place_name = #{record.placeName,jdbcType=VARCHAR}");
        sql.SET("longitude_latitude = #{record.longitudeLatitude,jdbcType=VARCHAR}");
        
        LandmarkExample example = (LandmarkExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LandmarkWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("landmark");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=VARCHAR}");
        }
        
        if (record.getPlaceName() != null) {
            sql.SET("place_name = #{placeName,jdbcType=VARCHAR}");
        }
        
        if (record.getLongitudeLatitude() != null) {
            sql.SET("longitude_latitude = #{longitudeLatitude,jdbcType=VARCHAR}");
        }
        
        if (record.getEventTitle() != null) {
            sql.SET("event_title = #{eventTitle,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getEventContent() != null) {
            sql.SET("event_content = #{eventContent,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.SET("picture = #{picture,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, LandmarkExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
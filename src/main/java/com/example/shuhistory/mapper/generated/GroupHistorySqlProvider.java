package com.example.shuhistory.mapper.generated;

import com.example.shuhistory.entity.GroupHistory;
import com.example.shuhistory.entity.GroupHistoryExample;
import com.example.shuhistory.entity.GroupHistoryExample.Criteria;
import com.example.shuhistory.entity.GroupHistoryExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class GroupHistorySqlProvider {

    public String countByExample(GroupHistoryExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("group_history");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(GroupHistoryExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("group_history");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(GroupHistory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("group_history");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.VALUES("picture", "#{picture,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(GroupHistoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("picture");
        sql.SELECT("title");
        sql.SELECT("content");
        sql.FROM("group_history");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(GroupHistoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.FROM("group_history");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        GroupHistory record = (GroupHistory) parameter.get("record");
        GroupHistoryExample example = (GroupHistoryExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("group_history");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.SET("picture = #{record.picture,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("group_history");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=LONGVARCHAR}");
        sql.SET("picture = #{record.picture,jdbcType=LONGVARCHAR}");
        sql.SET("title = #{record.title,jdbcType=LONGVARCHAR}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        GroupHistoryExample example = (GroupHistoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("group_history");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        
        GroupHistoryExample example = (GroupHistoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GroupHistory record) {
        SQL sql = new SQL();
        sql.UPDATE("group_history");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.SET("picture = #{picture,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, GroupHistoryExample example, boolean includeExamplePhrase) {
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
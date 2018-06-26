package com.joy.java.mybatis.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

public class QyCsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QyCsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCsidIsNull() {
            addCriterion("csid is null");
            return (Criteria) this;
        }

        public Criteria andCsidIsNotNull() {
            addCriterion("csid is not null");
            return (Criteria) this;
        }

        public Criteria andCsidEqualTo(Integer value) {
            addCriterion("csid =", value, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidNotEqualTo(Integer value) {
            addCriterion("csid <>", value, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidGreaterThan(Integer value) {
            addCriterion("csid >", value, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("csid >=", value, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidLessThan(Integer value) {
            addCriterion("csid <", value, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidLessThanOrEqualTo(Integer value) {
            addCriterion("csid <=", value, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidIn(List<Integer> values) {
            addCriterion("csid in", values, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidNotIn(List<Integer> values) {
            addCriterion("csid not in", values, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidBetween(Integer value1, Integer value2) {
            addCriterion("csid between", value1, value2, "csid");
            return (Criteria) this;
        }

        public Criteria andCsidNotBetween(Integer value1, Integer value2) {
            addCriterion("csid not between", value1, value2, "csid");
            return (Criteria) this;
        }

        public Criteria andCsSfidIsNull() {
            addCriterion("cs_sfid is null");
            return (Criteria) this;
        }

        public Criteria andCsSfidIsNotNull() {
            addCriterion("cs_sfid is not null");
            return (Criteria) this;
        }

        public Criteria andCsSfidEqualTo(Integer value) {
            addCriterion("cs_sfid =", value, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidNotEqualTo(Integer value) {
            addCriterion("cs_sfid <>", value, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidGreaterThan(Integer value) {
            addCriterion("cs_sfid >", value, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs_sfid >=", value, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidLessThan(Integer value) {
            addCriterion("cs_sfid <", value, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidLessThanOrEqualTo(Integer value) {
            addCriterion("cs_sfid <=", value, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidIn(List<Integer> values) {
            addCriterion("cs_sfid in", values, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidNotIn(List<Integer> values) {
            addCriterion("cs_sfid not in", values, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidBetween(Integer value1, Integer value2) {
            addCriterion("cs_sfid between", value1, value2, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsSfidNotBetween(Integer value1, Integer value2) {
            addCriterion("cs_sfid not between", value1, value2, "csSfid");
            return (Criteria) this;
        }

        public Criteria andCsNoIsNull() {
            addCriterion("cs_no is null");
            return (Criteria) this;
        }

        public Criteria andCsNoIsNotNull() {
            addCriterion("cs_no is not null");
            return (Criteria) this;
        }

        public Criteria andCsNoEqualTo(String value) {
            addCriterion("cs_no =", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoNotEqualTo(String value) {
            addCriterion("cs_no <>", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoGreaterThan(String value) {
            addCriterion("cs_no >", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoGreaterThanOrEqualTo(String value) {
            addCriterion("cs_no >=", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoLessThan(String value) {
            addCriterion("cs_no <", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoLessThanOrEqualTo(String value) {
            addCriterion("cs_no <=", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoLike(String value) {
            addCriterion("cs_no like", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoNotLike(String value) {
            addCriterion("cs_no not like", value, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoIn(List<String> values) {
            addCriterion("cs_no in", values, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoNotIn(List<String> values) {
            addCriterion("cs_no not in", values, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoBetween(String value1, String value2) {
            addCriterion("cs_no between", value1, value2, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsNoNotBetween(String value1, String value2) {
            addCriterion("cs_no not between", value1, value2, "csNo");
            return (Criteria) this;
        }

        public Criteria andCsMcIsNull() {
            addCriterion("cs_mc is null");
            return (Criteria) this;
        }

        public Criteria andCsMcIsNotNull() {
            addCriterion("cs_mc is not null");
            return (Criteria) this;
        }

        public Criteria andCsMcEqualTo(String value) {
            addCriterion("cs_mc =", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcNotEqualTo(String value) {
            addCriterion("cs_mc <>", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcGreaterThan(String value) {
            addCriterion("cs_mc >", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcGreaterThanOrEqualTo(String value) {
            addCriterion("cs_mc >=", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcLessThan(String value) {
            addCriterion("cs_mc <", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcLessThanOrEqualTo(String value) {
            addCriterion("cs_mc <=", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcLike(String value) {
            addCriterion("cs_mc like", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcNotLike(String value) {
            addCriterion("cs_mc not like", value, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcIn(List<String> values) {
            addCriterion("cs_mc in", values, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcNotIn(List<String> values) {
            addCriterion("cs_mc not in", values, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcBetween(String value1, String value2) {
            addCriterion("cs_mc between", value1, value2, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsMcNotBetween(String value1, String value2) {
            addCriterion("cs_mc not between", value1, value2, "csMc");
            return (Criteria) this;
        }

        public Criteria andCsJcIsNull() {
            addCriterion("cs_jc is null");
            return (Criteria) this;
        }

        public Criteria andCsJcIsNotNull() {
            addCriterion("cs_jc is not null");
            return (Criteria) this;
        }

        public Criteria andCsJcEqualTo(String value) {
            addCriterion("cs_jc =", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcNotEqualTo(String value) {
            addCriterion("cs_jc <>", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcGreaterThan(String value) {
            addCriterion("cs_jc >", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcGreaterThanOrEqualTo(String value) {
            addCriterion("cs_jc >=", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcLessThan(String value) {
            addCriterion("cs_jc <", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcLessThanOrEqualTo(String value) {
            addCriterion("cs_jc <=", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcLike(String value) {
            addCriterion("cs_jc like", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcNotLike(String value) {
            addCriterion("cs_jc not like", value, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcIn(List<String> values) {
            addCriterion("cs_jc in", values, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcNotIn(List<String> values) {
            addCriterion("cs_jc not in", values, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcBetween(String value1, String value2) {
            addCriterion("cs_jc between", value1, value2, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsJcNotBetween(String value1, String value2) {
            addCriterion("cs_jc not between", value1, value2, "csJc");
            return (Criteria) this;
        }

        public Criteria andCsCtqhIsNull() {
            addCriterion("cs_ctqh is null");
            return (Criteria) this;
        }

        public Criteria andCsCtqhIsNotNull() {
            addCriterion("cs_ctqh is not null");
            return (Criteria) this;
        }

        public Criteria andCsCtqhEqualTo(String value) {
            addCriterion("cs_ctqh =", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhNotEqualTo(String value) {
            addCriterion("cs_ctqh <>", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhGreaterThan(String value) {
            addCriterion("cs_ctqh >", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhGreaterThanOrEqualTo(String value) {
            addCriterion("cs_ctqh >=", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhLessThan(String value) {
            addCriterion("cs_ctqh <", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhLessThanOrEqualTo(String value) {
            addCriterion("cs_ctqh <=", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhLike(String value) {
            addCriterion("cs_ctqh like", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhNotLike(String value) {
            addCriterion("cs_ctqh not like", value, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhIn(List<String> values) {
            addCriterion("cs_ctqh in", values, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhNotIn(List<String> values) {
            addCriterion("cs_ctqh not in", values, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhBetween(String value1, String value2) {
            addCriterion("cs_ctqh between", value1, value2, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsCtqhNotBetween(String value1, String value2) {
            addCriterion("cs_ctqh not between", value1, value2, "csCtqh");
            return (Criteria) this;
        }

        public Criteria andCsYzbmIsNull() {
            addCriterion("cs_yzbm is null");
            return (Criteria) this;
        }

        public Criteria andCsYzbmIsNotNull() {
            addCriterion("cs_yzbm is not null");
            return (Criteria) this;
        }

        public Criteria andCsYzbmEqualTo(String value) {
            addCriterion("cs_yzbm =", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmNotEqualTo(String value) {
            addCriterion("cs_yzbm <>", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmGreaterThan(String value) {
            addCriterion("cs_yzbm >", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmGreaterThanOrEqualTo(String value) {
            addCriterion("cs_yzbm >=", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmLessThan(String value) {
            addCriterion("cs_yzbm <", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmLessThanOrEqualTo(String value) {
            addCriterion("cs_yzbm <=", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmLike(String value) {
            addCriterion("cs_yzbm like", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmNotLike(String value) {
            addCriterion("cs_yzbm not like", value, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmIn(List<String> values) {
            addCriterion("cs_yzbm in", values, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmNotIn(List<String> values) {
            addCriterion("cs_yzbm not in", values, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmBetween(String value1, String value2) {
            addCriterion("cs_yzbm between", value1, value2, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsYzbmNotBetween(String value1, String value2) {
            addCriterion("cs_yzbm not between", value1, value2, "csYzbm");
            return (Criteria) this;
        }

        public Criteria andCsSxIsNull() {
            addCriterion("cs_sx is null");
            return (Criteria) this;
        }

        public Criteria andCsSxIsNotNull() {
            addCriterion("cs_sx is not null");
            return (Criteria) this;
        }

        public Criteria andCsSxEqualTo(String value) {
            addCriterion("cs_sx =", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxNotEqualTo(String value) {
            addCriterion("cs_sx <>", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxGreaterThan(String value) {
            addCriterion("cs_sx >", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxGreaterThanOrEqualTo(String value) {
            addCriterion("cs_sx >=", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxLessThan(String value) {
            addCriterion("cs_sx <", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxLessThanOrEqualTo(String value) {
            addCriterion("cs_sx <=", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxLike(String value) {
            addCriterion("cs_sx like", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxNotLike(String value) {
            addCriterion("cs_sx not like", value, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxIn(List<String> values) {
            addCriterion("cs_sx in", values, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxNotIn(List<String> values) {
            addCriterion("cs_sx not in", values, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxBetween(String value1, String value2) {
            addCriterion("cs_sx between", value1, value2, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsSxNotBetween(String value1, String value2) {
            addCriterion("cs_sx not between", value1, value2, "csSx");
            return (Criteria) this;
        }

        public Criteria andCsOrderIsNull() {
            addCriterion("cs_order is null");
            return (Criteria) this;
        }

        public Criteria andCsOrderIsNotNull() {
            addCriterion("cs_order is not null");
            return (Criteria) this;
        }

        public Criteria andCsOrderEqualTo(Integer value) {
            addCriterion("cs_order =", value, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderNotEqualTo(Integer value) {
            addCriterion("cs_order <>", value, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderGreaterThan(Integer value) {
            addCriterion("cs_order >", value, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs_order >=", value, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderLessThan(Integer value) {
            addCriterion("cs_order <", value, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderLessThanOrEqualTo(Integer value) {
            addCriterion("cs_order <=", value, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderIn(List<Integer> values) {
            addCriterion("cs_order in", values, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderNotIn(List<Integer> values) {
            addCriterion("cs_order not in", values, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderBetween(Integer value1, Integer value2) {
            addCriterion("cs_order between", value1, value2, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("cs_order not between", value1, value2, "csOrder");
            return (Criteria) this;
        }

        public Criteria andCsBzIsNull() {
            addCriterion("cs_bz is null");
            return (Criteria) this;
        }

        public Criteria andCsBzIsNotNull() {
            addCriterion("cs_bz is not null");
            return (Criteria) this;
        }

        public Criteria andCsBzEqualTo(String value) {
            addCriterion("cs_bz =", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzNotEqualTo(String value) {
            addCriterion("cs_bz <>", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzGreaterThan(String value) {
            addCriterion("cs_bz >", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzGreaterThanOrEqualTo(String value) {
            addCriterion("cs_bz >=", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzLessThan(String value) {
            addCriterion("cs_bz <", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzLessThanOrEqualTo(String value) {
            addCriterion("cs_bz <=", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzLike(String value) {
            addCriterion("cs_bz like", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzNotLike(String value) {
            addCriterion("cs_bz not like", value, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzIn(List<String> values) {
            addCriterion("cs_bz in", values, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzNotIn(List<String> values) {
            addCriterion("cs_bz not in", values, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzBetween(String value1, String value2) {
            addCriterion("cs_bz between", value1, value2, "csBz");
            return (Criteria) this;
        }

        public Criteria andCsBzNotBetween(String value1, String value2) {
            addCriterion("cs_bz not between", value1, value2, "csBz");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
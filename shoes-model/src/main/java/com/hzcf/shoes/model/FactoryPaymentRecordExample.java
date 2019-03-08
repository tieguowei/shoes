package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FactoryPaymentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FactoryPaymentRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNull() {
            addCriterion("factory_name is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNotNull() {
            addCriterion("factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameEqualTo(String value) {
            addCriterion("factory_name =", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotEqualTo(String value) {
            addCriterion("factory_name <>", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThan(String value) {
            addCriterion("factory_name >", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("factory_name >=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThan(String value) {
            addCriterion("factory_name <", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("factory_name <=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLike(String value) {
            addCriterion("factory_name like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotLike(String value) {
            addCriterion("factory_name not like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIn(List<String> values) {
            addCriterion("factory_name in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotIn(List<String> values) {
            addCriterion("factory_name not in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameBetween(String value1, String value2) {
            addCriterion("factory_name between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotBetween(String value1, String value2) {
            addCriterion("factory_name not between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeIsNull() {
            addCriterion("bill_start_time is null");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeIsNotNull() {
            addCriterion("bill_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("bill_start_time =", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bill_start_time <>", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bill_start_time >", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_start_time >=", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("bill_start_time <", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_start_time <=", value, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bill_start_time in", values, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bill_start_time not in", values, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_start_time between", value1, value2, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_start_time not between", value1, value2, "billStartTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeIsNull() {
            addCriterion("bill_end_time is null");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeIsNotNull() {
            addCriterion("bill_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("bill_end_time =", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bill_end_time <>", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bill_end_time >", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_end_time >=", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("bill_end_time <", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_end_time <=", value, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bill_end_time in", values, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bill_end_time not in", values, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_end_time between", value1, value2, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andBillEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_end_time not between", value1, value2, "billEndTime");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesIsNull() {
            addCriterion("customary_dues is null");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesIsNotNull() {
            addCriterion("customary_dues is not null");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesEqualTo(BigDecimal value) {
            addCriterion("customary_dues =", value, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesNotEqualTo(BigDecimal value) {
            addCriterion("customary_dues <>", value, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesGreaterThan(BigDecimal value) {
            addCriterion("customary_dues >", value, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("customary_dues >=", value, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesLessThan(BigDecimal value) {
            addCriterion("customary_dues <", value, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("customary_dues <=", value, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesIn(List<BigDecimal> values) {
            addCriterion("customary_dues in", values, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesNotIn(List<BigDecimal> values) {
            addCriterion("customary_dues not in", values, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("customary_dues between", value1, value2, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andCustomaryDuesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("customary_dues not between", value1, value2, "customaryDues");
            return (Criteria) this;
        }

        public Criteria andActualPaymentIsNull() {
            addCriterion("actual_payment is null");
            return (Criteria) this;
        }

        public Criteria andActualPaymentIsNotNull() {
            addCriterion("actual_payment is not null");
            return (Criteria) this;
        }

        public Criteria andActualPaymentEqualTo(BigDecimal value) {
            addCriterion("actual_payment =", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentNotEqualTo(BigDecimal value) {
            addCriterion("actual_payment <>", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentGreaterThan(BigDecimal value) {
            addCriterion("actual_payment >", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_payment >=", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentLessThan(BigDecimal value) {
            addCriterion("actual_payment <", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_payment <=", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentIn(List<BigDecimal> values) {
            addCriterion("actual_payment in", values, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentNotIn(List<BigDecimal> values) {
            addCriterion("actual_payment not in", values, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_payment between", value1, value2, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_payment not between", value1, value2, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andBalanceDueIsNull() {
            addCriterion("balance_due is null");
            return (Criteria) this;
        }

        public Criteria andBalanceDueIsNotNull() {
            addCriterion("balance_due is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceDueEqualTo(BigDecimal value) {
            addCriterion("balance_due =", value, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueNotEqualTo(BigDecimal value) {
            addCriterion("balance_due <>", value, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueGreaterThan(BigDecimal value) {
            addCriterion("balance_due >", value, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_due >=", value, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueLessThan(BigDecimal value) {
            addCriterion("balance_due <", value, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_due <=", value, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueIn(List<BigDecimal> values) {
            addCriterion("balance_due in", values, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueNotIn(List<BigDecimal> values) {
            addCriterion("balance_due not in", values, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_due between", value1, value2, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andBalanceDueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_due not between", value1, value2, "balanceDue");
            return (Criteria) this;
        }

        public Criteria andCutPaymentIsNull() {
            addCriterion("cut_payment is null");
            return (Criteria) this;
        }

        public Criteria andCutPaymentIsNotNull() {
            addCriterion("cut_payment is not null");
            return (Criteria) this;
        }

        public Criteria andCutPaymentEqualTo(BigDecimal value) {
            addCriterion("cut_payment =", value, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentNotEqualTo(BigDecimal value) {
            addCriterion("cut_payment <>", value, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentGreaterThan(BigDecimal value) {
            addCriterion("cut_payment >", value, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cut_payment >=", value, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentLessThan(BigDecimal value) {
            addCriterion("cut_payment <", value, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cut_payment <=", value, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentIn(List<BigDecimal> values) {
            addCriterion("cut_payment in", values, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentNotIn(List<BigDecimal> values) {
            addCriterion("cut_payment not in", values, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cut_payment between", value1, value2, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andCutPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cut_payment not between", value1, value2, "cutPayment");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsIsNull() {
            addCriterion("defective_goods is null");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsIsNotNull() {
            addCriterion("defective_goods is not null");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsEqualTo(BigDecimal value) {
            addCriterion("defective_goods =", value, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsNotEqualTo(BigDecimal value) {
            addCriterion("defective_goods <>", value, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsGreaterThan(BigDecimal value) {
            addCriterion("defective_goods >", value, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("defective_goods >=", value, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsLessThan(BigDecimal value) {
            addCriterion("defective_goods <", value, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("defective_goods <=", value, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsIn(List<BigDecimal> values) {
            addCriterion("defective_goods in", values, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsNotIn(List<BigDecimal> values) {
            addCriterion("defective_goods not in", values, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("defective_goods between", value1, value2, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andDefectiveGoodsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("defective_goods not between", value1, value2, "defectiveGoods");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNull() {
            addCriterion("season is null");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNotNull() {
            addCriterion("season is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonEqualTo(String value) {
            addCriterion("season =", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotEqualTo(String value) {
            addCriterion("season <>", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThan(String value) {
            addCriterion("season >", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("season >=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThan(String value) {
            addCriterion("season <", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThanOrEqualTo(String value) {
            addCriterion("season <=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLike(String value) {
            addCriterion("season like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotLike(String value) {
            addCriterion("season not like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonIn(List<String> values) {
            addCriterion("season in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotIn(List<String> values) {
            addCriterion("season not in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonBetween(String value1, String value2) {
            addCriterion("season between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotBetween(String value1, String value2) {
            addCriterion("season not between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("bill_status like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("bill_status not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

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
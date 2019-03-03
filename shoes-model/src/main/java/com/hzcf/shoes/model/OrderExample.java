package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
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

        public Criteria andItemNoIsNull() {
            addCriterion("item_no is null");
            return (Criteria) this;
        }

        public Criteria andItemNoIsNotNull() {
            addCriterion("item_no is not null");
            return (Criteria) this;
        }

        public Criteria andItemNoEqualTo(String value) {
            addCriterion("item_no =", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotEqualTo(String value) {
            addCriterion("item_no <>", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoGreaterThan(String value) {
            addCriterion("item_no >", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoGreaterThanOrEqualTo(String value) {
            addCriterion("item_no >=", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoLessThan(String value) {
            addCriterion("item_no <", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoLessThanOrEqualTo(String value) {
            addCriterion("item_no <=", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoLike(String value) {
            addCriterion("item_no like", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotLike(String value) {
            addCriterion("item_no not like", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoIn(List<String> values) {
            addCriterion("item_no in", values, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotIn(List<String> values) {
            addCriterion("item_no not in", values, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoBetween(String value1, String value2) {
            addCriterion("item_no between", value1, value2, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotBetween(String value1, String value2) {
            addCriterion("item_no not between", value1, value2, "itemNo");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesIsNull() {
            addCriterion("number_packages is null");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesIsNotNull() {
            addCriterion("number_packages is not null");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesEqualTo(Integer value) {
            addCriterion("number_packages =", value, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesNotEqualTo(Integer value) {
            addCriterion("number_packages <>", value, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesGreaterThan(Integer value) {
            addCriterion("number_packages >", value, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_packages >=", value, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesLessThan(Integer value) {
            addCriterion("number_packages <", value, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesLessThanOrEqualTo(Integer value) {
            addCriterion("number_packages <=", value, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesIn(List<Integer> values) {
            addCriterion("number_packages in", values, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesNotIn(List<Integer> values) {
            addCriterion("number_packages not in", values, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesBetween(Integer value1, Integer value2) {
            addCriterion("number_packages between", value1, value2, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andNumberPackagesNotBetween(Integer value1, Integer value2) {
            addCriterion("number_packages not between", value1, value2, "numberPackages");
            return (Criteria) this;
        }

        public Criteria andShoeDualIsNull() {
            addCriterion("shoe_dual is null");
            return (Criteria) this;
        }

        public Criteria andShoeDualIsNotNull() {
            addCriterion("shoe_dual is not null");
            return (Criteria) this;
        }

        public Criteria andShoeDualEqualTo(Integer value) {
            addCriterion("shoe_dual =", value, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualNotEqualTo(Integer value) {
            addCriterion("shoe_dual <>", value, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualGreaterThan(Integer value) {
            addCriterion("shoe_dual >", value, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoe_dual >=", value, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualLessThan(Integer value) {
            addCriterion("shoe_dual <", value, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualLessThanOrEqualTo(Integer value) {
            addCriterion("shoe_dual <=", value, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualIn(List<Integer> values) {
            addCriterion("shoe_dual in", values, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualNotIn(List<Integer> values) {
            addCriterion("shoe_dual not in", values, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualBetween(Integer value1, Integer value2) {
            addCriterion("shoe_dual between", value1, value2, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andShoeDualNotBetween(Integer value1, Integer value2) {
            addCriterion("shoe_dual not between", value1, value2, "shoeDual");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadIsNull() {
            addCriterion("price_spread is null");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadIsNotNull() {
            addCriterion("price_spread is not null");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadEqualTo(BigDecimal value) {
            addCriterion("price_spread =", value, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadNotEqualTo(BigDecimal value) {
            addCriterion("price_spread <>", value, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadGreaterThan(BigDecimal value) {
            addCriterion("price_spread >", value, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_spread >=", value, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadLessThan(BigDecimal value) {
            addCriterion("price_spread <", value, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_spread <=", value, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadIn(List<BigDecimal> values) {
            addCriterion("price_spread in", values, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadNotIn(List<BigDecimal> values) {
            addCriterion("price_spread not in", values, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_spread between", value1, value2, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andPriceSpreadNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_spread not between", value1, value2, "priceSpread");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberIsNull() {
            addCriterion("difference_number is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberIsNotNull() {
            addCriterion("difference_number is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberEqualTo(Integer value) {
            addCriterion("difference_number =", value, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberNotEqualTo(Integer value) {
            addCriterion("difference_number <>", value, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberGreaterThan(Integer value) {
            addCriterion("difference_number >", value, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("difference_number >=", value, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberLessThan(Integer value) {
            addCriterion("difference_number <", value, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("difference_number <=", value, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberIn(List<Integer> values) {
            addCriterion("difference_number in", values, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberNotIn(List<Integer> values) {
            addCriterion("difference_number not in", values, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberBetween(Integer value1, Integer value2) {
            addCriterion("difference_number between", value1, value2, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andDifferenceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("difference_number not between", value1, value2, "differenceNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberIsNull() {
            addCriterion("returns_number is null");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberIsNotNull() {
            addCriterion("returns_number is not null");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberEqualTo(Integer value) {
            addCriterion("returns_number =", value, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberNotEqualTo(Integer value) {
            addCriterion("returns_number <>", value, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberGreaterThan(Integer value) {
            addCriterion("returns_number >", value, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("returns_number >=", value, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberLessThan(Integer value) {
            addCriterion("returns_number <", value, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("returns_number <=", value, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberIn(List<Integer> values) {
            addCriterion("returns_number in", values, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberNotIn(List<Integer> values) {
            addCriterion("returns_number not in", values, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberBetween(Integer value1, Integer value2) {
            addCriterion("returns_number between", value1, value2, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andReturnsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("returns_number not between", value1, value2, "returnsNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsIsNull() {
            addCriterion("customer_is_defective_goods is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsIsNotNull() {
            addCriterion("customer_is_defective_goods is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsEqualTo(String value) {
            addCriterion("customer_is_defective_goods =", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsNotEqualTo(String value) {
            addCriterion("customer_is_defective_goods <>", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsGreaterThan(String value) {
            addCriterion("customer_is_defective_goods >", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("customer_is_defective_goods >=", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsLessThan(String value) {
            addCriterion("customer_is_defective_goods <", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsLessThanOrEqualTo(String value) {
            addCriterion("customer_is_defective_goods <=", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsLike(String value) {
            addCriterion("customer_is_defective_goods like", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsNotLike(String value) {
            addCriterion("customer_is_defective_goods not like", value, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsIn(List<String> values) {
            addCriterion("customer_is_defective_goods in", values, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsNotIn(List<String> values) {
            addCriterion("customer_is_defective_goods not in", values, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsBetween(String value1, String value2) {
            addCriterion("customer_is_defective_goods between", value1, value2, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andCustomerIsDefectiveGoodsNotBetween(String value1, String value2) {
            addCriterion("customer_is_defective_goods not between", value1, value2, "customerIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsIsNull() {
            addCriterion("factory_is_defective_goods is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsIsNotNull() {
            addCriterion("factory_is_defective_goods is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsEqualTo(String value) {
            addCriterion("factory_is_defective_goods =", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsNotEqualTo(String value) {
            addCriterion("factory_is_defective_goods <>", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsGreaterThan(String value) {
            addCriterion("factory_is_defective_goods >", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("factory_is_defective_goods >=", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsLessThan(String value) {
            addCriterion("factory_is_defective_goods <", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsLessThanOrEqualTo(String value) {
            addCriterion("factory_is_defective_goods <=", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsLike(String value) {
            addCriterion("factory_is_defective_goods like", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsNotLike(String value) {
            addCriterion("factory_is_defective_goods not like", value, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsIn(List<String> values) {
            addCriterion("factory_is_defective_goods in", values, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsNotIn(List<String> values) {
            addCriterion("factory_is_defective_goods not in", values, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsBetween(String value1, String value2) {
            addCriterion("factory_is_defective_goods between", value1, value2, "factoryIsDefectiveGoods");
            return (Criteria) this;
        }

        public Criteria andFactoryIsDefectiveGoodsNotBetween(String value1, String value2) {
            addCriterion("factory_is_defective_goods not between", value1, value2, "factoryIsDefectiveGoods");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
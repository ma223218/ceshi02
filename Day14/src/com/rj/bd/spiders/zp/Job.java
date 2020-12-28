package com.rj.bd.spiders.zp;
/**
 * @desc  job类-
 * @author DELL
 * @time   2020-10-08
 */
public class Job {

public String jobName;//岗位名称
public String date;//发布日期
public String money;//薪水
public String cityArea;//地域
public String record;//工作经验
public String nacture;//学历
public String company;//公司名称
public String getJobName() {
	return jobName;
}
public void setJobName(String jobName) {
	this.jobName = jobName;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getMoney() {
	return money;
}
public void setMoney(String money) {
	this.money = money;
}
public String getCityArea() {
	return cityArea;
}
public void setCityArea(String cityArea) {
	this.cityArea = cityArea;
}
public String getRecord() {
	return record;
}
public void setRecord(String record) {
	this.record = record;
}
public String getNacture() {
	return nacture;
}
public void setNacture(String nacture) {
	this.nacture = nacture;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
@Override
public String toString() {
	return "Job [jobName=" + jobName + ", date=" + date + ", money=" + money + ", cityArea=" + cityArea + ", record="
			+ record + ", nacture=" + nacture + ", company=" + company + "]";
}
	
	
	
}

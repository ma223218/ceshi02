package com.rj.bd.spiders.zp;
/**
 * @desc  job��-
 * @author DELL
 * @time   2020-10-08
 */
public class Job {

public String jobName;//��λ����
public String date;//��������
public String money;//нˮ
public String cityArea;//����
public String record;//��������
public String nacture;//ѧ��
public String company;//��˾����
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

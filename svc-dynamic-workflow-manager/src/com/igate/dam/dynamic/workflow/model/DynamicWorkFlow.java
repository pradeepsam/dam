package com.igate.dam.dynamic.workflow.model;

import java.io.Serializable;

public class DynamicWorkFlow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5924738589903906640L;
	private String supp_id;
	private String supp_name;
	private String curr_Step;
	private String next_Step;
	private String process_id;
	public String getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(String supp_id) {
		this.supp_id = supp_id;
	}
	public String getSupp_name() {
		return supp_name;
	}
	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CurrStep" + curr_Step + "Next" + next_Step + "Proc" + process_id;
	}
	public String getCurr_Step() {
		return curr_Step;
	}
	public void setCurr_Step(String curr_Step) {
		this.curr_Step = curr_Step;
	}
	public String getNext_Step() {
		return next_Step;
	}
	public void setNext_Step(String next_Step) {
		this.next_Step = next_Step;
	}
	public String getProcess_id() {
		return process_id;
	}
	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}
}

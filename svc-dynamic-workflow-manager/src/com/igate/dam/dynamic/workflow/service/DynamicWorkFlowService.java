package com.igate.dam.dynamic.workflow.service;

import org.drools.runtime.StatefulKnowledgeSession;

import com.igate.dam.dynamic.workflow.common.exception.DAMException;

public interface DynamicWorkFlowService {
public Long triggerDynamicWorkFlow(String suppId,String suppName)throws DAMException;
public void setNextWorkFlowStep(StatefulKnowledgeSession statefulSession)throws DAMException; 
}

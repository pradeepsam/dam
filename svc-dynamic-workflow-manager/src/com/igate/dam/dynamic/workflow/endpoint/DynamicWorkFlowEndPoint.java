package com.igate.dam.dynamic.workflow.endpoint;

import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.igate.dam.dynamic.workflow.model.TriggerDynamicWorkFlowRequest;
import com.igate.dam.dynamic.workflow.model.TriggerDynamicWorkFlowResponse;
import com.igate.dam.dynamic.workflow.service.DynamicWorkFlowService;

public class DynamicWorkFlowEndPoint extends AbstractMarshallingPayloadEndpoint {

	private DynamicWorkFlowService dynamicWorkFlowService;
	public DynamicWorkFlowService getDynamicWorkFlowService() {
		return dynamicWorkFlowService;
	}
	public void setDynamicWorkFlowService(
			DynamicWorkFlowService dynamicWorkFlowService) {
		this.dynamicWorkFlowService = dynamicWorkFlowService;
	}
	
	
	
	@Override
	protected Object invokeInternal(Object request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Coming inside the EndPoint--------------->");
		TriggerDynamicWorkFlowRequest triggerDynamicWorkFlowRequest = (TriggerDynamicWorkFlowRequest)request;
		String suppId = triggerDynamicWorkFlowRequest.getSupplierDetails().getSuppid();
		String suppName = triggerDynamicWorkFlowRequest.getSupplierDetails().getSuppname();
		System.out.println("inputs\t"+suppId+suppName);
		TriggerDynamicWorkFlowResponse triggerDynamicWorkFlowResponse = new TriggerDynamicWorkFlowResponse();
		Long procInsId = dynamicWorkFlowService.triggerDynamicWorkFlow(suppId,suppName);
		triggerDynamicWorkFlowResponse.setInvocationsuccess(true);
		triggerDynamicWorkFlowResponse.setProcessinstanceid(procInsId.intValue());
		return triggerDynamicWorkFlowResponse;
	}

}

package com.vito16.mvc1.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.mvc1.model.Leave;

@Service
@Transactional
public class LeaveWorkflowService {

	private static Logger logger = LoggerFactory
			.getLogger(LeaveWorkflowService.class);

	@Resource
	private RuntimeService runtimeService;

	@Resource
	protected TaskService taskService;

	@Resource
	protected HistoryService historyService;

	@Resource
	protected RepositoryService repositoryService;

	@Resource
	protected LeaveService leaveService;

	private static final String processDefinitionKey = "leave";

	public void startProcess(Leave leave, Map<String, Object> variables) {
		leaveService.save(leave);
		String bizKey = leave.getLeaveID().toString();
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				processDefinitionKey, bizKey, variables);
		logger.info("请假流程启动成功...." + ToStringBuilder.reflectionToString(pi));
	}

	@Transactional(readOnly = true)
	public void deployProcess() {
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/leave.bpmn").deploy();
		logger.info("leave 流程 部署成功");
	}

	public List<Task> listAllTasks(Integer userId) {
		return taskService.createTaskQuery()
				.taskCandidateUser(userId.toString()).list();
	}
}

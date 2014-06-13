/**
 * 
 */
package com.vito16.mvc1.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.vito16.mvc1.model.User;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.mvc1.dao.LeaveDao;
import com.vito16.mvc1.model.Leave;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Service
@Transactional(readOnly=true)
public class LeaveService{
	
	@Resource
	private LeaveDao leaveDao;
	
	@Resource
	private ProcessEngine processEngine;
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	@Resource
	private RepositoryService repositoryService;

	@Transactional(readOnly=false)
	public void save(Leave leave) {
		leaveDao.save(leave);
	}

	public Leave findOne(Integer id) {
		return leaveDao.findOne(id);
	}
	
	public void archive(String bizKey){
		System.out.println(bizKey);
	}
	
	public List<Leave> listAllTasks(int i) {
		List<Leave> leaveList = new ArrayList<Leave>();
		List<Task> todoTask = taskService.createTaskQuery().list();
		
		// 根据流程的业务ID查询实体并关联
	    for (Task task : todoTask) {
	        String processInstanceId = task.getProcessInstanceId();
	        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
	        String businessKey = processInstance.getBusinessKey();
	        Leave leave = findOne(Integer.valueOf(businessKey));
	        leave.setTask(task);
	        leave.setProcessInstance(processInstance);
	        leave.setProcessDefinition(repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId()).singleResult());
	        leaveList.add(leave);
	    }
	    
		return leaveList;
	}

    /**
     * 查询与用户相关的请假申请记录
     * @param id 用户ID
     * @return
     */
    public List<Leave> listAllByUserID(Integer id) {
        List<Leave> leaveList = new ArrayList<Leave>();
        User user = new User();
        user.setId(id);
        leaveList = leaveDao.findByLeaveUser(user);
        return leaveList;
    }
}

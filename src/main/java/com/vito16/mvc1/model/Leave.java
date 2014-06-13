package com.vito16.mvc1.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.format.annotation.DateTimeFormat;

import com.vito16.mvc1.util.ConvertUtil;

/**
 * 请假
 */
@Entity
@Table(name = "T_LEAVE")
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer leaveID;
	private Date createTime;
	private String leaveType;
	private Date startDate;
	private Date endDate;
	private String reason;
    private Integer status;
    private User leaveUser;
	//VO
	private Task task;
	private ProcessInstance processInstance;
	private ProcessDefinition processDefinition;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(Integer leaveID) {
		this.leaveID = leaveID;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Transient
	public String getStartDateStr(){
		String timeStr  = "";
		try {
			timeStr = ConvertUtil.toYMDStr(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeStr;
	}
	@Transient
	public String getEndDateStr(){
		String timeStr  = "";
		try {
			timeStr = ConvertUtil.toYMDStr(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeStr;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Transient
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	@Transient
	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}
	@Transient
	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn
    public User getLeaveUser() {
        return leaveUser;
    }

    public void setLeaveUser(User leaveUser) {
        this.leaveUser = leaveUser;
    }
}

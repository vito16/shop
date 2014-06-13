/**
 * 
 */
package com.vito16.mvc1.controller;

import com.vito16.mvc1.model.Leave;
import com.vito16.mvc1.model.User;
import com.vito16.mvc1.service.LeaveService;
import com.vito16.mvc1.service.LeaveWorkflowService;
import com.vito16.mvc1.util.UserUtil;
import com.vito16.util.ObjectUtils;
import org.activiti.engine.ActivitiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 * 
 */
@Controller
@RequestMapping(value = "/leave")
public class LeaveController {

	private static final Logger logger = LoggerFactory.getLogger(LeaveController.class);

	@Resource
	LeaveService leaveService;

	@Resource
	LeaveWorkflowService workflowService;

	/**
	 * 请假申请
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.GET)
	public String newForm(Model model,HttpSession session) {
        //登陆处理
        User user = UserUtil.getUserFromSession(session);
        if(user==null){
            return "redirect:/user/login?error=true";
        }
		model.addAttribute("leave", new Leave());
		return "/leave/leaveApply";
	}


    /**
     * 个人请假列表获取
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/myList", method = RequestMethod.GET)
    public ModelAndView myList(HttpSession session) {
        ModelAndView mav = new ModelAndView("/leave/taskList");
        //登陆验证
        User user = UserUtil.getUserFromSession(session);
        if(user==null){
            return new ModelAndView("redirect:/user/login?error=true");
        }
        List<Leave> leaveList = leaveService.listAllByUserID(user.getId());
        mav.addObject("leaveList", leaveList);
        return mav;
    }

	/**
	 * 任务列表获取
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public ModelAndView todoList(HttpSession session) {
		ModelAndView mav = new ModelAndView("/leave/taskList");
		//登陆处理
        User user = UserUtil.getUserFromSession(session);
        if(user==null){
            return new ModelAndView("redirect:/user/login?error=true");
        }
		List<Leave> leaveList = leaveService.listAllTasks(user.getId());
		mav.addObject("leaveList", leaveList);
		return mav;
	}


    /**
     * 当前登录人审批历史记录
     * @param session
     * @return
     */
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView historyList(HttpSession session) {
        ModelAndView mav = new ModelAndView("/leave/taskList");
        //登陆处理
        User user = UserUtil.getUserFromSession(session);
        if(user==null){
            return new ModelAndView("redirect:/user/login?error=true");
        }
        List<Leave> leaveList = leaveService.listAllTasks(user.getId());
        mav.addObject("leaveList", leaveList);
        return mav;
    }

	@RequestMapping(value = "/audit/{id}/{allow}", method = RequestMethod.GET)
	public ModelAndView audit(@PathVariable("id") Integer leaveID,
			@PathVariable("allow") Boolean allow) {
        logger.info("搞定" + leaveID + " == " + allow);
		return null;
	}

	/**
	 * 流程部署
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deploy", method = RequestMethod.GET)
	public String deployProcess(RedirectAttributes redirectAttributes) {
		workflowService.deployProcess();
		redirectAttributes.addFlashAttribute("deploy", "流程部署成功");
		return "redirect:/leave/apply";
	}

	/**
	 * 流程启动
	 * 
	 * @param leave
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/startProcess", method = RequestMethod.POST)
	public String startProcess(Leave leave,
			RedirectAttributes redirectAttributes,HttpSession session) {
		leave.setCreateTime(new Date());
        leave.setLeaveUser(UserUtil.getUserFromSession(session));
		logger.info("时间:" + leave.getStartDate() + "  " + leave.getEndDate());
		try {
			Map<String, Object> variables = new HashMap<String, Object>();
			workflowService.startProcess(leave, variables);
			redirectAttributes.addFlashAttribute("message", "流程启动成功");
		} catch (ActivitiException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMessage",
					"流程启动失败,请联系管理员.");
		}
		return "redirect:/leave/apply";
	}

}

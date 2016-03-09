/**
 * 
 */
package com.vito16.shop.service;

import java.io.Serializable;
import java.util.List;

import com.vito16.shop.common.Page;
import com.vito16.shop.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
public abstract class BaseService implements
		IBaseService {

	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	protected <T> T doIt(Page<News> page, T resultClass, ProcessInvoker processInvoker) {
		T result = initResult();
		processInvoker.process();
		return result;
	}

	private <T> T initResult() {
		return null;
	}
}

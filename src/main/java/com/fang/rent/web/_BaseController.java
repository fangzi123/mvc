package com.fang.rent.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;

/**
 * @author
 * @version 1.0
 * @Description 控制器基类(SBS权限管理部分迁移使用)
 * @date 2012-11-15
 */
public abstract class _BaseController extends MultiActionController {

    protected transient Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 候选日期模式
     */
    private String[] candidateDatePatterns;

    /**
     * @return
     * @Description 创建ModelAndView实例
     * @author
     */
    protected ModelAndView createMAV() {
        return new ModelAndView();
    }

    /**
     * @param viewName
     * @return
     * @Description 创建带有试图名称的ModelAndView实例
     * @author
     */
    protected ModelAndView createMAV(String viewName) {
        return new ModelAndView(viewName);
    }


    /**
     * @param request
     * @param clazz   绑定类
     * @return
     * @throws Exception
     * @Description 通过请求参数绑定Model
     * @author
     */
    protected <T> T bindModel(HttpServletRequest request, Class<T> clazz)
            throws Exception {
        T object = (T) newCommandObject(clazz);
        bind(request, object);
        return object;
    }




    /**
     * @param request
     * @param name    参数名称
     * @return
     * @Description 从请求中获取String类型参数
     * @author
     */
    protected String findStringParameterValue(HttpServletRequest request,
                                              String name) {
        return WebUtils.findParameterValue(request, name);
    }



    protected Locale getLocal(HttpServletRequest request) {
        return RequestContextUtils.getLocale(request);
    }

    public void setCandidateDatePatterns(String[] candidateDatePatterns) {
        this.candidateDatePatterns = candidateDatePatterns;
    }
}

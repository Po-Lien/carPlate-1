package idv.cpl.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import idv.cpl.springboot.dto.ReturnEnum;
import idv.cpl.springboot.dto.ReturnMsg;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final boolean isDebug = log.isDebugEnabled();

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMessage", "系統維護中...");
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView notHandlerErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        String requestURI = req.getRequestURI();
        if (StringUtils.isNotBlank(requestURI)) {
            if (isDebug) {
                log.info("ExceptionHandler NoHandlerFoundException for: " + requestURI);
                log.info("forward to page: /");
            }
            ModelAndView mav = new ModelAndView();
            mav.setStatus(HttpStatus.OK);
            mav.setViewName("forward:/");
            return mav;
        }

        if (isDebug) {
            log.info("ExceptionHandler NoHandlerFoundException for: " + requestURI);
            log.info("Return not found for REST Response.");
        }

        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("returnCode", Integer.valueOf(-1));
        mav.addObject("msg", "not found");
        mav.addObject("data", null);
        return mav;
    }

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ReturnMsg apiErrorHandler(HttpServletRequest req, ApiException e) throws Exception {
        return ReturnMsg.error(e.getReturnEnum(), e.getOtherMessage());
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ReturnMsg apiErrorHandler(MissingServletRequestParameterException ex) throws Exception {
        return ReturnMsg.error(ReturnEnum.ERROR, ex.getParameterName() + " parameter is missing");
    }
}

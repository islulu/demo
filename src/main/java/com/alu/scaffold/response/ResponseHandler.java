package com.alu.scaffold.response;

import com.alu.scaffold.exception.BusinessLogicException;
import com.alu.scaffold.exception.ErrorCodeEnum;
import com.alu.scaffold.web.CustomHttpHeaderUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 这个类用来handle整个系统的异常或正常返回对象，包装成PortalResponse对象返回给调用方
 */
@Slf4j
@ControllerAdvice(basePackages = {"com.alu.scaffold.controller"})
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Autowired
    ObjectMapper objectMapper;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WebResponseEntity customErrorHandler(HttpServletRequest request, Exception ex) throws Exception{
        ErrorCodeEnum errorCodeEnum = null;
        Object extra = null;
        if (ex instanceof BusinessLogicException) {
            BusinessLogicException portalException = (BusinessLogicException) ex;
            errorCodeEnum = portalException.getErrorCodeEnum();
            extra = portalException.getExtra();
        } else {
            log.error("IP={}, URL={}, USER_ID={}", CustomHttpHeaderUtil.getRemoteIp(request), request.getRequestURI(), StringUtils.defaultString(CustomHttpHeaderUtil.getUserId(request)));
            log.error(ex.getMessage(), ex);
            ex.printStackTrace();

            if (ex instanceof SQLException || ex instanceof DataAccessException) {
                errorCodeEnum = ErrorCodeEnum.DB_ERROR;
            } else if (ex instanceof NullPointerException) {
                errorCodeEnum = ErrorCodeEnum.NULL_POINT_ERROR;
            } else if (ex instanceof IllegalStateException && StringUtils.endsWith(ex.getMessage(),
                    "Consider declaring it as object wrapper for the corresponding primitive type.")) {
                errorCodeEnum = ErrorCodeEnum.MISSING_REQUEST_PARAMETERS;
            } else {
                errorCodeEnum = ErrorCodeEnum.OTHER_ERROR;
            }
        }

        WebResponseEntity responseEntity = new WebResponseEntity(errorCodeEnum, extra);
        return responseEntity;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 将接口返回的对象统一包装成WebResponseEntity类的实例
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof String){
            try {
                response.getHeaders().setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE));
                return objectMapper.writeValueAsString(new WebResponseEntity(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        if(body instanceof WebResponseEntity){
            return body;
        }
        return new WebResponseEntity(body);
    }
}

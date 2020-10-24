package com.bgy.gateway.validator;

import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.exception.BusinessException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    public void validate(Object bean) throws BusinessException {
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);

        if(constraintViolationSet.size() > 0){
            StringBuilder errMsgBuilder = new StringBuilder();
            constraintViolationSet.forEach(constraintViolation -> {
                errMsgBuilder.append(constraintViolation.getMessage());
            });

            throw new BusinessException(ResultEnum.PARAM_ERROR, errMsgBuilder.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}

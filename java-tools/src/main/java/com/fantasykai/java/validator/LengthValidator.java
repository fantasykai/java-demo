package com.fantasykai.java.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 长度校验 <br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/01/17 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class LengthValidator extends ValidatorHandler<String> implements Validator<String> {

    private int min;

    private int max;

    private String fieldName;

    public LengthValidator(int min, int max, String fieldName) {
        this.min = min;
        this.max = max;
        this.fieldName = fieldName;
    }

    @Override
    public boolean validate(ValidatorContext context, String s) {
        if (null == s || s.length() > max || s.length() < min) {
            context.addError(ValidationError.create(String.format("%s长度必须介于%s~s%s之间", fieldName, min, max))
                    .setErrorCode(-1).setField(fieldName).setInvalidValue(s));
            return false;
        }
        return true;
    }

}

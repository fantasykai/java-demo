package com.fantasykai.java.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/01/17 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class SizeValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    private int min;
    private int max;

    private String fieldName;

    public SizeValidator(int min, int max, String fieldName) {
        this.min = min;
        this.max = max;
        this.fieldName = fieldName;
    }

    @Override
    public boolean validate(ValidatorContext context, Integer integer) {

        if (null == integer || integer.intValue() > max || integer.intValue() < min) {
            context.addError(ValidationError.create(String.format("%s必须大于%s, 小于%s", fieldName, max, min))
                    .setErrorCode(-1).setField(fieldName).setInvalidValue(integer));
            return false;
        }

        return true;
    }

}

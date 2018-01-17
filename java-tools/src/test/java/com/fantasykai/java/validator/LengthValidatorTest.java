package com.fantasykai.java.validator;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/01/17 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class LengthValidatorTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LengthValidatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LengthValidatorTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testLengthValidator() {

        ComplexResult result = FluentValidator.checkAll().on("中国人民很行", new LengthValidator(1, 200, "标题")).doValidate()
                .result(ResultCollectors.toComplex());

        assertTrue(result.isSuccess());
    }

}

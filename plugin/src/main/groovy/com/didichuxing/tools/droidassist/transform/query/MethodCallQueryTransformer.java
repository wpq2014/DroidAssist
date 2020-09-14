package com.didichuxing.tools.droidassist.transform.query;

import com.didichuxing.tools.droidassist.util.Logger;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.MethodCall;

/**
 * Transform that inserts custom code at the pointcut where method is called.
 */
public class MethodCallQueryTransformer extends QueryTransformer {

    @Override
    public String getName() {
        return "MethodCallInsertTransformer";
    }

    @Override
    protected String getTransformType() {
        return TRANSFORM_EXPR;
    }

    @Override
    protected String getExecuteType() {
        return METHOD_CALL;
    }

    @Override
    protected boolean execute(
            CtClass inputClass,
            String inputClassName,
            MethodCall methodCall)
            throws CannotCompileException, NotFoundException {
        if (methodCall.isSuper()) {
            return false;
        }

        String insnClassName = methodCall.getClassName();
        String insnName = methodCall.getMethodName();
        String insnSignature = methodCall.getSignature();

        CtClass insnClass = tryGetClass(insnClassName, inputClassName);
        if (insnClass == null) {
            return false;
        }
        if (!isMatchSourceMethod(insnClass, insnName, insnSignature, false)) {
            return false;
        }

        String target = getTarget();
        int line = methodCall.getLineNumber();

        Logger.warning(target + insnClassName + "." + insnName
                + "\n\t\t\t\t\t代码行：" + inputClassName + ".java" + ":" + line);

        return true;
    }
}

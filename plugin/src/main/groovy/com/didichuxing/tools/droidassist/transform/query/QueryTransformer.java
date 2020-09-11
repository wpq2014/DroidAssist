package com.didichuxing.tools.droidassist.transform.query;

import com.didichuxing.tools.droidassist.transform.ExprExecTransformer;

/**
 * An abstract transform that replaces the specified code with new code.
 *
 * <p> See{@link MethodCallQueryTransformer}
 */
public abstract class QueryTransformer extends ExprExecTransformer {
    @Override
    public String getName() {
        return "QueryTransformer";
    }

    @Override
    public String getCategoryName() {
        return "Query";
    }
}

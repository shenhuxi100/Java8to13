package com.study;

import java.util.function.Function;

class FunctionObj implements Function {

    @Override
    public Object apply(Object o) {
        return o + ", hello yongzhi";
    }
}

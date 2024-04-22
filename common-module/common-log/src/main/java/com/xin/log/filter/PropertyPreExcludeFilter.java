package com.xin.log.filter;

import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/20 下午 3:39
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class PropertyPreExcludeFilter extends SimplePropertyPreFilter {
    public PropertyPreExcludeFilter() {
    }

    public PropertyPreExcludeFilter addExcludes(String... filters) {
        for (int i = 0; i < filters.length; i++) {
            this.getExcludes().add(filters[i]);
        }
        return this;
    }
}

package com.fheebiy.common.web;



import com.fheebiy.page.PageContext;

import javax.servlet.http.HttpServletRequest;

public class PageContextUtil {

    public static void initPageContext(HttpServletRequest request) {
        int pageNo = HttpParameterUtil.getParameterInt(request, "page");
        int pageSize = HttpParameterUtil.getParameterInt(request, "rows");
        initPageContext(pageNo, pageSize);
    }

    public static void initPageContext(int pageNo, int pageSize) {
        PageContext pageContext = PageContext.getContext();
        pageNo = pageNo > 0 ? pageNo : 1;
        pageSize = pageSize > 0 ? pageSize : 10;

        pageContext.setCurrentPage(pageNo);
        pageContext.setPageSize(pageSize);
        pageContext.setPagination(true);
    }

    public static void removePageContext() {
        PageContext.removeContext();
    }

}

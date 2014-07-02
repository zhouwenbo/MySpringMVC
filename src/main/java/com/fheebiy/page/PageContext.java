package com.fheebiy.page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class PageContext extends Page {

    private static final Log logger = LogFactory.getLog(PageContext.class);
    private static ThreadLocal<PageContext> context = new ThreadLocal<PageContext>();

    public PageContext() {
        super();
    }

    public static PageContext getContext() {
        PageContext ci = context.get();
        if (ci == null) {
            ci = new PageContext();
            context.set(ci);
        }
        return ci;
    }

    public static void removeContext() {
        context.remove();
    }

    protected void initialize() {
    }

}

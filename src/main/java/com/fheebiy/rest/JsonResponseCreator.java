package com.fheebiy.rest;



import com.fheebiy.common.JsonPageResponse;
import com.fheebiy.common.web.PageContextUtil;
import com.fheebiy.page.PageContext;

import java.util.ArrayList;

public class JsonResponseCreator {

    public static Object createJsonResponse() {
        return createJsonResponse(null);
    }

    public static Object createJsonResponse(Object body) {
        return createJsonResponse(JsonResponseHeader.STATUS_OK, body);
    }

    public static Object createJsonResponse(int status, Object body) {
        PageContextUtil.removePageContext();
        return new JsonResponse(status, body);
    }

    public static Object createInvalidJsonResponse() {
        return createInvalidJsonResponse(JsonResponseHeader.STATUS_ERROR);
    }

    public static Object createInvalidJsonResponse(int status) {
        return createJsonResponse(status, null);
    }

    public static Object createJsonPage(Object list) {
        if (list != null) {
            int totalRows = PageContext.getContext().getTotalRows();
            PageContextUtil.removePageContext();
            return new JsonPageResponse(totalRows, list);
        }
        PageContextUtil.removePageContext();
        return new JsonPageResponse(0, new ArrayList());
    }

    public static Object createJsonPage(Object list, long total) {
        if (list != null) {
            return new JsonPageResponse(total, list);
        } else {
            return new JsonPageResponse(0, new ArrayList());
        }
    }

    public static Object createJsonSuccessPage(Object list, int total) {
        JsonPageResponse JsonPageResponse = new JsonPageResponse(0, new ArrayList());
        if (list != null) {
            JsonPageResponse = new JsonPageResponse(total, list);
        }
        return new JsonResponse(JsonResponseHeader.STATUS_OK, JsonPageResponse);
    }

    public static Object createJsonSuccessPage(Object list) {
        JsonPageResponse JsonPageResponse = new JsonPageResponse(0, new ArrayList());
        if (list != null) {
            int totalRows = PageContext.getContext().getTotalRows();
            JsonPageResponse = new JsonPageResponse(totalRows, list);
        }
        PageContextUtil.removePageContext();
        return new JsonResponse(JsonResponseHeader.STATUS_OK, JsonPageResponse);
    }
}

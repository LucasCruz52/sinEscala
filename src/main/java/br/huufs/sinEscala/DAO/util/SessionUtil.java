package br.huufs.sinEscala.DAO.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil implements Serializable{
	public static HttpSession getSession() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) ctx.getExternalContext().getSession(
                false);
        return sessao;
    }

    public static void setParam(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getParam(String key) {
        return getSession().getAttribute(key);
    }

    public static void remove(String key) {
        getSession().removeAttribute(key);
    }

    public static void invalidate() {
        getSession().invalidate();
    }

}

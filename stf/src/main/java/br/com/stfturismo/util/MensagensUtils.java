package br.com.stfturismo.util;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MensagensUtils {

	
	public static String getExternalMensagem(String key) {
		String messageBundleName = "messages";
		Locale locale = new Locale("pt_BR");
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
		return bundle.getString(key);
	}
	
	public static String getMensagem(String key) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
		return bundle.getString(key);
	}
	
	public static String getMensagemParametros(String key, Object... params) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
		return MessageFormat.format(bundle.getString(key), params);
	}
	
	public static void mensagemErro(String mensagem) {
		addMensagem(mensagem, FacesMessage.SEVERITY_ERROR);
	}
	
	public static void mensagemInfo(String mensagem) {
		addMensagem(mensagem, FacesMessage.SEVERITY_INFO);
	}
	
	public static void mensagemFatal(String mensagem) {
		addMensagem(mensagem, FacesMessage.SEVERITY_FATAL);
	}
	
	public static void mensagemWarn(String mensagem) {
		addMensagem(mensagem, FacesMessage.SEVERITY_WARN);
	}

	private static void addMensagem(String mensagem, Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, mensagem, null));
	}

	public static void limparMensagens() {
		FacesContext.getCurrentInstance().getMessageList().clear();
	}

	@Produces
	@Named
	public Properties getMessages() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);

		Enumeration<String> enumeration = bundle.getKeys();

		Properties result = new Properties();

		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			result.put(key, bundle.getString(key));
		}

		return result;
	}
	
	public boolean isExisteMensagem() {
		if (FacesContext.getCurrentInstance().getMessages() != null) {
			return FacesContext.getCurrentInstance().getMessages().hasNext();
		} else {
			return false;
		}
	}
	
}

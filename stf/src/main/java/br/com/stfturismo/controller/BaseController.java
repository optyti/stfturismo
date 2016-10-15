package br.com.stfturismo.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.ToggleEvent;

import br.com.stfturismo.util.MensagensUtils;

@Model
public class BaseController {

	@Inject
	private FacesContext facesContext;

	private static final Logger log = Logger.getLogger(BaseController.class.getSimpleName());

	private String fluxo;

	// Methods

	public String index() {
		return "/pages/index.xhtml";
	}

	// public boolean verificaExistenciaItensAlterados(SgiEntidadeBase atual,
	// SgiEntidadeBase apos)
	// throws CompareException {
	//
	// List<Difference> diffs = null;
	// apos.setId(atual.getId());
	// diffs = ComparisonUtil.comparaPojo(atual, apos);
	// if (CollectionUtils.isNotEmpty(diffs)) {
	// return true;
	// }
	// return false;
	// }

	// protected void addMsgException(ValidatorException validatorException) {
	// for (String msg : validatorException.getMessages()) {
	// addErroMsg(msg);
	// }
	// }

	protected void addInfoMsg(String key) {
		MensagensUtils.mensagemInfo(MensagensUtils.getMensagem(key));
	}

	protected void addErroMsg(String key) {
		MensagensUtils.mensagemErro(MensagensUtils.getMensagem(key));
	}

	protected void addAlertaMsg(String key) {
		MensagensUtils.mensagemWarn(MensagensUtils.getMensagem(key));
	}

	protected String getRootErrorMessage(Exception e) {
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			return errorMessage;
		}
		Throwable t = e;
		while (t != null) {
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		return errorMessage;
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled",
				"Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// Getters And Setters

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public String getFluxo() {
		return fluxo;
	}

	public void setFluxo(String fluxo) {
		this.fluxo = fluxo;
	}

}

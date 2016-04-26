package uniandes.fabricasw.ecotouring.core;

import java.io.Serializable;
import java.util.List;

public class ApiResponse<T> implements Serializable {

	private static final long serialVersionUID = -7784167802958683110L;

	private List<T> data;
	private boolean success;
	private List<String> messages;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<T> getData() {
		return this.data;
	}

	public List<String> getMessages() {
		return this.messages;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getCount() {
		return data.size();
	}

}
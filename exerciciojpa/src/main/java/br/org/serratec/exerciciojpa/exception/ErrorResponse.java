package br.org.serratec.exerciciojpa.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
	private Integer status;
	private String title;
	private LocalDateTime localTime;
	private List<String> errors;

	public ErrorResponse(Integer status, String title, LocalDateTime timestamp, List<String> errors) {
		super();
		this.status = status;
		this.title = title;
		this.localTime = timestamp;
		this.errors = errors;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getTimestamp() {
		return localTime;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.localTime = timestamp;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", title=" + title + ", timestamp=" + localTime + ", errors="
				+ errors + "]";
	}

}

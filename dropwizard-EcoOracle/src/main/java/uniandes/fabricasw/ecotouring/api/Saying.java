package uniandes.fabricasw.ecotouring.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class Saying {
	private Long id;

	@Length(max = 3)
	private String content;

	public Saying() {
		// Jackson deserialization
	}

	public Saying(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	@JsonProperty
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("content", content).toString();
	}
}

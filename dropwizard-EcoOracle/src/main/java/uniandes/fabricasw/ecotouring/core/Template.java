package uniandes.fabricasw.ecotouring.core;

import static java.lang.String.format;

import com.google.common.base.Optional;

public class Template {
	private final String content;
	private final String defaultName;

	public Template(String content, String defaultName) {
		this.content = content;
		this.defaultName = defaultName;
	}

	public String render(Optional<String> name) {
		return format(content, name.or(defaultName));
	}
}

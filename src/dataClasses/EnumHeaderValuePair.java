package dataClasses;

import java.util.Objects;
@Deprecated
public class EnumHeaderValuePair {

	private String Header = null;
	private String Value = null;
	
	public EnumHeaderValuePair(String header, String value) {
		this.Header = header;
		this.Value = value;
	}
	

	public final String getHeader() {
		return this.Header;
	}



	public final void setHeader(String header) {
		this.Header = header;
	}



	public final String getValue() {
		return this.Value;
	}



	public final void setValue(String value) {
		this.Value = value;
	}


	@Override
	public String toString() {
		return Header + "=" + Value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Header, Value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnumHeaderValuePair other = (EnumHeaderValuePair) obj;
		return Objects.equals(Header, other.Header) && Objects.equals(Value, other.Value);
	}
}

package dataClasses;

import java.util.Objects;
@Deprecated
public class EnumHeaderValuePair {

	private int hash = 0;
	private EnumHeaderTitles Header = null;
	
	
	public EnumHeaderValuePair(EnumHeaderTitles header) {
		this.Header = header;
		this.hash = hashCode();
	}
	

	public final EnumHeaderTitles getHeader() {
		return this.Header;
	}



	public final void setHeader(EnumHeaderTitles header) {
		this.Header = header;
	}


	@Override
	public String toString() {
		return Header.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(Header);
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
		return Objects.equals(Header, other.Header);
	}
}

package moe.timicasto.qscheme;

public class SchematicMeta {
	public final String title;
	public final String revision;
	public final String publisher;
	public final String date;
	
	public SchematicMeta(String title, String revision, String publisher, String date) {
		this.title = title;
		this.revision = revision;
		this.publisher = publisher;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getRevision() {
		return revision;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getDate() {
		return date;
	}
}

package moe.timicasto.qscheme;

public class SchematicMeta {
	public String title;
	public String revision;
	public String publisher;
	public String date;
	
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

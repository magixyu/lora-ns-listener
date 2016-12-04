package lorapp.nslistener.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="appeuis")
public class AppEUI {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String appEUI;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppEUI() {
		return appEUI;
	}

	public void setAppEUI(String appEUI) {
		this.appEUI = appEUI;
	}
	
	
}

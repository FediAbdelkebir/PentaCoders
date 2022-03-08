package pidev.spring.entities;


import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;







@Entity
public class ChatMessage  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String sender;
	private String content;
	private MessageType type;

	public enum MessageType {
		CHAT, LEAVE, JOIN
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	

	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<User> users;
}

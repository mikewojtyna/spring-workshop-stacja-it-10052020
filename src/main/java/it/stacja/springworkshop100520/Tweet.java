package it.stacja.springworkshop100520;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

	private String msg;
	@Id
	private String id;

	public Tweet(String msg) {
		this.msg = msg;
	}
}

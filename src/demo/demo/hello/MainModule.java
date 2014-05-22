package demo.hello;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

public class MainModule {

	@At("/hello")
	@Ok("jsp:jsp.hello")
	public String doHello() {
		return "Hello Nutz";
	}
}

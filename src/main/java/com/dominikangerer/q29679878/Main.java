package com.dominikangerer.q29679878;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		new HttpRequest("http://example.com/storeFile.php", "POST")
		.part("file", "file.jpg", new File("/your/file.jpg"))
		.part("path", "/the/path/it/should/be/stored/on/the/server/")
		.code();
	}

}

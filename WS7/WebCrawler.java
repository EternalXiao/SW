import java.util.ArrayList;
import java.io.*;
import java.net.URL;
import java.util.regex.*;

public class WebCrawler {
	public static ArrayList<String> collectUrls(String urlString) {
		String s;
		String p = "((https?|ftp|file)://)?www[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		ArrayList<String> l = new ArrayList<>();
		try {
			URL url = new URL(urlString);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			Pattern pattern = Pattern.compile(p);

			while ((s = in.readLine()) != null) {
				Matcher m = pattern.matcher(s);
				while (m.find()) {
					l.add(m.group());
				}
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return l;

	}

	public static void main(String[] args) {
		System.out.println(collectUrls("http://www.cs.bham.ac.uk").toString());
	}
}

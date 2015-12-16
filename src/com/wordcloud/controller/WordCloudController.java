package com.wordcloud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.wordcloud.utils.*;

@Controller
public class WordCloudController {

	@RequestMapping("/")
	public ModelAndView topOccurenceWordList() throws IOException {
		String url = "https://www.parashift.com.au/2015/10/27/real-time-collaboration-in-alfresco/";
		// Map to store word and number of occurences
		Map<String, Integer> mapToStoreTheWordAndCount = new HashMap<String, Integer>();
		String contentOfParashiftBlog;
		// Jsoup library used for parsing HTML
		Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
		// Title of the page
		String mainTitle = doc.title();
		contentOfParashiftBlog = mainTitle + " ";
		Elements headings = doc.select("h2");
		// Get Headings
		for (Element eachHeading : headings)
			contentOfParashiftBlog += " "
					+ eachHeading.toString().replaceAll("<h2>", "")
							.replaceAll("</h2>", "");
		// GetSubheadings
		Elements subheadings = doc.select("h3");
		for (Element eachSubheading : subheadings)
			contentOfParashiftBlog += " "
					+ eachSubheading.toString().replaceAll("<h3>", "")
							.replaceAll("</h3>", "");
		// Description of each heading
		Element el = doc.select("div.entry-content").first();
		contentOfParashiftBlog += " "
				+ el.text().replaceAll("<p>", "").replaceAll("<li>", "")
						.replaceAll("<ul", "");
		System.out.println(contentOfParashiftBlog);
		// Split the string into words to count them
		String[] words = contentOfParashiftBlog.split(" ");
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
			String word = words[i];
			// Replacing small words like "that", "in", "be" etc....
			if (!(word.equals("a") || word.equals("that") || word.equals("")
					|| word.equals("in") || word.equals("or") || word.equals("to")
					|| word.equals("on") || word.equals("on") || word.equals("an")
					|| word.equals("of") || word.equals("as") || word.equals("this")
					|| word.equals("it") || word.equals("be") || word.equals("the")
					|| word.equals("and") || word.equals("is") || word.equals("for"))) {
				word.replaceAll(",", "").replaceAll(".", "");
				// Count the occurence as 1 when the word occurs first time, otherwise
				// increase the counter
				if (mapToStoreTheWordAndCount.get(word) == null) {
					mapToStoreTheWordAndCount.put(word, 1);
				}
				else {
					int count = mapToStoreTheWordAndCount.get(word).intValue();
					count++;
					mapToStoreTheWordAndCount.put(word, count);
				}
			}

		}
		// getting top 25 occurences
		List<String> myTopOccurrence = FindWordWithMaxOccurences(
				mapToStoreTheWordAndCount, 80);
		for (String result : myTopOccurrence) {
			System.out.println(result);
		}
		return new ModelAndView("generateCloud", "message", myTopOccurrence);
	}

	// Use Comparable interface for comparing the occurences
	public static List<String> FindWordWithMaxOccurences(
			Map<String, Integer> map, int n) {
		List<CompareWords> l = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet())
			l.add(new CompareWords(entry.getKey(), entry.getValue()));
		Collections.sort(l);
		List<String> list = new ArrayList<>();
		for (CompareWords w : l.subList(0, n)){
			list.add("{"+"text:"+"\""+w.wordFromMap+"\"" + "," + "weight:" +w.numberOfOccurrence+"}");
			}
			return list;
	}

}

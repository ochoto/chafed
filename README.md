Chafe
=====

Chafe is a web scraping library for Scala. It provides a DSL for fetching web
pages, following links, extracting content, filling in forms and more.

Example
=======

	import chafe._
	for {
	  githubProject <- UserAgent GET("https://github.com/ofrasergreen/chafe")
	  treeBrowser <- githubProject $(".tree-browser")
	  readmePage <- treeBrowser click("README.md")
	  readme <- readmePage click$("#raw-url")
	} println(readme)

This uses Scala's for-comprehension to compose a set of actions to:

1. Fetch Chafe's github project page.
1. Extract the project tree browser by using a CSS selector to find a tag with
   the *tree-browser* class.
1. Click the link containing the text "README.md".
1. Click the link to the "RAW" content using a CSS selector to find a tag
   with the *raw-url* ID.
1. Print its content.

See [samples](chafe/tree/master/samples) for more examples.

Usage
=====


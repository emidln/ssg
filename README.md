# ssg

This is a spartan static site generator and so should your needs be.
It has one useful function, `render-pages` that takes an output directory 
(as a string) and a map of filenames (as strings) to hiccup data. That
data is render into html and put in the requested filenames relative to
output-dir.

## Usage

Put this in your project.clj:

[![Clojars Project](http://clojars.org/com.emidln/ssg/latest-version.svg)](http://clojars.org/com.emidln/ssg)

and then use it like this:

```clj
(require 'ssg.core)
(ssg.core/render-pages "example/output/" 
         {"index.html" [:html [:body [:h1 "Hello World"]]]
          "page2.html" [:p "incomplete fragment on page 2"]})
```

## License

Copyright © 2015 Brandon Adams <emidln@gmail.com>

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

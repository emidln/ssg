(ns ssg.core
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [hiccup.core :as hiccup]))

(defn prepend-output
  [path filename]
  (str/join "/" [path filename]))

(defn prepare-pages
  [output-dir pages]
  (into {}
        (for [[page contents] pages]
          [(prepend-output output-dir page) contents])))

(defn render-to-file
  "Renders contents via hiccup to a path."
  [path contents]
  (let [contents (hiccup/html contents)]
    (io/make-parents path)
    (spit path contents)))

(defn render-pages
  "Pass a directory and a map of filenames to hiccup data"
  [output-dir pages]
  (->> (prepare-pages output-dir pages)
       (mapv (partial apply render-to-file))))

(comment

  (def some-html
    [:html
     [:head
      [:title "Hello World"]]
     [:body
      [:h1 "Hello World"]]])

  (def pages
    {"index.html" some-html
     "page2.html" [:html [:p.foo "page 2"]]})

  (render-pages "example/output/" pages)

)

(def project 'thedavidmeister/clj-github)
(def description "Simple wrapper around github endpoints")
(def version "0.1.0-SNAPSHOT")
(def url "https://github.com/thedavidmeister/clj-github")

(set-env!
 :source-paths #{"src"}
 :dependencies
 '[[org.clojure/clojure "1.9.0-alpha19"]
   [adzerk/bootlaces "0.1.13" :scope "test"]])

(task-options!
 pom {:project project
      :version version
      :description description
      :url url
      :scm {:url url}})

(require
 '[adzerk.bootlaces :refer :all])
(bootlaces! version)

(deftask deploy
 []
 (comp
  (build-jar)
  (push-snapshot)))

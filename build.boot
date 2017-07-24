(def project 'rum-bug-class)
(def version "0.1.0-SNAPSHOT")

(set-env! :source-paths #{"src"}
          :dependencies '[[org.clojure/clojure "1.9.0-alpha17"]
                          [org.clojure/clojurescript "1.9.671"]
                          [rum "0.10.8"]
                          [adzerk/boot-cljs "2.0.0"]
                          [onetom/boot-lein-generate "0.1.3" :scope "test"]])

(require '[boot.lein])
(require '[adzerk.boot-cljs :refer [cljs]])
(require '[rum-bug-class.server :as app])

(deftask run
         "Build the html and the javascript. Run it then open index.html in your browser."
         []
         (comp (with-pre-wrap fileset
                              (app/-main)
                              fileset)
               (cljs :compiler-options {:main 'rum-bug-class.browser
                                        :source-map true
                                        :optimizations :none
                                        :asset-path "target/main.out"})
               (target :dir #{"target"})))

(deftask lein-generate
         "For Cursive IDE users : generates project.clj from build.boot file so that Cursive understand our code."
         []
         (boot.lein/generate))
